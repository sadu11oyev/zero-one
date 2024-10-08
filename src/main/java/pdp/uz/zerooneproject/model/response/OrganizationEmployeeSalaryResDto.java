package pdp.uz.zerooneproject.model.response;

import java.util.UUID;

public record OrganizationEmployeeSalaryResDto (
        UUID employeeId,
        String employeeFirstName,
        String employeeLastName,
        String pinfl,
        UUID organizationId,
        String organizationName,
        Float averageSalary
){
}
