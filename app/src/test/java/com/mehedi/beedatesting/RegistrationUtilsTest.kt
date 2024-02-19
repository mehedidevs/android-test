package com.mehedi.beedatesting


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Philipp",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Philipp",
            "123456",
            "abcdefg"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Philipp",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Philipp",
            "abcdefg5",
            "abcdefg5"
        )
        assertThat(result).isFalse()
    }

}