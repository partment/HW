public class QuadraticEquation {
    private double a, b, c, discriminant;
    public QuadraticEquation() {}
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }
    public double getDiscriminant() {
        this.discriminant = Math.pow(this.b, 2)-(4*a*c);
        if(this.discriminant >= 0) {
            return this.discriminant;
        }else {
            return 0;
        }
    }
    public double getRoot1() {
        if(this.discriminant >= 0) {
            return (Math.pow(this.discriminant, 0.5)-b)/(2*a);
        }else {
            return 0;
        }
    }
    public double getRoot2() {
        if(this.discriminant >= 0) {
            return (-Math.pow(this.discriminant, 0.5)-b)/(2*a);
        }else {
            return 0;
        }
    }
}