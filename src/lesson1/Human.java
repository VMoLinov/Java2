package lesson1;

public class Human extends Sportsmen {

    public Human(String name, int maxRun, int maxJump) {
        super(name, maxRun, maxJump);
        super.type = "human";
    }
}
