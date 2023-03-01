package com.abdulkhalekomar.library_api.auth

import com.abdulkhalekomar.library_api.security.JwtService
import com.abdulkhalekomar.library_api.user.IUserRepository
import com.abdulkhalekomar.library_api.user.User
import com.abdulkhalekomar.library_api.user.UserRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService @Autowired constructor(
	private val repository: IUserRepository,
	private val passwordEncoder: PasswordEncoder,
	private val jwtService: JwtService,
	private val authenticationManager: AuthenticationManager,
) {
	fun register(request: RegisterRequest): AuthenticationResponse {
		val user = User(
			firstName = request.firstName,
			lastName = request.lastName,
			phone = request.phone,
			email = request.email,
			password = passwordEncoder.encode(request.password),
			userRole = UserRole.USER,
		)
		repository.save(user)
		val jwtToken = jwtService.generateToken(user)
		return AuthenticationResponse(
			token = jwtToken
		)
	}

	fun authenticate(request: AuthenticationRequest): AuthenticationResponse {
		authenticationManager.authenticate(
			UsernamePasswordAuthenticationToken(
				request.email,
				request.password,
			)
		)
		val user = repository.findByEmail(request.email!!).orElseThrow()
		val jwtToken = jwtService.generateToken(user)
		return AuthenticationResponse(
			token = jwtToken
		)
	}
}
