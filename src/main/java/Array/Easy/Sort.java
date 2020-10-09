package Array.Easy;

import java.util.*;

interface AlertDAO{
    UUID addAlert(Date time);
    Date getAlert(UUID id);
}

class AlertService {
    private final AlertDAO storage;
    public AlertService(AlertDAO daoImpl){
        storage=daoImpl;
    }

    public UUID raiseAlert() {
        int[] arr = new int[3];
        Set<Integer> se = new HashSet(Collections.singleton(arr));
        return this.storage.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }
}

class MapAlertDAO implements AlertDAO{
    private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();

    public UUID addAlert(Date time) {
        UUID id = UUID.randomUUID();
        this.alerts.put(id, time);
        return id;
    }

    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }
}