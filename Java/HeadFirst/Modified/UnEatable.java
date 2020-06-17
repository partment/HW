public class UnEatable implements EatStatus {
    public UnEatable() {}
    public void eat() {
        System.out.println("You can't eat this duck.");
    }
}