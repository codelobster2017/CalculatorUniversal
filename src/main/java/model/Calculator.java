package model;

public interface Calculator {
    String result(int operation, Num numOne, Num numTwo);

    String getAbilities();

    public int getMaxOperation();
}
