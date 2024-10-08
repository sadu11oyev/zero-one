package pdp.uz.zerooneproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.zerooneproject.model.request.EmployeeReqDto;
import pdp.uz.zerooneproject.service.EmployeeService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/zero/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        return  ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeReqDto employeeReqDto){
        return ResponseEntity.ok(employeeService.addEmployee(employeeReqDto));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editEmployee(@PathVariable UUID id,@RequestBody EmployeeReqDto employeeReqDto){
        return  ResponseEntity.ok(employeeService.editEmployee(id,employeeReqDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable UUID id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}
