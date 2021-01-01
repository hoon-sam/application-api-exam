package org.hs.api.domain

import org.hs.api.repository.Timers
import org.hs.api.web.payload.JoinDto
import org.hs.api.web.payload.TimerDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Timer(
        @Id
        @GeneratedValue
        val id: Long = 0L,
        @ManyToOne
        var account: Account = Account(),
        var time: Long = 0L,
) : DateAudit() {
        companion object {
                fun create(timerDto: TimerDto, account: Account): Timer {
                        val timer = Timer()
                        timer.account = account
                        timer.time = timerDto.time
                        return timer
                }
        }
}