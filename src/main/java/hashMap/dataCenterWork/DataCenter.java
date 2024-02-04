package hashMap.dataCenterWork;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private final List<Server> serverList = new ArrayList<>();

    {
        serverList.add(new Server(70));
        serverList.add(new Server(50));
        serverList.add(new Server(40));
    }


}
