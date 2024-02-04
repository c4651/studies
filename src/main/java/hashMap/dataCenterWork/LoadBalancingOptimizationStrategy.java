package hashMap.dataCenterWork;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> serverList = dataCenter.getServerList();
        double average = serverList.stream().mapToDouble(Server::getLoad).average().getAsDouble();

        for (Server server : serverList) {
            server.setLoad(average);
            server.setAvailableLoad(server.getMaxLoad() - server.getLoad());
        }
    }
}
