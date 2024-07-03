package LoggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    //in aceasta clasa configuram metode pt a loga informatii
    //ne trebuie o metoda care sa reprezinte inceputul unui test, finalul unui test, info, error

    private static Logger logger = LogManager.getLogger();

    public static void startTestCase (String testCase) {
        logger.info("****** Execution Started: " + testCase + "******");
    }

    public static void finishTestCase (String testCase) {
        logger.info("****** Execution Finish: " + testCase + "******");
    }

    public static void infoTestCase (String message) {
        logger.info(message);
    }

    public static void errorTestCase (String message) {
        logger.error(message);
    }
}
