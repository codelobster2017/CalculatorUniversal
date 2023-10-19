package view;

import model.Calculator;

public interface View {
    void printMainMenu();

    void printMenu(Calculator calculator);

    void print(String string);

    void print(double d);
}
