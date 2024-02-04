package hashMap.cacheсache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}