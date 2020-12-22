package org.hs.api.domain

import org.hs.api.web.payload.JoinDto
import javax.persistence.*

@Entity
data class Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0L,
        @Column(unique = true, nullable = false, length = 30)
        var email: String = "",
        @Column(nullable = false, length = 20)
        var username: String = "",
        @Column(nullable = false, length = 100)
        var password: String =""
) : DateAudit() {

        companion object {
                fun create(joinDto: JoinDto): Account {
                        val account = Account()
                        account.email = joinDto.email
                        account.username = joinDto.username
                        account.password = joinDto.password

                        return account
                }
        }


}