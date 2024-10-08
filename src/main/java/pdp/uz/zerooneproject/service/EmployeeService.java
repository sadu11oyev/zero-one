package pdp.uz.zerooneproject.service;

import pdp.uz.zerooneproject.model.request.EmployeeReqDto;
import pdp.uz.zerooneproject.model.response.EmployeeResDto;

import java.util.List;
import java.util.UUID;


public interface EmployeeService {
    List<EmployeeResDto> getAll();

    UUID addEmployee(EmployeeReqDto employeeReqDto);

    Object editEmployee(UUID employeeId, EmployeeReqDto employeeReqDto);

    void deleteEmployee(UUID employeeId);
}
