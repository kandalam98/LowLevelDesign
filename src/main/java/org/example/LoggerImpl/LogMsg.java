package org.example.LoggerImpl;

public class LogMsg {

    String message;
    String logLevel;
    String tag;
    String date;

    @Override
    public String toString() {
        return "LogMsg{" +
                "message='" + message + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", tag='" + tag + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
