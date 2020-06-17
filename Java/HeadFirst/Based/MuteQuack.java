public class MuteQuack implements QuackBehavior {
    public MuteQuack() {}
    public void quack() {
        System.out.println("This duck can't quack.");
    }
}