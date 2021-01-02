package org.hs.api.web

import org.hs.api.service.TimerService
import org.hs.api.web.payload.TimerDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/timer")
class TimerController(private val timerService: TimerService) {

    @PostMapping
    fun saveTime(@RequestBody timerDto: TimerDto): ResponseEntity<Any> {
        timerService.save(timerDto)
        return ResponseEntity.ok().build()
    }

}