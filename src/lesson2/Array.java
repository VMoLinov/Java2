package lesson2;

public class Array {

    String[][] arrayString = new String[][]{{"1", "2", "3", "4"},
            {"5", "6", "7", "8"}, {"9", "10", "-20", "12"}, {"13", "14", "15", "16"}};
    int[][] arrayInt = new int[4][4];

    public int parseArray(String[][] array) throws MyArrayDataException {
        int count = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    count += arrayInt[i][j];
                }
            }
            return count;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(e);
        }
     }

    public void checkSize(String[][] array) throws MyArraySizeException {
            for (String[] item : array) {
                if (item.length != 4 || array.length != 4) {
                    throw new MyArraySizeException();
                }
            }
    }
}
