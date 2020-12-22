package org.hs.api.web.payload

import javax.validation.constraints.NotBlank

class LoginDto(
        @NotBlank
        val email: String,
        @NotBlank
        val password: String
)