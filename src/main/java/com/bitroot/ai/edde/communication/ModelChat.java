package com.bitroot.ai.edde.communication;


import com.bitroot.ai.edde.domain.controller.ChatController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelChat {

    private final ChatService chatService;

    @Autowired
    public ModelChat(ChatService chatService) {
        this.chatService = chatService;
    }

    public String chatWithModel(String userPrompt) {
        return chatService.chat(userPrompt)
                .join();
    }
}
