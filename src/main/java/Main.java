import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        /**
         * ECR подготавливает итоговый счет
         */

        System.out.println("""
                UI ECR:
                \tОжидается платеж за товар:
                \tИд: 456
                \tНазвание: Сок яблочный 0,25
                \tЦена: 1 EUR""");

        /**
         * ECR пытается инициировать команду UNLOCK в POS для ожидания оплаты
         * Сумма: 1
         * Волюта: EUR
         */
        File unlockDevice = new File("src/json/UNLOCKDEVICE.json");
        System.out.println("Try UNLOCKDEVICE command");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * HTTP сервер вернул код ответа: 200 - Success with response body
         */
        System.out.println("200 OK");

        /**
         * POS ожидает предоставление карты и выводит сообщение: Insert Card
         */
        System.out.println("Insert Card");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * POS пытается верифицировать карту
         */
        System.out.println("Try Verification card");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * POS пытается инициировать событие ONCARD в ECR для информирования его о прочтении карты
         */
        File oncard = new File("src/json/ONCARD.json");
        System.out.println("Try ONCARD event");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * HTTP сервер вернул код ответа: 200 - Success with response body
         */
        System.out.println("200 OK");

        /**
         * ECR пытается отработать событие ONCARD
         */
        System.out.println("Try processing ONCARD event");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * ECR пытается инициировать команду AUTHORIZE в POS для оплаты покупок.
         * Сумма: 1
         * Волюта: EUR
         */
        File authorize = new File("src/json/AUTHORIZE.json");
        System.out.println("Try AUTHORIZE command");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * HTTP сервер вернул код ответа: 200 - Success with response body
         */
        System.out.println("200 OK");

        /**
         * POS отображает сумму транзакции
         */
        System.out.println("Amount: 1 EUR");

        /**
         * Ожидание ввода PIN
         */
        System.out.println("Enter PIN");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * POS пытается подтвердить транзакцию оплаты картой
         */
        System.out.println("Try perform pay");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * POS отображает статус оплаты
         */
        System.out.println("Payment has been made");

        /**
         * POS пытается инициировать события ONTRNSTATUS (информирование ECR об изменении статуса) и ONPRINT (информирование ECR о готовности данных для печати)
         */
        File ontrnstatus = new File("src/json/ONTRNSTATUS.json");
        File onprint = new File("src/json/ONPRINT.json");
        System.out.println("Try ONTRNSTATUS and ONPRINT event");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * HTTP сервер вернул код ответа: 200 - Success with response body
         */
        System.out.println("200 OK");

        /**
         * ECR печатает чек
         */
        System.out.println("Print receipt");

        /**
         * ECR пытается инициировать команду CLOSEDOC для подтверждения транзакции
         */
        File closedoc = new File("src/json/CLOSEDOC.json");
        System.out.println("Try CLOSEDOC command");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * HTTP сервер вернул код ответа: 200 - Success with response body
         */
        System.out.println("200 OK");

    }
}
