package com.oleg.loggin.exceptions;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Exceptions {
    private static final Logger log = Logger.getLogger(Exceptions.class);

    public static void makeWarning(String warning)
    {
        log.warn(warning);
    }

    public static void noParametrException(NullPointerException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error(exception.getMessage());
        log.trace(trace);
    }

    public static void fileNotFoundException(FileNotFoundException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error("There is no file in this directory");
        log.trace(trace);
    }

    public static void ReadFileException(IOException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error("Failed to read file");
        log.trace(trace);
    }

    public static void notInitializedException(NullPointerException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error("Object should be initalized");
        log.trace(trace);

    }

    public static void notNumberException(NumberFormatException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error("You should enter integer number");
        log.trace(trace);
    }

    public static void notCorrectNumbersException(IllegalArgumentException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error(exception.getMessage());
        log.trace(trace);

    }

    public static void divisionByZero(ArithmeticException exception) {
        StackTraceElement[] info = exception.getStackTrace();
        StringBuilder trace = makeStackTrace(info);

        log.error(exception.getMessage());
        log.trace(trace);
    }

    private static StringBuilder makeStackTrace(StackTraceElement[] info) {
        StringBuilder trace = new StringBuilder("");

        for (int i = info.length - 1; i >= 0; i--) {
            trace.append(info[i].toString() + "\n");
        }

        return trace;
    }
}
