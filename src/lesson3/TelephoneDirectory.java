package lesson3;

import java.util.*;

class TelephoneDirectory {

    private Map<String, List<String>> directory = new HashMap<>();

    public void add(String key, String value) {
        directory.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public List<String> get(String key) {
        return directory.get(key);
    }
}
