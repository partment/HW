public class ImaginaryDuckB extends Duck {
    public ImaginaryDuckB() {
        quackBehavior = new Squeak();
    }
    public void display() {
        System.out.println("This is a ImaginaryDuckB.");
    }
}