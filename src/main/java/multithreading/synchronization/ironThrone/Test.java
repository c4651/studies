package multithreading.synchronization.ironThrone;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("Lord");
        roles.add("Warrior");
        House baratreon = new House(roles);
        User firstUser = new User("Angie", baratreon);
        Thread first = new Thread(() -> {
            try {
                firstUser.joinHouse();
                Thread.sleep(1000);
                firstUser.leaveHouse();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        first.start();
        User secondUser = new User("Pepe", baratreon);
        Thread second = new Thread(secondUser::joinHouse);
        second.start();
        User thirdUser = new User("Popo", baratreon);
        Thread third = new Thread(thirdUser::joinHouse);
        third.start();
        User fourthUser = new User("Pupu", baratreon);
        Thread fourth = new Thread(fourthUser::joinHouse);
        fourth.start();
    }
}
