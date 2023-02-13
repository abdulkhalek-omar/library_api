package com.abdulkhalekomar.library_api.security

import com.abdulkhalekomar.library_api.security.enums.ApplicationRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class ApplicationSecurityConfig(
	@Autowired private val passwordEncoder: PasswordEncoder,
) {


	@Bean
	fun filterChain(http: HttpSecurity): SecurityFilterChain {
		http
			.csrf().disable() // TODO: Edit Following
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET, "/index.html").permitAll()
			.requestMatchers("/api/**").hasRole(ApplicationRole.USER.name)
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
		return http.build()
	}

	@Bean
	fun users(): UserDetailsService {
		val admin = User.builder()
			.username("admin")
			.password(passwordEncoder.encode("password"))
			.roles(ApplicationRole.ADMIN.name) // ROLE_ADMIN
			.build()
		val adminTrainee = User.builder()
			.username("admin_trainee")
			.password(passwordEncoder.encode("password"))
			.roles(ApplicationRole.ADMINTRAINEE.name) // ROLE_ADMINTRAINEE
			.build()
		val user = User.builder()
			.username("user")
			.password(passwordEncoder.encode("password"))
			.roles(ApplicationRole.USER.name) // ROLE_USER
			.build()

		return InMemoryUserDetailsManager(admin, adminTrainee, user)
	}
}
