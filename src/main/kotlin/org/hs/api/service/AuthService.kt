package org.hs.api.service

import org.hs.api.repository.Accounts
import org.hs.api.web.payload.LoginDto
import org.springframework.stereotype.Service

@Service
class AuthService(private val accounts: Accounts) {

    fun login(loginDto: LoginDto): Boolean {
        val account = accounts.findByEmail(loginDto.email)
        if (account.password != loginDto.password) {
            return false
        }
        return true
    }

}