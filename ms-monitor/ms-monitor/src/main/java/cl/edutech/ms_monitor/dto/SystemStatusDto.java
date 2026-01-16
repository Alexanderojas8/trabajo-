package cl.edutech.ms_monitor.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SystemStatusDto {
    private String service;
    private String status;
    private String timestamp;
}