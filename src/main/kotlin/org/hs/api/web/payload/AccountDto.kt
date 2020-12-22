package org.hs.api.web.payload

import org.hs.api.domain.Account

class AccountDto {
    var email: String = ""
    var username: String = ""

}

fun createAccountDto(account: Account): AccountDto {
    val accountDto = AccountDto()
    accountDto.email = account.email
    accountDto.username = account.username

    return accountDto
}