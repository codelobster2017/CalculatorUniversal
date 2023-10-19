package model;

public class Complex extends Num {
    private double imaginary;

    public Complex(double real, double imaginary) {
        super(real);
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        if (imaginary > 0) {
            return super.toString() + " + " + imaginary + 'i';
        } else if (imaginary < 0) {
            return super.toString() + " " + imaginary + 'i';
        } else {
            return super.toString();
        }
    }
}
