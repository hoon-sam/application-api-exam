package org.hs.api.web

import org.hs.api.domain.Account
import org.hs.api.repository.Accounts
import org.hs.api.web.payload.JoinDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
internal class AuthControllerTest(
        @Autowired val mockMvc: MockMvc,
        @Autowired val accounts: Accounts
) {

//    @BeforeEach
//    fun insertAccount() {
//        val joinDto = JoinDto()
//        joinDto.email = "admin@co.kr"
//        joinDto.username = "admin"
//        joinDto.password = "1111"
//        val account = Account.create(joinDto)
//        accounts.save(account)
//    }

    @Test
    fun login_test() {
        val json = """
            {"email": "admin@co.kr", "password": "1111"}
        """.trimIndent()

        mockMvc.post("/api/auth/login") {
            contentType = MediaType.APPLICATION_JSON
            content = json
        }
            .andDo{ print() }
            .andExpect{ status().isOk }
    }
}