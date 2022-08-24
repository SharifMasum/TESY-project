package com.example.tesy.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/status")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<StatusEntity> getStatusEntitys() {
        return statusService.getStatusEntitys();
    }

    @PostMapping
    public void registerNewStatusEntity(
            @RequestBody StatusEntity statusEntity) {
        statusService.addNewStatusEntity(statusEntity);
    }

    @DeleteMapping(path = "{statusId}")
    public void deleteStatusEntity(
            @PathVariable("statusId") Long statusId) {
        statusService.deleteStatusEntity(statusId);
    }

    @PutMapping(path = "{statusId}")
    public void updateStatusEntity(
            @PathVariable("statusId") Long statusId,
            @RequestParam(required = false) String name) {
        statusService.updateStatusEntity(statusId, name);
    }
}
