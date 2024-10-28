package org.example;

import org.nfunk.jep.JEP;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Voice;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {

    public String requestHandler(Message message) {


        if (message.hasText()) {
            String textMessage = message.getText().trim();
            return messageHandler(textMessage);
        } else if (message.hasPhoto()) {
            List<PhotoSize> photoSizes = new ArrayList<>();
            return photoSizes.toString();

        } else if (message.hasVoice()) {
            List<Voice> voices = new ArrayList<>();
            return voices.toString();

        }
        return "бот принимает запросы в виде сообщения";
    }

    private String messageHandler(String textMessage) {
        JEP jep = new JEP();
        jep.parseExpression(textMessage);
        double result = jep.getValue();
        return "Ответ: "+result;
    }
}