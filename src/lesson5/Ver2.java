package lesson5;

public class Ver2 {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {

        initArray();
        simpleMethod();
        initArray();
        doubleThread();
    }

    private static void initArray() {

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
    }

    private static void simpleMethod() {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("Simple method time = " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void doubleThread() {
        long startTime = System.currentTimeMillis();
        float[] a1 = new float[HALF], a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        class Child extends Thread {

            final float[] arr;

            private Child(float[] arr) {
                this.arr = arr;
            }

            @Override
            public void run() {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2 + i / 5) * Math.cos(0.2 + i / 5) *
                            Math.cos(0.4 + i / 2));
                }
            }
        }

        Thread child1 = new Thread(new Child(a1));
        Thread child2 = new Thread(new Child(a2));
        child1.start();
        child2.start();

        try {
            child1.join();
            child2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("Double thread time = " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
