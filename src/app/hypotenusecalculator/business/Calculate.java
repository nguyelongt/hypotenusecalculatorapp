package app.hypotenusecalculator.business;

public class Calculate {
    public static double rightTriangleHypotenuse(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
