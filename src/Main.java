import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String IOS_NEW = "Установите версию приложения для iOS по ссылке";
    public static final String IOS_OLD = "Установите облегченную  версию приложения для iOS по ссылке";
    public static final String ANDROID_OLD = "Установите облегченную  версию приложения для Android по ссылке";
    public static final String ANDROID_NEW = "Установите версию приложения для Android по ссылке";


    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

     static void task1() {
        System.out.println("Задача 1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите год для проверки");
        try {
            int year = scanner.nextInt();
            if (isLeapYear(year)) {
                System.out.println(year + " год — високосный год");
            } else {
                System.out.println(year + " год — невисокосный год");
            }
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести цифры");
        }
        System.out.println();
    }

     static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

      static void task2() {
        System.out.println("Задание 2");
        byte clientOS = 0;
        int clientDeviceYear = 2022;
        System.out.println(checkOS(clientOS, clientDeviceYear));
        System.out.println();
    }

     static String checkOS(byte clientOS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientDeviceYear < currentYear) {
            if (clientOS == 0) {
                return IOS_OLD;
            } else {
                return ANDROID_OLD;
            }
        } else {
            if (clientOS == 0) {
                return IOS_NEW;
            } else {
                return ANDROID_NEW;
            }
        }
    }

     static void task3() {
        System.out.println("Задание 3");
        int deliveryDistance = 95;
        int day = calculationDelivery(deliveryDistance);
        if (day == 0) {
            System.out.println("Более 100 км доставки нет ");
        } else {
            System.out.println("Потребуется дней: " + day);
        }
    }

     static int calculationDelivery(int deliveryDistance) {
        if (deliveryDistance < 20) {
            return 1;
        } else if (deliveryDistance > 100) {
            return 0;
        } else {
            return (deliveryDistance - 20) / 40 + 2;
        }
    }
}
