package rui.coder.design.pattern.behaviour.chainOfResponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractLoggerTest {

    AbstractLogger loggerChain;

    @BeforeEach
    void setUp() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        loggerChain = errorLogger;
    }

    @Test
    void log() {
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}