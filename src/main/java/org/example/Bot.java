package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

public class Bot extends TelegramLongPollingBot {
    private LoggerMessage loggerMessage =  new LoggerMessage();
    private MessageHandler messageHandler = new MessageHandler();



    public Bot(String token) {
        super(token);
    }



    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        String textResponse = messageHandler.requestHandler(message);

        loggerMessage.logRequest(update);
        loggerMessage.logResponse(update,textResponse);

        sendMessage(update, textResponse);


    }
    private  void sendMessage(Update update, String textResponse){
        Long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textResponse);

        try {
            execute(sendMessage);

        }catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getBotUsername() {
        return "Hi_by1111_bot";
    }
}
