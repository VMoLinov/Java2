package lesson2;

public class Main {

    private static int i;

    public static void main(String[] args) {
        Array array = new Array();
        try {
            array.checkSize(array.arrayString);
            i = array.parseArray(array.arrayString);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Сумма элементов массива " + i);
        }

    }
}
