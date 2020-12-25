package org.hs.api.service

import org.hs.api.repository.ChatRoomRepository
import org.springframework.stereotype.Service

@Service
class ChatService(private val chatRoomRepository: ChatRoomRepository ) {

    fun getList() = chatRoomRepository.getList()

}