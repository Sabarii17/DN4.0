class Logger {
    private static Logger logger; 

    private Logger() {
        System.out.println("Logger created.");
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        System.out.println(message);
    }
}

public class Singletonlog {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is from logger1.");
        logger2.log("This is from logger2.");

        if (logger1 == logger2) {
            System.out.println("Same instance. Singleton works.");
        } else {
            System.out.println("Different instances. Singleton failed.");
        }
    }
}
