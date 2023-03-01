package com.abdulkhalekomar.library_api.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.security.Key
import java.util.Date
import java.util.function.Function


@Service
class JwtService {
	private val SECRET_KEY: String = "6A576D5A7134743777217A25432A462D4A614E645267556B5870327235753878"

	fun generateToken(userDetails: UserDetails): String {
		return generateToken(HashMap(), userDetails)
	}

	fun generateToken(extraClaims: Map<String, Any>, userDetails: UserDetails): String {
		return Jwts
			.builder()
			.setClaims(extraClaims)
			.setSubject(userDetails.username)
			.setIssuedAt(Date(System.currentTimeMillis()))
			.setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 24))
			.signWith(getSignInKey(), SignatureAlgorithm.HS256)
			.compact()
	}

	fun extractUsername(token: String): String? {
		return extractClaim(token, Claims::getSubject)
	}

	fun <T> extractClaim(token: String, claimsResolver: Function<Claims, T>): T {
		val claims = extractAllClaims(token)
		return claimsResolver.apply(claims)
	}

	private fun extractAllClaims(token: String): Claims {
		return Jwts
			.parserBuilder()
			.setSigningKey(getSignInKey())
			.build()
			.parseClaimsJws(token)
			.body
	}

	private fun getSignInKey(): Key {
		val keyBytes: ByteArray = Decoders.BASE64.decode(SECRET_KEY)
		return Keys.hmacShaKeyFor(keyBytes)
	}

	fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
		val username: String = extractUsername(token)!!
		return (username == userDetails.username) && !isTokenExpired(token)
	}

	private fun isTokenExpired(token: String): Boolean {
		return extractExpiration(token).before(Date())
	}

	private fun extractExpiration(token: String): Date {
		return extractClaim(token, Claims::getExpiration)
	}
}
