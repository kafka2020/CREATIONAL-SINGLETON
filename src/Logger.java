import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    protected int num = 1;
    private static Logger logger;

    public void log(String msg) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        System.out.printf("[%s %d] %s%n", timestamp, num, msg);
        num++;
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
