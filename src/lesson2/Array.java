package lesson2;

public class Array {

    String[][] arrayString = new String[][]{{"1", "2", "3", "4"},
            {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

    public int parseArray(String[][] array, int i, int j) throws MyArrayDataException {
        int count = 0;
        try {
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    count += Integer.parseInt(array[i][j]);
                }
            }
            return count;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(i, j, e);
        }
    }

    public void checkSize(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException(); // Пробовал создать условие в одну строку в цикле , но раз первое условие
        } // нужно проверить лишь единожды, менее ресурсоёмко будет такая реализация? Или я не прав?
        for (String[] item : array) {
            if (item.length != 4) {
                throw new MyArraySizeException();
            }
        }
    }
}
