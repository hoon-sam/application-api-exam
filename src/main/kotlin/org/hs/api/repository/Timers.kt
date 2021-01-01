package org.hs.api.repository

import org.hs.api.domain.Timer
import org.springframework.data.jpa.repository.JpaRepository

interface Timers : JpaRepository<Timer, Long>