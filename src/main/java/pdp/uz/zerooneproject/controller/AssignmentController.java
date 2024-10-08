package pdp.uz.zerooneproject.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.zerooneproject.service.CalculateTableService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/zero/assignment")
public class AssignmentController {
    private final CalculateTableService calculateTableService;

    @GetMapping("2/{rate}/{date}")
    public ResponseEntity<?> assignment2(@PathVariable Float rate,
                                         @Parameter(description = "Date in format YYYY.MM", required = true, example = "2024.01")
                                         @PathVariable String date){
        return ResponseEntity.ok(calculateTableService.secondAssignment(rate,date));
    }

    @GetMapping("3/{date}")
    public ResponseEntity<?> assignment3(@Parameter(description = "Date in format YYYY.MM", required = true, example = "2024.01")
                                             @PathVariable String date){
        return ResponseEntity.ok(calculateTableService.thirdAssignment(date));
    }

    @GetMapping("4/{id}/{date}")
    public ResponseEntity<?> assignment4(@PathVariable UUID id,@Parameter(description = "Date in format YYYY.MM", required = true, example = "2024.01")
                                            @PathVariable String date){
        return ResponseEntity.ok(calculateTableService.fourthAssignment(id,date));
    }

    @GetMapping("5/{date}")
    public ResponseEntity<?> assignment5(@Parameter(description = "Date in format YYYY.MM", required = true, example = "2024.01") @PathVariable String date){
        return ResponseEntity.ok(calculateTableService.fifthAssignment(date));
    }

}
