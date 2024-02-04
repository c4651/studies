package someCoreTasks.groupUsersByAge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class User {
    private final String name;
    private final Integer age;
    private final String workPlace;
    private final String address;

    public User(String name, Integer age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        if (userList == null) {
            return Map.of();
        }
        for (var user : userList) {
            groupedUsers.computeIfAbsent(user.age, ArrayList::new).add(user);
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Angi", 19, "Yandex", "Moscow"),
                new User("Vlad", 26, "Uber", "Amsterdam"),
                new User("Pepe", 8, "PepeCorporation", "PepeLand"),
                new User("Natalya", 19, "Aston", "Serpukhow")
        );
        System.out.println(groupUsers(users));
    }

}
