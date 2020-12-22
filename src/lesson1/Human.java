package lesson1;

public class Human implements Action {

    private final String name;
    private final int age;
    private final int maxJump;
    private final int maxRun;
    private boolean action;

    public Human(String name, int age, int maxJump, int maxRun) {
        this.name = name;
        this.age = age;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        action = true;
    }

    @Override
    public void run(int range) {
        if (action) {
            if (range <= maxRun) {
                System.out.printf("%s пробежал %d метров%n", name, range);
            } else {
                System.out.printf("%s не пробежал %d метров%n", name, range);
                action = false;
            }
        }
    }

    @Override
    public void jump(int height) {
        if (action) {
            if (height <= maxJump) {
                System.out.printf("%s перепрыгнул %d метров%n", name, height);
            } else {
                System.out.printf("%s не преодолел препятствие и сходит с дистанции%n", name);
                action = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", maxJump=" + maxJump +
                ", maxRun=" + maxRun +
                '}';
    }
}
