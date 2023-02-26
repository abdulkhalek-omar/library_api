package com.abdulkhalekomar.library_api.security

import com.abdulkhalekomar.library_api.auth.ApplicationUserService
import com.abdulkhalekomar.library_api.jwt.JwtUsernameAndPasswordAuthenticationFilter
import com.abdulkhalekomar.library_api.security.enums.ApplicationRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


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
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authenticationProvider(daoAuthenticationProvider())
			.addFilter(JwtUsernameAndPasswordAuthenticationFilter())
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET, "/index.html").permitAll()
			.requestMatchers(HttpMethod.GET, "/api/**").hasRole(ApplicationRole.USER.name)
			.anyRequest()
			.authenticated()
		return http.build()
	}

	@Bean
	fun daoAuthenticationProvider(): DaoAuthenticationProvider {
		val daoAuthenticationProvider = DaoAuthenticationProvider()
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder)
		daoAuthenticationProvider.setUserDetailsService(applicationUserService)
		return daoAuthenticationProvider
	}

	@Bean
	fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
		return authenticationConfiguration.authenticationManager
	}
}
