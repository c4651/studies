package someCoreTasks.userRegistration;

import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private final String name;
    private final Integer age;
    private final String workPlace;
    private final String address;

    public User(String name, Integer age, String workPlace, String address) {
        validate(name, age, workPlace, address);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static void validate(String name, Integer age, String workPlace, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("The age must not be less than 18");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong address");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Wrong place of work");
        }
    }

    public static void main(String[] args) {
        try {
            User user1 = new User(" ", 19, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user2 = new User("Angi", 19, "Googl", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user2 = new User("Angi", 19, "Google", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

