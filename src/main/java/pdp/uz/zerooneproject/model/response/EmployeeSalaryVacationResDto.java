package pdp.uz.zerooneproject.model.response;

import java.util.UUID;

public record EmployeeSalaryVacationResDto(
        UUID employeeId,
        String employeeFirstName,
        String employeeLastName,
        String pinfl,
        Double totalSalary,
        Double totalVacationPay) {
}
