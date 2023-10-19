package model;

public class CalculatorComplex extends CalculatorSimple {

    private String abilities;

    public CalculatorComplex() {
        abilities = getAbilities() + " (только для простых чисел)";
    }

    public String result(int operation, Num numOne, Num numTwo) {
        if (numOne.getClass().getSimpleName().equals("Complex")) {
            return calc(operation, (Complex) numOne, (Complex) numTwo);
        }
        return super.result(operation, numOne, numTwo);

    }

    private String calc(int operation, Complex numOne, Complex numTwo) {
        String left = super.result(operation, numOne, numTwo);
        String right = super.result(operation, new Num(numOne.getImaginary()), new Num(numTwo.getImaginary()));
        if (operation == 3 && numOne.getImaginary() != 0 && numTwo.getImaginary() != 0) {
            return "Для комплексных чисел не реализован данный функционал";
        }
        if (operation == 2) {
            if (Double.parseDouble(right) != 0) {
                double powImag = Double.parseDouble(super.result(1, new Num(numTwo.getImaginary()), new Num(numTwo.getImaginary())));
                double powReal = Double.parseDouble(super.result(1, numTwo, numTwo));

                double leftsUp = Double.parseDouble(super.result(0, new Num(Double.parseDouble(super.result(1, numOne, numTwo))),
                        new Num(Double.parseDouble(super.result(1, new Num(numOne.getImaginary()), new Num(numTwo.getImaginary()))))));
                double down = powImag + powReal;
                double rightUp = Double.parseDouble(super.result(2,
                        new Num(Double.parseDouble(super.result(3,
                                new Num(Double.parseDouble(super.result(1, numOne, new Num(numTwo.getImaginary())))),
                                new Num(Double.parseDouble(super.result(1, new Num(numOne.getImaginary()), numTwo)))))),
                        new Num(down)));

                left = super.result(2, new Num(leftsUp), new Num(down));
                if (rightUp < 0) {
                    return left + " " +
                            rightUp + "i";
                }
                return left + " +" +
                        rightUp + "i";
            }
        } else if (operation == 1) {
            double multiLeft = Double.parseDouble(super.result(3,
                    new Num(Double.parseDouble(super.result(1, numOne, numTwo))),
                    new Num(Double.parseDouble(right))));
            double multiRight = Double.parseDouble(super.result(0,
                    new Num(Double.parseDouble(super.result(1, new Num(numOne.getImaginary()), numTwo))),
                    new Num(Double.parseDouble(super.result(1, numOne, new Num(numTwo.getImaginary()))))));

            if (multiRight != 0) {
                if (multiLeft != 0) {
                    if (multiRight > 0) {
                        return multiLeft + " + " + multiRight + "i";
                    } else {
                        return multiLeft + " " + multiRight + "i";
                    }
                }

            } else {
                return multiLeft + "";
            }
        }

        if (Double.parseDouble(left) != 0) {
            if (Double.parseDouble(right) < 0) {
                return left + " " + right + "i";
            } else if (Double.parseDouble(right) > 0) {
                return left + " + " + right + "i";
            } else {
                return left;
            }
        } else {
            if (Double.parseDouble(right) < 0 || Double.parseDouble(right) > 0) {
                return right + "i";
            }
            return left;
        }
    }

}