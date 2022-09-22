import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        System.out.println("""
                UI ECR:
                \tОжидается платеж за товар:
                \tИд: 456
                \tНазвание: Сок яблочный 0,25
                \tЦена: 1 EUR""");

        /**
         * ECR инициирует команду UNLOCK в POS для ожидания оплаты
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
         * POS терминал верифицирует карту
         */
        System.out.println("Try Verification card");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * POS инициирует событие ONCARD в ECR для информирования о прочтении карты
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
         * ECR отрабатывает событие ONCARD
         */
        System.out.println("Try processing ONCARD event");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * ECR инициирует команду AUTHORIZE в POS для оплаты покупок.
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
         * POS отобразил сумму транзакции
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
         * POS подтверждает транзакцию оплаты картой
         */
        System.out.println("Try perform pay");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * POS отобразил статус оплаты
         */
        System.out.println("Payment has been made");

        /**
         * POS инициирует события ONTRNSTATUS (информирование ECR о изменении статуса), ONPRINT (информирование ECR о готовности данных для печати)
         */
        System.out.println("Try ONTRNSTATUS and ONPRINT event");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * ECR печатает чек
         */
        System.out.println("Try print receipt");

        if (!(scaner.nextInt() == 1)) {
            Thread.currentThread().stop();
        }

        /**
         * ECR распечатал чек
         */
        System.out.println("Here is a receipt");

        /**
         * ECR инициирует команду CLOSEDOC для подтверждения транзакции
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
