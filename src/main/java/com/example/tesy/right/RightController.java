package com.example.tesy.right;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/right")
public class RightController {

    public final RightService rightService;
    public final RightRepository rightRepository;

    @Autowired
    public RightController(RightService rightService, RightRepository rightRepository) {
        this.rightService = rightService;
        this.rightRepository = rightRepository;
    }

    @GetMapping
    public List<RightEntity> getRight() {
        return rightService.getRight();
    }

    @GetMapping (path = "{rightId}")
    public RightEntity getRight(@PathVariable("rightId") Integer rightId){
        RightEntity right = getRight().stream()
                .filter(rights -> rightId.equals(rights.getRightId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Right with id" + rightId + "does not exist !"));
        return right;
    }

    @PostMapping
    public void registerNewRight(@RequestBody RightEntity rightName){
        rightService.addNewRight(rightName);
    }

    @DeleteMapping(path = "{rightId}")
    public void deleteRight(@PathVariable("rightId") Integer rightId) {

        rightService.deleteRight(rightId);
    }

    @PutMapping(path = "{rightId}")
    public void editRight(
            @PathVariable("rightId") Integer rightId,
            @RequestParam(required = false) String rightName){
        rightService.updateRight(rightId, rightName);
    }
}
