package com.abdulkhalekomar.library_api.validation_helpers.annotations

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import jakarta.validation.constraints.Pattern
import kotlin.reflect.KClass


@Constraint(validatedBy = [NumericValidator::class])
@Pattern(regexp = "^[0-9]*$")
@Target(AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Numeric(
    val message: String = "Invalid numeric value",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)

class NumericValidator : ConstraintValidator<Numeric, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return true
        }
        return value.matches(Regex("^[0-9]*$"))
    }
}