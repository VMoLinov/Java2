package lesson1;

public class Robot extends Sportsmen {

    public Robot(String name, int maxRun, int maxJump) {
        super(name, maxRun, maxJump);
        super.type = "robot";
    }
}
