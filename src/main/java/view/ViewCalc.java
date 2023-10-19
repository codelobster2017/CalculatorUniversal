package view;

import model.Calculator;

public class ViewCalc implements View {

    @Override
    public void printMenu(Calculator calculator) {
        print("Введите операцию: ");
        print(calculator.getAbilities());
    }

    @Override
    public void printMainMenu() {
        print("""
                Выберите калькулятор:
                0 - Вычисление простых чисел
                др. цифра - Вычисление простых и комплексных чисел
                """);
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void print(double d) {
        System.out.println(d);
    }

}
