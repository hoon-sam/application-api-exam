package org.hs.api.web

import org.hs.api.service.AccountService
import org.hs.api.service.AuthService
import org.hs.api.web.payload.LoginDto
import org.hs.api.web.payload.createAccountDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(
        private val authService: AuthService,
        private val accountService: AccountService) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody loginDto: LoginDto): ResponseEntity<Any> {
        val result = authService.login(loginDto)
        if (!result) {
            return ResponseEntity.badRequest().build()
        }
        val account = accountService.findByEmail(loginDto.email)
        val accountDto = createAccountDto(account)
        return ResponseEntity.ok(accountDto)
    }


}