package pdp.uz.zerooneproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.zerooneproject.model.request.CalculationTableReqDto;
import pdp.uz.zerooneproject.service.CalculateTableService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/zero/calculateTable")
public class CalculateTableController {

    private final CalculateTableService calculateTableService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(calculateTableService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> addCalculateTable(@RequestBody CalculationTableReqDto reqDto){
        return ResponseEntity.ok(calculateTableService.addCalculateTable(reqDto));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editCalculateTable(@PathVariable UUID id, @RequestBody CalculationTableReqDto reqDto){
        return ResponseEntity.ok(calculateTableService.editCalculateTable(id,reqDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        calculateTableService.delete(id);
        return ResponseEntity.ok().build();
    }

}
