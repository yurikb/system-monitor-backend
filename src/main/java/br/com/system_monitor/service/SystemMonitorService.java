package br.com.system_monitor.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

@Service
public class SystemMonitorService {
    private final OperatingSystemMXBean osBean;

    public SystemMonitorService() {
        this.osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    public double getCpuUsage() {
        return osBean.getCpuLoad() * 100;
    }

    public double getMemoryUsage() {
        double totalMemory = osBean.getTotalMemorySize();
        double freeMemory = osBean.getFreeMemorySize();
        return ((totalMemory - freeMemory) / totalMemory) * 100;
    }

    public double getDiskUsage() {
        var diskPartition = new File("/");
        var totalSpace = diskPartition.getTotalSpace();
        var freeSpace = diskPartition.getFreeSpace();
        return ((double) (totalSpace - freeSpace) / totalSpace) * 100;
    }
}
