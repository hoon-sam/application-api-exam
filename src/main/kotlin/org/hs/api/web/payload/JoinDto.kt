package org.hs.api.web.payload

import javax.validation.constraints.NotBlank

class JoinDto (
        @NotBlank
        var email: String = "",
        @NotBlank
        var username: String = "",
        @NotBlank
        var password: String = ""
)