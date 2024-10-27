package com.bitroot.ai.edde.communication;


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
