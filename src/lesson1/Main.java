package lesson1;

public class Main {

    public static void main(String[] args) {

        Actionable[] participants = addParticipants();
        Obstacles[] obstacles = addObstacles();

        for (Obstacles obstacle : obstacles) {
            if (obstacle instanceof Barrier) {
                for (Actionable participant : participants) {
                    jump(participant, obstacle.getValue());
                }
            } else if (obstacle instanceof Track) {
                for (Actionable participant : participants) {
                    run(participant, obstacle.getValue());
                }
            }
        }

        System.out.println("Финишировали:");
        for (Actionable participant : participants) {
            if (participant.isAction()) System.out.println(participant.toString());
        }
    }

    private static Actionable[] addParticipants() {
        Actionable human1 = new Human("Victor", 25, 50, 100);
        Actionable human2 = new Human("Valera", 30, 20, 200);
        Actionable human3 = new Human("Stas", 22, 70, 300);
        Actionable robot1 = new Robot("Skynet", 20, 100);
        Actionable robot2 = new Robot("Phillips", 10, 200);
        Actionable robot3 = new Robot("Xiaomi", 70, 300);
        Actionable cat1 = new Cat("Jack", 4, 150, 300);
        Actionable cat2 = new Cat("Bob", 2, 120, 400);
        Actionable cat3 = new Cat("Josh", 7, 100, 250);
        return new Actionable[]{human1, human2, human3, robot1, robot2, robot3, cat1, cat2, cat3};
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

    public static void jump(Actionable participant,int height) {
        if (participant.isAction()) {
            if (height <= participant.getMAX_JUMP()) {
                System.out.printf("%s перепрыгнул %d сантиметров%n", participant.getNAME(), height);
            } else {
                System.out.printf("%s не преодолел препятствие и сходит с дистанции%n", participant.getNAME());
                participant.setAction(false);
            }
        }
    }

    private static void run(Actionable participant, int range) {
        if (participant.isAction()) {
            if (range <= participant.getMAX_RUN()) {
                System.out.printf("%s пробежал %d метров%n", participant.getNAME(), range);
            } else {
                System.out.printf("%s не пробежал %d метров и сходит с дистанции%n", participant.getNAME(), range);
                participant.setAction(false);
            }
        }
    }
}
