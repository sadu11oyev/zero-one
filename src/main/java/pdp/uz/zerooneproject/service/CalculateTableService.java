package pdp.uz.zerooneproject.service;

import pdp.uz.zerooneproject.model.request.CalculationTableReqDto;
import pdp.uz.zerooneproject.model.response.*;

import java.util.List;
import java.util.UUID;

public interface CalculateTableService {
    List<CalculationTableResDto> getAll();

    UUID addCalculateTable(CalculationTableReqDto reqDto);

    Object editCalculateTable(UUID id, CalculationTableReqDto reqDto);

    void delete(UUID id);

    List<EmployeeRatesResponseDto> secondAssignment(Float rate, String date);

    List<EmployeeOrganizationSalaryResDto> thirdAssignment(String date);

    List<OrganizationEmployeeSalaryResDto> fourthAssignment(UUID id, String date);

    List<EmployeeSalaryVacationResDto> fifthAssignment(String date);
}
