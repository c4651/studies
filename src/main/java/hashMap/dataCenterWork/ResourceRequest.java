package hashMap.dataCenterWork;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResourceRequest {
    private int id;
    private double load;
}