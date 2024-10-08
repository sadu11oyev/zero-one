package pdp.uz.zerooneproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.zerooneproject.model.request.RegionReqDto;
import pdp.uz.zerooneproject.service.RegionService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/zero/region")
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<?> getAllRegions(){
        return ResponseEntity.ok(regionService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> addRegion(@RequestBody RegionReqDto regionDto){
        return ResponseEntity.ok(regionService.save(regionDto));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editRegion(@PathVariable UUID id, @RequestBody RegionReqDto regionDto){
        return ResponseEntity.ok(regionService.editRegion(id,regionDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable UUID id){
        regionService.deleteRegion(id);
        return ResponseEntity.ok().build();
    }

}
