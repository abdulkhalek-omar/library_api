package com.abdulkhalekomar.library_api.security

import com.abdulkhalekomar.library_api.security.enums.ApplicationRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.util.concurrent.TimeUnit


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class ApplicationSecurityConfig(
	@Autowired private val passwordEncoder: PasswordEncoder,
) {
	@Bean
	fun filterChain(http: HttpSecurity): SecurityFilterChain {
		http
			.csrf().disable() // TODO: Edit Following
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
	fun users(): UserDetailsService {
		val admin = User.builder()
			.username("admin")
			.password(passwordEncoder.encode("password"))
			.authorities(ApplicationRole.ADMIN.getGrantedAuthorities())
			.build()
		val adminTrainee = User.builder()
			.username("admin_trainee")
			.password(passwordEncoder.encode("password"))
			.authorities(ApplicationRole.ADMINTRAINEE.getGrantedAuthorities())
			.build()
		val user = User.builder()
			.username("user")
			.password(passwordEncoder.encode("password"))
			.authorities(ApplicationRole.USER.getGrantedAuthorities())
			.build()

		return InMemoryUserDetailsManager(admin, adminTrainee, user)
	}
}
