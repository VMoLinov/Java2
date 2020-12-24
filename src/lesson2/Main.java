package lesson2;

public class Main {

    static String[][] array = new String[2][4];

    public static void main(String[] args) {
        try {
            checkArray(array);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

    }

    private static void checkArray(String[][] array) throws MyArraySizeException {
        for (String[] item : array) {
            if (item.length != 4 || array.length != 4) {
                throw new MyArraySizeException();
            }
        }
    }
}
