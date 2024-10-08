package pdp.uz.zerooneproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdp.uz.zerooneproject.entity.Employee;
import pdp.uz.zerooneproject.mappers.EmployeeReqMapper;
import pdp.uz.zerooneproject.mappers.EmployeeResMapper;
import pdp.uz.zerooneproject.model.request.EmployeeReqDto;
import pdp.uz.zerooneproject.model.response.EmployeeResDto;
import pdp.uz.zerooneproject.repo.EmployeeRepository;
import pdp.uz.zerooneproject.repo.OrganizationRepository;
import pdp.uz.zerooneproject.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeReqMapper employeeReqMapper;
    private final EmployeeResMapper employeeResMapper;
    private final OrganizationRepository organizationRepository;
    @Override
    public List<EmployeeResDto> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employeeResMapper::toResDto).toList();
    }

    @Override
    public UUID addEmployee(EmployeeReqDto employeeReqDto) {
        Employee employee = employeeReqMapper.toEntity(employeeReqDto);
        employee.setOrganization(organizationRepository.findById(employeeReqDto.getOrganizationId()).get());
        employeeRepository.save(employee);
        return employee.getId();
    }

    @Override
    public Object editEmployee(UUID employeeId, EmployeeReqDto employeeReqDto) {
        Optional<Employee> opt = employeeRepository.findById(employeeId);
        if (opt.isPresent()){
            Employee employee = opt.get();
            employee.setFirstName(employeeReqDto.getFirstName());
            employee.setLastName(employeeReqDto.getLastName());
            employee.setPinfl(employeeReqDto.getPinfl());
            employee.setHireData(employeeReqDto.getHireData());
            employee.setOrganization(organizationRepository.findById(employeeReqDto.getOrganizationId()).get());
            employeeRepository.save(employee);
            return employeeResMapper.toResDto(employee);
        }else {
            return "Employee not found";
        }
    }

    @Override
    public void deleteEmployee(UUID employeeId) {
     employeeRepository.deleteById(employeeId);
    }

}
