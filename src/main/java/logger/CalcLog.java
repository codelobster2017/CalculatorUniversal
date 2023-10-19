package logger;


import model.Calculator;
import model.Complex;
import model.Num;

import java.util.ArrayList;
import java.util.List;


public class CalcLog implements Logger {
    private Calculator calculator;
    private List<String> logs;
    private int operationLogs;

    public CalcLog(Calculator calculator) {
        this.calculator = calculator;
        logs = new ArrayList<>();
        operationLogs = calculator.getMaxOperation() + 1;
    }


    @Override
    public void log(int operation, Num numOne, Num numTwo) {

        logs.add(logg(operation, numOne, numTwo));

    }

    @Override
    public int getOperationLogs() {
        return operationLogs;
    }

    @Override
    public void printLogs() {
        System.out.println(logs);
    }

    private String logg(int operation, Num numOne, Num numTwo) {
        String operationS;
        switch (operation) {
            case 0 -> operationS = "Сумма ";
            case 1 -> operationS = "Произведение ";
            case 2 -> operationS = "Деление ";
            case 3 -> operationS = "Сложение ";
            default -> {
                return "Неверно указана операция operation = " + operation;
            }
        }
        if (numOne.getClass().getName().equals("Complex") || numTwo.getClass().getName().equals("Complex")) {
            Complex complexLeft = (Complex) numOne;
            Complex complexRight = (Complex) numTwo;
            return operationS + "чисел " + numOne.getReal() + " + (" + complexLeft.getImaginary() + ")" + " и "
                    + numTwo.getReal() + " + (" + complexRight.getImaginary() + ")";
        }
        return operationS + "чисел " + numOne.getReal() + " и " + numTwo.getReal();
    }


}
