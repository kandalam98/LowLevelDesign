package org.example.LoggerImpl;

public class Logger {

//    private final org.slf4j.Logger log;
//
//    public static Logger getLogger(String name)
//    {
//        log = org.slf4j.LoggerFactory.getLogger(name);
//    }

    public void info(String message)   {
        logMessageImpl(message, LogLevel.INFO);
    }

    private void logMessageImpl(String message, LogLevel logLevel) {
        switch (logLevel) {
            case INFO:
                System.out.println("INFO: " + message);
                break;
            case WARN:
                System.out.println("WARN: " + message);
                break;
            case ERROR:
                System.out.println("ERROR: " + message);
                break;
            case DEBUG:
                System.out.println("DEBUG: " + message);
                break;
        }
    }

    public void warn(String message)   { logMessageImpl(message, LogLevel.WARN); }
    public void error(String message)  { logMessageImpl(message, LogLevel.ERROR);    }
    public void debug(String message)  { logMessageImpl(message, LogLevel.DEBUG);    }

    public void info(LogMsg logMsg)    { logLogMsgImpl(logMsg, LogLevel.INFO);  }

    private void logLogMsgImpl(LogMsg logMsg, LogLevel logLevel) {
        switch (logLevel) {
            case INFO:
                System.out.println("INFO: " + logMsg.toString());
                break;
            case WARN:
                System.out.println("WARN: " + logMsg.toString());
                break;
            case ERROR:
                System.out.println("ERROR: " + logMsg.toString());
                break;
            case DEBUG:
                System.out.println("DEBUG: " + logMsg.toString());
                break;
        }
    }

    public void warn(LogMsg logMsg)    { logLogMsgImpl(logMsg, LogLevel.WARN);  }
    public void error(LogMsg logMsg)   { logLogMsgImpl(logMsg, LogLevel.ERROR); }

}
