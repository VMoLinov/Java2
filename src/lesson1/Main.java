package lesson1;

public class Main {

    public static void main(String[] args) {
        Action human1 = new Human("Victor", 25, 50, 100);
        Action human2 = new Human("Valera", 30, 20, 200);
        Action human3 = new Human("Stas", 22, 70, 300);
        Action robot1 = new Robot("Skynet", 20, 100);
        Action robot2 = new Robot("Phillips", 10, 200);
        Action robot3 = new Robot("Xiaomi", 70, 300);
        Action cat1 = new Cat("Jack", 4, 150, 300);
        Action cat2 = new Cat("Bob", 2, 120, 400);
        Action cat3 = new Cat("Josh", 7, 100, 250);
        Obstacles barrier1 = new Barrier(20);
        Obstacles barrier2 = new Barrier(30);
        Obstacles barrier3 = new Barrier(60);
        Obstacles track1 = new Track(60);
        Obstacles track2 = new Track(200);
        Obstacles track3 = new Track(250);
        Action[] participants = {human1, human2, human3, robot1, robot2, robot3, cat1, cat2, cat3};
        Obstacles[] obstacles = {barrier1, track1, barrier2, track2, barrier3, track3};

        for (Obstacles obstacle : obstacles) {
            if (obstacle instanceof Barrier) {
                for (Action participant : participants) {
                    participant.jump(obstacle.getValue());
                }
            } else if (obstacle instanceof Track) {
                for (Action participant : participants) {
                    participant.run(obstacle.getValue());
                }
            }
        }
    }
}
