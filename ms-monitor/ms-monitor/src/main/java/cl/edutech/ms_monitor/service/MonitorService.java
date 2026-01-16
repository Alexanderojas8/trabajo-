package cl.edutech.ms_monitor.service;

import java.util.Map;

public interface MonitorService {

    String getHealth();

    String getStatus();

    Map<String, Object> getMetrics();

    String getAlerts();
}