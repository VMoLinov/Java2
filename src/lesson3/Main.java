package lesson3;

import java.util.*;

public class Main {

    static String[] fruits = {"apple", "banana", "mango", "apricot", "coconut", "apple", "banana", "nut", "orange", "leak",
            "kiwi", "mango", "pear", "pepper", "mango", "pepper", "potato", "lemon", "apple", "apple", "pumpkin", "pepper"};
    static TelephoneDirectory local = new TelephoneDirectory();

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Arrays.asList(fruits));
        Set<String> setList = new TreeSet<>(arrayList);

        System.out.println("Original array. Number of items: " + arrayList.size());
        System.out.println(arrayList);

        System.out.println("Unique items: " + setList.size());
        System.out.println(setList);

        elementsCount(arrayList, setList);
        System.out.println();

        addDirectory();
        String name = "Nikulin";
        System.out.println("Find result:");
        System.out.println(name + ": " + local.get(name));
    }

    private static void elementsCount(List<String> arrayList, Set<String> setList) {
        StringBuilder out = new StringBuilder();
        Iterator<String> iterator = setList.iterator();
        String original = null;
        out.append('[');

        System.out.println("Score repeated items:");
        while (iterator.hasNext()) {
            int count = 0;
            if (original != null) out.append(", ");
            original = iterator.next();
            for (String compare : arrayList) {
                if (original.equals(compare)) count++;
            }
            out.append(original).append(' ').append(count);
        }
        System.out.print(out.append(']'));
        System.out.println();
    }

    private static void addDirectory() {
        local.add("Molinov", "3214879542");
        local.add("Molinov", "5489621435");
        local.add("Ivanov", "1234567890");
        local.add("Petrov", "1234569190");
        local.add("Sidorov", "1234695190");
        local.add("Nikulin", "6544569190");
        local.add("Nikolaev", "1234569987");
        local.add("Nikulin", "6574569190");
    }
}
