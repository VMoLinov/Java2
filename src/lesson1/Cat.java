package lesson1;

public class Cat extends Alive {

    public Cat(String name, int maxRun, int maxJump) {
        super(name, maxRun, maxJump);
        super.type = "cat";
    }
}
