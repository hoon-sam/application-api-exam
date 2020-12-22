package org.hs.api.service

import org.hs.api.domain.Account
import org.hs.api.repository.Accounts
import org.springframework.stereotype.Service

@Service
class AccountService(private val accounts: Accounts) {

    fun findByEmail(email: String): Account = accounts.findByEmail(email)

}