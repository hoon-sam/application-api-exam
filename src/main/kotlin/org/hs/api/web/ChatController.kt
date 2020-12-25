package org.hs.api.web

import org.hs.api.service.ChatService
import org.hs.api.web.payload.ChatMessage
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(private val chatService: ChatService) {

    @GetMapping("/rooms")
    fun getRooms() = ResponseEntity.ok(chatService.getList())

    @MessageMapping("/{roomId}")
    @SendTo("/subscribe/{roomId}")
    fun greeting(@DestinationVariable roomId: String, message: ChatMessage) = message



}