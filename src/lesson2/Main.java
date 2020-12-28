//1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого
//размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
//элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно
//быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
//MyArrayDataException и вывести результат расчета.
package lesson2;

public class Main {

    static String[][] arrayString = new String[][]{{"1", "2", "3", "4"},
            {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

    public static void main(String[] args) {
        try {
            checkSize(arrayString);
            int count = parseArray(arrayString);
            System.out.println("Сумма элементов массива " + count);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int parseArray(String[][] array) throws MyArrayDataException {
        int count = 0, i = 0, j = 0;
        try {
            for (i = 0; i < array.length; i++) { // Как лучше оформить цикл? Если удалить i = 0, тогда значение i не
                for (j = 0; j < array[i].length; j++) { // будет прокидываться в исключение. Но так как она уже иници-
                    count += Integer.parseInt(array[i][j]); // ализирована, то и особого смысла в повторной инициализа-
                } // ции нет.
            }
            return count;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(i, j, e);
        }
    }

    private static void checkSize(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException(); // Пробовал создать условие в одну строку в цикле , но раз первое условие
        } // нужно проверить лишь единожды, менее ресурсоёмка будет такая реализация? Или я не прав?
        for (String[] item : array) {
            if (item.length != 4) {
                throw new MyArraySizeException();
            }
        }
    }
}
