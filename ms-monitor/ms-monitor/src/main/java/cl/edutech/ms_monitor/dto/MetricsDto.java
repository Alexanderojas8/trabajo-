package cl.edutech.ms_monitor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetricsDto {
    private double cpuUsage;
    private double memoryUsage;
    private int activeThreads;
}