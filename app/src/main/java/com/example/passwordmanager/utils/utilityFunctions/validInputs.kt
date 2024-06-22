package com.example.passwordmanager.utils.utilityFunctions

 fun validateInputs(accountName: String, userCredential: String, password: String): List<String> {
    val errors = mutableListOf<String>()

    if (accountName.length <= 3) {
        errors.add("Account Name must be greater than 3 characters")
    }

    if (userCredential.length <= 3) {
        errors.add("User Credential must be greater than 3 characters")
    }

     if (!isPasswordValid(password)) {
         errors.add("Password must be at least 8 characters long and include uppercase, lowercase, and a number")
     }

    return errors
}