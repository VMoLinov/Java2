package lesson1;

public class Main {

    public static void main(String[] args) {
        Human human1 = new Human("Victor", 25, 50, 100);
        Human human2 = new Human("Valera", 30, 20, 200);
        Human human3 = new Human("Vika", 22, 70, 300);
        Barrier barrier1 = new Barrier(20);
        Barrier barrier2 = new Barrier(30);
        Barrier barrier3 = new Barrier(60);
        Human humans[] = {human1, human2, human3};
        Barrier barriers[] = {barrier1, barrier2, barrier3};

        for (Barrier barrier : barriers) {
            for (Human human : humans) {
                human.jump(barrier.getHeight());
            }
        }
    }
}
