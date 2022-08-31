package com.example.tesy.status;

import com.example.tesy.observation.ObservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/status")
public class StatusController {

    private final StatusService statusService;
    private final StatusRepository statusRepository;

    @Autowired
    public StatusController(StatusService statusService, StatusRepository statusRepository) {
        this.statusService = statusService;
        this.statusRepository = statusRepository;
    }

    @GetMapping
    public List<StatusEntity> getStatusEntitys() {
        return statusService.getStatusEntitys();
    }

    // Get by Id
    @GetMapping(path = "{statusId}")
    public StatusEntity findStatusById(@PathVariable (value =
            "statusId") Long statusId) {
        return this.statusRepository.findById(statusId).orElse(null);
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
