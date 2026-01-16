package cl.edutech.ms_monitor.service.impl;

import cl.edutech.ms_monitor.service.MonitorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Override
    public String getHealth() {
        return "UP";
    }

    @Override
    public String getStatus() {
        return "OK";
    }

    @Override
    public Map<String, Object> getMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("cpu", "normal");
        metrics.put("memory", "normal");
        return metrics;
    }

    @Override
    public String getAlerts() {
        return "No alerts";
    }
}