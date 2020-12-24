package lesson2;

public class MyArraySizeException extends Exception{

    MyArraySizeException() {
        System.out.println("Неверная длина массива");
    }
}
