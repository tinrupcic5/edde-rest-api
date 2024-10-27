package com.bitroot.ai.edde.communication;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.TokenStream;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@Service
public class ChatService implements UserStreamCommunication, ModelCommunication {

    @Value("${ollama.host}")
    private String OLLAMA_HOST;
    @Value("${ollama.model.name}")
    private String MODEL_NAME;


    private  ModelCommunication assistant;

    @PostConstruct
    public void init() {
        StreamingChatLanguageModel languageModel = connectModel(OLLAMA_HOST, MODEL_NAME);
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        this.assistant = AiServices.builder(ModelCommunication.class)
                .streamingChatLanguageModel(languageModel)
                .chatMemory(chatMemory)
                .build();
    }

    @Override
    public CompletableFuture<String> chat(String userPrompt) {
        TokenStream tokenStream = chatWithModel(userPrompt);
        CompletableFuture<String> future = new CompletableFuture<>();
        StringBuilder responseBuilder = new StringBuilder();

        tokenStream.onNext(responseBuilder::append)
                .onComplete(ss -> future.complete(responseBuilder.toString()))
                .onError(future::completeExceptionally)
                .start();

        return future;
    }

    @Override
    public TokenStream chatWithModel(String message) {
        return assistant.chatWithModel(message);
    }

    private static StreamingChatLanguageModel connectModel(String url, String modelName) {
        return OllamaStreamingChatModel.builder()
                .baseUrl(url)
                .modelName(modelName)
                .timeout(Duration.ofHours(1))
                .build();
    }
}
