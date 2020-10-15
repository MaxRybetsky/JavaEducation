package exam.emails;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomSet {
    HashMap<String, Set<String>> storage;

    public CustomSet() {
        storage = new HashMap<>();
    }

    public void put(String username, Set<String> emailsData) {
        add(username, emailsData);
        check();
    }

    private void add(String username, Set<String> emailsData) {
        Set<String> emails = new HashSet<>(emailsData);
        if (storage.containsKey(username)) {
            storage.get(username).addAll(emails);
            return;
        }
        Set<String> keySet = storage.keySet();
        for (String key : keySet) {
            for (String value : emails) {
                Set<String> set = storage.get(key);
                System.out.println("Action in for");
                if (set.contains(value)) {
                    set.addAll(emails);
                    System.out.println("Action in if");
                    return;
                }
            }
        }
        storage.put(username, emails);
    }

    private void check() {
        Set<String> keySet = storage.keySet();
        Map<String, Set<String>> map = new HashMap<>(storage);
        storage = new HashMap<>();
        for (String key : keySet) {
            System.out.println("Checking");
            add(key, map.get(key));
        }
    }

    @Override
    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) {
        CustomSet set = new CustomSet();
        for (int i = 0; i < 30; i++) {
            String s1 = (i) + "";
            String s2 = (i * i) + "";
            Set<String> set1 = new HashSet<>();
            set1.add(s1);
            set1.add(s2);
            set.put(i + "", set1);
            System.out.println((i) + " " + (i * i));
        }
        System.out.println(set);
    }
}
