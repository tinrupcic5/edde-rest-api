package com.bitroot.ai.edde.domain.controller;

import com.bitroot.ai.edde.communication.ModelChat;
import com.bitroot.ai.edde.domain.model.ChatMessageRequest;
import com.bitroot.ai.edde.domain.model.ChatMessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat/")
public class ChatController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);

    private final ModelChat modelChat;

    @Autowired
    public ChatController(ModelChat modelChat) {
        this.modelChat = modelChat;
    }

    @GetMapping
    public ResponseEntity<ChatMessageResponse> chatWithEdde(@RequestBody ChatMessageRequest chatMessageRequest) {
        LOGGER.info("Human: {}", chatMessageRequest.getPrompt());
        var chatMessageResponse = new ChatMessageResponse(modelChat.chatWithModel(chatMessageRequest.getPrompt()));

        return ResponseEntity.ok(chatMessageResponse);
    }
}
