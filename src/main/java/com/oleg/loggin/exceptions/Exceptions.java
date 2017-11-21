package com.oleg.loggin.exceptions;

import org.apache.log4j.Logger;

public abstract class Exceptions {
    private static final Logger log = Logger.getLogger(Exceptions.class);

    public static void makeWarning(String warning)
    {
        log.warn(warning);
    }

    public static void noParametrException(NullPointerException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error(exception.getMessage() + "\nTrace: \n" + trace);
    }

    public static void notInitializedException(NullPointerException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error("Object should be initalized" + "\nTrace: \n" + trace);
    }

    public static void notNumberException(NumberFormatException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error("You should enter integer number" + "\nTrace: \n" + trace);
    }

    public static void notCorrectNumbersException(IllegalArgumentException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error(exception.getMessage() + "\nTrace: \n" + trace);

    }

    public static void divisionByZero(ArithmeticException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error(exception.getMessage() + "\nTrace: \n" + trace);
    }

    private static StringBuilder makeStackTrace(StackTraceElement[] info) {
        StringBuilder trace = new StringBuilder("");

        for (int i = info.length - 1; i >= 0; i--) {
            trace.append(info[i].toString() + "\n");
        }

        return trace;
    }
}
