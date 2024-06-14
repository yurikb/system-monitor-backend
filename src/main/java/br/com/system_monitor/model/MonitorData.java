package br.com.system_monitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitorData {
    private double cpuUsage;
    private double memoryUsage;
    private double diskUsage;
}
