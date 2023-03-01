package com.abdulkhalekomar.library_api.auth

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthenticationController(
	private val service: AuthenticationService,
) {
	@PostMapping("/register")
	fun register(@RequestBody request: RegisterRequest): AuthenticationResponse {
		return service.register(request)
	}

	@PostMapping("/authenticate")
	fun authenticate(@RequestBody request: AuthenticationRequest): AuthenticationResponse {
		return service.authenticate(request)
	}

}
