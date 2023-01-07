package com.abdulkhalekomar.library_api.validation_helpers.annotations

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import jakarta.validation.constraints.Pattern
import java.time.LocalDateTime
import java.time.format.DateTimeParseException
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [DateFormatValidator::class])
@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")
@Target(AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DateFormat(
    val message: String = "Invalid date format",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)

class DateFormatValidator : ConstraintValidator<DateFormat, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return true
        }
        try {
            LocalDateTime.parse(value)
        } catch (e: DateTimeParseException) {
            return false
        }
        return true
    }
}
