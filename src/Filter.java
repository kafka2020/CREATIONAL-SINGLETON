import java.util.*;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        logger.log("Запускаем фильтрацию");
        for (int num : source) {
            if (num >= threshold) {
                result.add(num);
                logger.log(String.format("Элемент \"%d\" проходит", num));
            } else {
                logger.log(String.format("Элемент \"%d\" не проходит", num));
            }
        }
        logger.log(String.format("Прошло фильтр %d элемента из %d", result.size(), source.size()));

        return result;
    }
}
