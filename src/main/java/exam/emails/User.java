package exam.emails;

import java.util.Set;

public class User {
    private String name;
    private Set<String> emails;

    public User(String name, Set<String> emails) {
        this.name = name;
        this.emails = emails;
    }
}
