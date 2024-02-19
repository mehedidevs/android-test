package com.mehedi.beedatesting

object RegistrationUtils {
    private val existingUsers = listOf("Peter", "Carl")

    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits
     */

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        } else if (username in existingUsers) {
            return false
        } else if (password != confirmedPassword) {
            return false
        } else if (password.count { it.isDigit() } < 2) {
            return false
        } else {
            return true
        }


    }


}
