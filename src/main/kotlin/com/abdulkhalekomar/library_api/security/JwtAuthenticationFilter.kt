package com.abdulkhalekomar.library_api.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.lang.NonNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

/**
 * Each time the user sends a request, the filter is triggered
 */

@Component
class JwtAuthenticationFilter(
	private val jwtService: JwtService,
	private val userDetailsService: UserDetailsService,
) : OncePerRequestFilter() {
	override fun doFilterInternal(@NonNull request: HttpServletRequest, @NonNull response: HttpServletResponse, @NonNull filterChain: FilterChain) {
		val authHeader: String? = request.getHeader("Authorization")
		val jwt: String?

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response)
			return
		}
		jwt = authHeader.substring(7)
		val userEmail: String? = jwtService.extractUsername(jwt)

		if (userEmail != null && SecurityContextHolder.getContext().authentication == null) {
			val userDetails: UserDetails = this.userDetailsService.loadUserByUsername(userEmail)
			if (jwtService.isTokenValid(jwt, userDetails)) {
				val authToken = UsernamePasswordAuthenticationToken(
					userDetails,
					null,
					userDetails.authorities
				)
				authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
				SecurityContextHolder.getContext().authentication = authToken
			}
		}
		filterChain.doFilter(request, response)
	}
}
