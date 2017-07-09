package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by User on 29.06.2017.
 */
public class BotClient extends Client {
    public class BotSocketThread extends Client.SocketThread {
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
    /*а) С помощью метода sendTextMessage() отправь сообщение с текстом
    «Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.»*/
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
    /*б) Вызови реализацию clientMainLoop() родительского класса.*/
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            if (message.contains(":")) {

                String name = message.substring(0, message.indexOf(":"));
                String text = message.substring(message.indexOf(":") + 2);

                SimpleDateFormat dateFormat = null;

                if (text.equals("дата")) {
                    dateFormat = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                } else if (text.equals("день")) {
                    dateFormat = new SimpleDateFormat("d");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                } else if (text.equals("месяц")) {
                    dateFormat = new SimpleDateFormat("MMMM");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                } else if (text.equals("год")) {
                    dateFormat = new SimpleDateFormat("YYYY");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                } else if (text.equals("время")) {
                    dateFormat = new SimpleDateFormat("H:mm:ss");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                } else if (text.equals("час")) {
                    dateFormat = new SimpleDateFormat("H");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                } else if (text.equals("минуты")) {
                    dateFormat = new SimpleDateFormat("m");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                } else if (text.equals("секунды")) {
                    dateFormat = new SimpleDateFormat("s");
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                }
            }
        }

        //2. Переопредели метод processIncomingMessage(String message). Он должен следующим образом обрабатывать входящие сообщения:


/**/

        //б) Получить из message имя отправителя и текст сообщения. Они разделены «: «.


        /*в) Отправить ответ в зависимости от текста принятого сообщения.
        Если текст сообщения:
        «дата» – отправить сообщение содержащее текущую дату в формате «d.MM.YYYY«;
        «день» – в формате «d«;
        «месяц» — «MMMM«;
        «год» — «YYYY«;
        «время» — «H:mm:ss«;
        «час» — «H«;
        «минуты» — «m«;
        «секунды» — «s«.
        Боб отправил запрос «время«, мы должны отправить ответ «Информация для Боб: 12:30:47«.

    }*/


        // а) getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
        protected SocketThread getSocketThread() {
            BotSocketThread botSocketThread = new BotSocketThread();
            return botSocketThread;
        }

        // б) shouldSendTextFromConsole(). Он должен всегда возвращать false. Мы не хотим, чтобы бот отправлял текст введенный в консоль.
        protected boolean shouldSendTextFromConsole() {
            return false;
        }

        // в) getUserName(), метод должен генерировать новое имя бота, например: date_bot_XX, где XX – любое число от 0 до 99.
        // Для генерации XX используй метод Math.random().
        protected String getUserName() throws IOException {
            int XX = (int) (Math.random() * 100);
            String userName = "date_bot_" + XX;
            return userName;
        }
    }
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
