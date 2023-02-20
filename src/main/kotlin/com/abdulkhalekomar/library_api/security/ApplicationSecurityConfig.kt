package com.abdulkhalekomar.library_api.security

import com.abdulkhalekomar.library_api.auth.ApplicationUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.util.concurrent.TimeUnit


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class ApplicationSecurityConfig(
	@Autowired private val passwordEncoder: PasswordEncoder,
	@Autowired private val applicationUserService: ApplicationUserService,
) {
	@Bean
	fun filterChain(http: HttpSecurity): SecurityFilterChain {
		http
			.csrf().disable() // TODO: Edit Following
			.authenticationProvider(daoAuthenticationProvider())
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET, "/index.html").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.defaultSuccessUrl("/users", true)
			.passwordParameter("password")
			.usernameParameter("username")
			.and()
			.rememberMe()
			.tokenValiditySeconds(TimeUnit.DAYS.toSeconds(21).toInt())
			.key("somethingverysecured")
			.rememberMeParameter("remember-me")
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutRequestMatcher(AntPathRequestMatcher("/logout", "GET")) // Must be Post (when enable csrf)
			.clearAuthentication(true)
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID", "remember-me")
			.logoutSuccessUrl("/login")
		return http.build()
	}

	@Bean
	fun daoAuthenticationProvider(): DaoAuthenticationProvider {
		val daoAuthenticationProvider = DaoAuthenticationProvider()
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder)
		daoAuthenticationProvider.setUserDetailsService(applicationUserService)
		return daoAuthenticationProvider
	}
}
