package org.hs.api.service

import org.hs.api.domain.Timer
import org.hs.api.repository.Accounts
import org.hs.api.repository.Timers
import org.hs.api.web.payload.TimerDto
import org.springframework.stereotype.Service

@Service
class TimerService(
        private val timers: Timers,
        private val accounts: Accounts
) {

    fun save(timerDto: TimerDto) {
        val account = accounts.findByEmail(timerDto.email)
        val timer = Timer.create(timerDto, account)
        timers.save(timer)
    }

}