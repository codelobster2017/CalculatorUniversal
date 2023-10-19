package model;

public class CalculatorSimple implements Calculator {
    private String abilities;
    private int maxOperation;


    public CalculatorSimple() {
        abilities = """
                0 -  Сложение
                1 -  Произведение
                2 -  Деление
                3 -  Вычитание""";
        maxOperation = 3;
    }

    public int getMaxOperation() {
        return maxOperation;
    }

    @Override
    public String result(int operation, Num numOne, Num numTwo) {
        return String.valueOf(calc(operation, numOne, numTwo));
    }

    private double calc(int operation, Num numOne, Num numTwo) {
        return switch (operation) {
            case 0 -> numOne.getReal() + numTwo.getReal();
            case 1 -> numOne.getReal() * numTwo.getReal();
            case 2 -> numOne.getReal() / numTwo.getReal();
            case 3 -> numOne.getReal() - numTwo.getReal();
            default -> 0;
        };
    }

    public String getAbilities() {
        return abilities;
    }

}
