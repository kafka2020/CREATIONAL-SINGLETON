import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        logger.log("Запускаем программу");

        // Ввод размера списка
        logger.log("Просим пользователя ввести входные данные для списка");
        int n = checkPositiveInt(scanner, "Введите размер списка: ");
        int m = checkPositiveInt(scanner, "Введите верхнюю границу для значений: ");

        // Создание списка
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(m));
        }
        System.out.println("Вот случайный список: " + listToString(list));

        // Фильтрация
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int f = checkPositiveInt(scanner, "Введите порог для фильтра: ");

        Filter filter = new Filter(f);
        List<Integer> filtered = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println(filtered.isEmpty()
                ? "Отфильтрованный список пуст"
                : String.format("Отфильтрованный список: %s", listToString(filtered)));

        logger.log("Завершаем программу");
    }

    private static int checkPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                if (value > 0) {
                    return value;
                }
                Logger.getInstance().log("Число должно быть положительное: " + value);
            } catch (InputMismatchException e) {
                Logger.getInstance().log("Ошибка ввода: ожидалось целое число");
                scanner.next(); // очистка буфера
            }
        }
    }

    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(num);
        }
        return sb.toString();
    }
}