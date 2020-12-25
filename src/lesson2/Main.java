//1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого
//размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
//элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно
//быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
//MyArrayDataException и вывести результат расчета.
package lesson2;

public class Main {

    public static void main(String[] args) {
        Array array = new Array();
        try {
            array.checkSize(array.arrayString);
            int count = array.parseArray(array.arrayString, 0, 0);
            System.out.println("Сумма элементов массива " + count);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
