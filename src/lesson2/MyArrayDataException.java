package lesson2;

public class MyArrayDataException extends Exception {

    int i;
    int j;

    MyArrayDataException(int i, int j, Throwable e) {
        this.i = i;
        this.j = j;
        System.out.printf("Ошибка формата данных в массиве. Ячейка [%d][%d]%n", i, j);
    }
}
