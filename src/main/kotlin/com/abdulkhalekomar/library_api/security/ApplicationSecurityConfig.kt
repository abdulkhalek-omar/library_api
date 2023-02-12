package com.abdulkhalekomar.library_api.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class ApplicationSecurityConfig {
	@Bean
	fun filterChain(http: HttpSecurity): SecurityFilterChain {
		http
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET, "/index.html")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
		return http.build()
	}


}
