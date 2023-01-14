package com.abdulkhalekomar.library_api.validation_helpers


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {
	companion object {
		private const val REQUEST_VALIDATION_ERRORS = "Request validation errors"
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException::class)
	fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
		val details = mutableListOf<String>()
		for (error in ex.bindingResult.allErrors) {
			details.add(error.defaultMessage!!)
		}
		val error = ErrorResponse(REQUEST_VALIDATION_ERRORS, details)
		return ResponseEntity(error, HttpStatus.BAD_REQUEST)
	}
}

data class ErrorResponse(val error: String, val details: List<String>)
