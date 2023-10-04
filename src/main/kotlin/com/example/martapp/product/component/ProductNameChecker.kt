package com.example.martapp.product.component

import org.springframework.stereotype.Component

@Component
class ProductNameChecker {

    fun isNameValid(name: String): ValidationResult {
        return when {
            name.length > 10 -> ValidationResult.TooLong
            !name.contains(Regex("[a-zA-Z]")) -> ValidationResult.NoEnglishCharacters
            else -> ValidationResult.Valid
        }
    }

    sealed class ValidationResult {
        object Valid : ValidationResult()
        object TooLong : ValidationResult()
        object NoEnglishCharacters : ValidationResult()
    }
}
