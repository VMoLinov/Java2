package lesson2;

public class MyArrayDataException extends Exception {

    MyArrayDataException(NumberFormatException e) {
        e.printStackTrace();
        System.out.println("Ошибка данных в массиве");
    }
}
