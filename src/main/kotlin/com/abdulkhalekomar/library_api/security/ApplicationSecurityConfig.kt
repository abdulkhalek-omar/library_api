package com.abdulkhalekomar.library_api.security

import com.abdulkhalekomar.library_api.security.enums.ApplicationRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


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
			.httpBasic()
			.and()
			.sessionManagement {
				// set url when session invalid (when session invalid app use this url for redirect to specific page)
					session ->
				session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
					.invalidSessionUrl("/logout?expired")
					// set maximum session (only Single user can Log in into app in same time/concurrent)
					.maximumSessions(1)
					// second login will cause the first to be invalidated
					.maxSessionsPreventsLogin(false)
			}
			.logout { logout ->
				logout.deleteCookies("JSESSIONID").invalidateHttpSession(true) // this end point can access if user already login and access token valid with role "USER"
			}
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
