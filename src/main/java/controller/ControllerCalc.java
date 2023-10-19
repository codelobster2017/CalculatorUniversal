package controller;

import logger.CalcLog;
import logger.Logger;
import model.*;
import view.View;
import view.ViewCalc;

import java.util.Scanner;


public class ControllerCalc implements Controller {
    private Calculator calculator;
    private View view;
    private Logger logger;
    private Boolean start;
    private Scanner scanner;

    public ControllerCalc() {
        start = true;
        view = new ViewCalc();
        start();
    }

    @Override
    public void exit() {
        start = false;
        System.out.println("Всего хоро-шего!");
    }

    private void start() {
        view.printMainMenu();
        int source = inputInt();
        if (source == 0) {
            calculator = new CalculatorSimple();
            logger = new CalcLog(calculator);
        } else {
            calculator = new CalculatorComplex();
            logger = new CalcLog(calculator);
        }
        view.printMenu(calculator);
        view.print("Для вывода логов - " + logger.getOperationLogs());
        view.print("Для выхода - " + (logger.getOperationLogs()+1));
        while (start) {
            inputCalcComplex(inputInt());
        }
    }

    private int inputInt() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void inputCalcComplex(int operation) {
        if (operation < logger.getOperationLogs()) {
            Num numOne;
            Num numTwo;
            int i = 1;
            Boolean bool = calculator.getClass().getSimpleName().equals("CalculatorSimple");
            System.out.println(bool);
            view.print("Введите реальную часть " + i + " числа: ");
            int real = inputInt();
            if (!bool) {
                view.print("Введите мнимую часть " + i + " числа: ");
                int imaginary = inputInt();
                numOne = new Complex(real, imaginary);
            } else {
                numOne = new Num(real);
            }
            i++;

            view.print("Введите реальную часть " + i + " числа: ");
            real = inputInt();
            if (!bool) {
                view.print("Введите мнимую часть " + i + " числа: ");
                int imaginary = inputInt();
                numTwo = new Complex(real, imaginary);
            } else {
                numTwo = new Num(real);
            }
            view.print(calculator.result(operation, numOne, numTwo));
            logger.log(operation, numOne, numTwo);
        } else if (operation == logger.getOperationLogs()) {
            logger.printLogs();
        }else if (operation == logger.getOperationLogs()+1){
            exit();
        }

    }

}