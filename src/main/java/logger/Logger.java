package logger;

import model.Num;

public interface Logger {
    void log(int operation, Num numOne, Num numTwo);

    int getOperationLogs();

    public void printLogs();
}
