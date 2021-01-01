package org.hs.api.service

import org.hs.api.repository.ChatRooms
import org.springframework.stereotype.Service

@Service
class ChatService(private val chatrooms: ChatRooms ) {

    fun getList() = chatrooms.getList()

}