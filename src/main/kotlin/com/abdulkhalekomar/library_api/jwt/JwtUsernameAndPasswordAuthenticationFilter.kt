package com.abdulkhalekomar.library_api.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.time.LocalDate
import java.util.*

class JwtUsernameAndPasswordAuthenticationFilter(
	@Autowired private val authenticationManager: AuthenticationManager,
) : UsernamePasswordAuthenticationFilter() {
	@Throws(AuthenticationException::class)
	override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication? {
		return try {
			/** client credentials */
			val authenticationRequest = ObjectMapper().readValue(request.inputStream, UsernameAndPasswordAuthenticationRequest::class.java)

			val authentication: Authentication = UsernamePasswordAuthenticationToken(
				authenticationRequest.username, authenticationRequest.password
			)
			/** validate client credentials */
			authenticationManager.authenticate(authentication)
		} catch (e: IOException) {
			throw RuntimeException(e)
		}
	}

	/**
	 * invoke after attemptAuthentication executed without expansion
	 */
	override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse, chain: FilterChain?, authResult: Authentication) {

		/** create Token */
		val key = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecure"
		val token = Jwts.builder()
			.setSubject(authResult.name)
			.claim("authorities", authResult.authorities)
			.setIssuedAt(Date())
			.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
			.signWith(Keys.hmacShaKeyFor(key.toByteArray()))
			.compact()

		/** send it to client */
		response.addHeader("Authorization", "Bearer $token")

	}
}

