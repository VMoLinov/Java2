package lesson2;

public class MyArrayDataException extends Exception {

    MyArrayDataException(Throwable e) {
        System.out.println("Ошибка формата данных в массиве");
    }
}
