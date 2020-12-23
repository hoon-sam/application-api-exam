package org.hs.api.web.payload

import javax.validation.constraints.NotBlank

class LoginDto(
        @field:NotBlank
        val email: String,
        @field:NotBlank
        val password: String
)