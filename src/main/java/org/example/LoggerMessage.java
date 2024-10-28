package org.example;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.logging.Logger;

public class LoggerMessage {

    private Logger logger = Logger.getLogger(LoggerMessage.class.getName());
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_RESET = "\u001B[0m";


    public void logRequest(Update update){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ANSI_YELLOW);
        stringBuilder.append("------request------").append("\n");
        stringBuilder.append("user:").append(update.getMessage().getFrom().getUserName()).append("\n");
        stringBuilder.append("chatID:").append(update.getMessage().getChatId()).append("\n");
        stringBuilder.append("text:").append(update.getMessage().getText()).append("\n");
        stringBuilder.append("-----------------------");
        stringBuilder.append(ANSI_RESET);
        logger.info(stringBuilder.toString());
    }

    public void logResponse(Update update, String textResponse) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(ANSI_GREEN);
        stringBuilder.append("------response------").append("\n");
        stringBuilder.append("user:").append(update.getMessage().getFrom().getUserName()).append("\n");
        stringBuilder.append("chatID:").append(update.getMessage().getChatId()).append("\n");
        stringBuilder.append("response:").append(textResponse).append("\n");
        stringBuilder.append("-----------------------");
        stringBuilder.append(ANSI_RESET);
        logger.info(stringBuilder.toString());
    }
}
