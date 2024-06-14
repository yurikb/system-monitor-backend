package br.com.system_monitor.controller;

import br.com.system_monitor.model.MonitorData;
import br.com.system_monitor.service.SystemMonitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
public class SystemMonitorController {
    private final SystemMonitorService service;

    public SystemMonitorController(SystemMonitorService service) {
        this.service = service;
    }

    @GetMapping("/cpu")
    public double getCpuUsage() {
        return service.getCpuUsage();
    }

    @GetMapping("/memory")
    public double getMemoryUsage() {
        return service.getMemoryUsage();
    }

    @GetMapping("/disk")
    public double getDiskUsage() {
        return service.getDiskUsage();
    }

    @GetMapping
    public MonitorData getMonitorData() {
        return new MonitorData(service.getCpuUsage(), service.getMemoryUsage(), service.getDiskUsage());
    }
}
