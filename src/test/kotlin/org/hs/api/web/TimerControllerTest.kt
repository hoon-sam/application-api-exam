package org.hs.api.web

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class TimerControllerTest(
    @Autowired
    val mockMvc: MockMvc
) {

    @Test
    fun test_save() {

        val json = """
            {"email": "admin@co.kr", "time": 1000}
        """.trimIndent()

        mockMvc.post("/api/timer") {
            contentType = MediaType.APPLICATION_JSON
            content = json
        }.andDo { print() }
            .andExpect { status { isOk() } }
    }

}