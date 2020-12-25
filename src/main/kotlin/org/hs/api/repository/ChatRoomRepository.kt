package org.hs.api.repository

import org.hs.api.domain.ChatRoom
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository
class ChatRoomRepository {

    fun getList(): List<ChatRoom> {
        val rooms = ArrayList<ChatRoom>()
        for (i in 1..10) {
            val room = ChatRoom(UUID.randomUUID().toString(), "${i}번 째 방")
            rooms.add(room)
        }
        return rooms
    }

}