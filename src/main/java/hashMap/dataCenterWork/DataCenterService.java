package hashMap.dataCenterWork;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DataCenterService {

    private final DataCenter dataCenter = new DataCenter();
    private final Map<ResourceRequest, Server> reqServerMap = new HashMap<>();


    public void addNewServer(Server server) {
        dataCenter.getServerList().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServerList().remove(server);
    }


    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;
        for (Server server : dataCenter.getServerList()) {
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }


    public void allocateResources(ResourceRequest request) {
        if (request.getLoad() > 100) {
            throw new IllegalArgumentException("the load cannot be greater than the maximum load on the server");
        }
        List<Server> serverList = dataCenter.getServerList();
        Server server;
        if (serverList != null && serverList.isEmpty()) {
            createNewServer(request);
        } else {
            if (serverList.size() > 1) {
                serverList.sort((s1, s2) -> Double.compare(s2.getAvailableLoad(), s1.getAvailableLoad()));
            }
            server = serverList.get(0);
            if (server.getAvailableLoad() < request.getLoad()) {
                createNewServer(request);
            } else {
                server.setLoad(server.getLoad() + request.getLoad());
                server.setAvailableLoad(server.getAvailableLoad() - request.getLoad());
                server.setEnergyConsumption(server.getEnergyConsumption() + request.getLoad() * 3);
            }
        }
    }

    public void createNewServer(ResourceRequest request) {
        Server server = new Server(request.getLoad());
        reqServerMap.put(request, server);
        addNewServer(server);
    }

    public void releaseResources(ResourceRequest request) {
        Server server = reqServerMap.get(request);
        if (server != null) {
            server.setLoad(server.getLoad() - request.getLoad());
            server.setAvailableLoad(server.getAvailableLoad() + request.getLoad());
            server.setEnergyConsumption(server.getEnergyConsumption() - request.getLoad() * 3);
        } else {
            throw new IllegalArgumentException("Server not found for request: " + request.getId());
        }
    }

    public void optimize(OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimize(dataCenter);
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }
}
