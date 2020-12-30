package org.hs.api

import org.hs.api.domain.Account
import org.hs.api.repository.Accounts
import org.hs.api.web.payload.JoinDto
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class Application {

    @Bean
    fun initializer(accounts: Accounts) = CommandLineRunner {
        val joinDto = JoinDto()
        joinDto.email = "admin@co.kr"
        joinDto.username = "admin"
        joinDto.password = "1111"
        val account = Account.create(joinDto)
        accounts.save(account)
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
