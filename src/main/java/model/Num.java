package model;

public class Num {

    public Num(double real) {
        this.real = real;
    }

    private double real;

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    @Override
    public String toString() {
        return getReal() + "";
    }
}
