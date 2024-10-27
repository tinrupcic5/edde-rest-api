package com.bitroot.ai.edde.domain.model;

public class ChatMessageResponse {
    private String messageResponse;

    public ChatMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
