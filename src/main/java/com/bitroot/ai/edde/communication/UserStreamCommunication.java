package com.bitroot.ai.edde.communication;

import java.util.concurrent.CompletableFuture;

public interface UserStreamCommunication {
    CompletableFuture<String> chat(String prompt);
}
