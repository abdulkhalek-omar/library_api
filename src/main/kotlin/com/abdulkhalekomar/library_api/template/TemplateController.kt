package com.abdulkhalekomar.library_api.template

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class TemplateController {
	@GetMapping("login")
	fun getLoginView(): String = "login"

	@GetMapping("users")
	fun getUsersView(): String = "users"

}
