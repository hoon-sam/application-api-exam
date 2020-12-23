package org.hs.api.repository

import org.hs.api.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface Accounts : JpaRepository<Account, Long> {
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): Account
}