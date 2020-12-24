package lesson1;

public class Main {

    public static void main(String[] args) {

        Sportsmen[] participants = addParticipants();
        Obstacles[] obstacles = addObstacles();

        for (Obstacles obstacle : obstacles) {
            for (Sportsmen participant : participants) {
                if (participant.isAction()) {
                    obstacle.attempt(participant);
                }
            }
        }

        System.out.println("Преодолели все препятствия:");
        for (Sportsmen participant : participants) {
            if (participant.isAction()) System.out.println(participant.toString());
        }
    }

    private static Sportsmen[] addParticipants() {
        Sportsmen human1 = new Human("Victor", 100, 50);
        Sportsmen human2 = new Human("Valera", 200, 20);
        Sportsmen human3 = new Human("Stas", 300, 70);
        Sportsmen robot1 = new Robot("Skynet", 100, 20);
        Sportsmen robot2 = new Robot("Phillips", 200, 10);
        Sportsmen robot3 = new Robot("Xiaomi", 300, 70);
        Sportsmen cat1 = new Cat("Jack", 300, 150);
        Sportsmen cat2 = new Cat("Bob", 400, 120);
        Sportsmen cat3 = new Cat("Josh", 250, 100);
        return new Sportsmen[]{human1, human2, human3, robot1, robot2, robot3, cat1, cat2, cat3};
    }

    private static Obstacles[] addObstacles() {
        Obstacles barrier1 = new Barrier(20);
        Obstacles barrier2 = new Barrier(30);
        Obstacles barrier3 = new Barrier(60);
        Obstacles track1 = new Track(60);
        Obstacles track2 = new Track(200);
        Obstacles track3 = new Track(250);
        return new Obstacles[]{barrier1, track1, barrier2, track2, barrier3, track3};
    }
}
