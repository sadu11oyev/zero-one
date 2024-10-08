package pdp.uz.zerooneproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.zerooneproject.model.request.OrganizationReqDto;
import pdp.uz.zerooneproject.service.OrganizationService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/zero/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(organizationService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> addOrganization(@RequestBody OrganizationReqDto organizationReqDto){
        return ResponseEntity.ok(organizationService.addOrganization(organizationReqDto));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editOrganization(@PathVariable UUID id,@RequestBody OrganizationReqDto organizationReqDto){
        return ResponseEntity.ok(organizationService.editOrganization(id,organizationReqDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteOrganization(@PathVariable UUID id){
        organizationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
