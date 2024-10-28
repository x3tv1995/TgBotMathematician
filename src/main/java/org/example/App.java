package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws TelegramApiException {
        Bot bot = new Bot("7295275822:AAEBC_--iq_ZNi2O3vf00RWK0R2-3tfzy24");

        TelegramBotsApi telegramBot = new TelegramBotsApi(DefaultBotSession.class);
        telegramBot.registerBot(bot);

    }
}
