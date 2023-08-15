package utils;
import Data.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;
import java.io.IOException;

public class Log {
    static ConfigReader data;

    static {
        try {
            data = new ConfigReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static org.apache.logging.log4j.Logger Log = LogManager.getLogger();

    public Log() throws IOException {
    }

    public static void LogWarn(String message) {
        Log.warn(String.format("[ Warn ] : " + message));
        Reporter.log(String.format("[ Warn ] : " + message));
    }

    public static void LogError(String message) {
        Log.error(String.format("[ Error ] : " + message));
        Reporter.log(String.format("[ Error ] : " + message));
    }

    public static void LogFatal(String message) {
        Log.fatal(String.format("[ Fatal ] : " + message));
        Reporter.log(String.format("[ Fatal ] : " + message));
    }

    public static void logDebug(String message) {
        Log.debug(String.format("[ Debug ] : " + message));
        Reporter.log(String.format("[ Debug ] : " + message));
    }


    private static boolean enableLogging = true;

    public static void logInfo(String message) {
        if (enableLogging) {
            if (message.contains("Start test") || message.contains("End test")) {
                Log.info(String.format(getCallingMethod()));
                Reporter.log(String.format(getCallingMethod()));

            } else {

                if (data.getLogDetail()) {
                    Log.info(String.format(getCallingMethod()));
                    Reporter.log(String.format(getCallingMethod()));
                }


                Log.info(String.format("[ Steps ] : " + message));
                Reporter.log(String.format("[ Steps ] : " + message));
            }
        }
    }

    public static String getCallingMethod() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String message;
        if (stackTrace.length < 4) {
            return "unknown";
        }
        StackTraceElement caller = stackTrace[3];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        if (className.contains("_Test")) {
            message = "[ Test  ] : " + className;
        } else {
            message = "[ Class ] : " + className + " " + "[ Method ] : " + methodName + " ";
        }

        return message;
    }

    public static void setLogging(boolean enable) {
        enableLogging = enable;
    }
}
