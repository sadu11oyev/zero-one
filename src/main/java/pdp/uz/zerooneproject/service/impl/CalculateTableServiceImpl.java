package pdp.uz.zerooneproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdp.uz.zerooneproject.entity.CalculationTable;
import pdp.uz.zerooneproject.mappers.CalculationTableReqMapper;
import pdp.uz.zerooneproject.mappers.CalculationTableResMapper;
import pdp.uz.zerooneproject.model.request.CalculationTableReqDto;
import pdp.uz.zerooneproject.model.response.*;
import pdp.uz.zerooneproject.repo.CalculationTableRepository;
import pdp.uz.zerooneproject.repo.EmployeeRepository;
import pdp.uz.zerooneproject.repo.OrganizationRepository;
import pdp.uz.zerooneproject.service.CalculateTableService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculateTableServiceImpl implements CalculateTableService {
    private final CalculationTableRepository repository;
    private final CalculationTableReqMapper reqMapper;
    private final CalculationTableResMapper resMapper;
    private final EmployeeRepository employeeRepository;
    private final OrganizationRepository organizationRepository;

    @Override
    public List<CalculationTableResDto> getAll() {
        List<CalculationTable> calculationTables = repository.findAll();
        return calculationTables.stream().map(resMapper::toResDto).toList();
    }

    @Override
    public UUID addCalculateTable(CalculationTableReqDto reqDto) {
        CalculationTable calculationTable = reqMapper.toEntity(reqDto);
        calculationTable.setEmployee(employeeRepository.findById(reqDto.getEmployeeId()).get());
        calculationTable.setOrganization(organizationRepository.findById(reqDto.getOrganizationId()).get());
        repository.save(calculationTable);
        return calculationTable.getId();
    }

    @Override
    public Object editCalculateTable(UUID id, CalculationTableReqDto reqDto) {
        Optional<CalculationTable> opt = repository.findById(id);
        if (opt.isPresent()){
            CalculationTable calculationTable = opt.get();
            calculationTable.setEmployee(employeeRepository.findById(reqDto.getEmployeeId()).get());
            calculationTable.setAmount(reqDto.getAmount());
            calculationTable.setRate(reqDto.getRate());
            calculationTable.setDate(reqDto.getDate());
            calculationTable.setOrganization(organizationRepository.findById(reqDto.getOrganizationId()).get());
            calculationTable.setCalculationType(reqDto.getCalculationType());
            repository.save(calculationTable);
            return resMapper.toResDto(calculationTable);
        }else {
            return "Not found";
        }
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<EmployeeRatesResponseDto> secondAssignment(Float rate, String date) {
        LocalDate firstDate = getFirstDate(date);
        LocalDate lastDate = getLastDate(date);
        List<Object[]> results = repository.getSecondAssign(firstDate,lastDate,rate);
        return results.stream()
                .map(result -> new EmployeeRatesResponseDto(
                        (String) result[0],
                        ((Number) result[1]).floatValue()
                ))
                .toList();
    }

    @Override
    public List<EmployeeOrganizationSalaryResDto> thirdAssignment(String date) {
        LocalDate firstDate = getFirstDate(date);
        LocalDate lastDate = getLastDate(date);
        List<Object[]> results =  repository.getThirdAssign(firstDate,lastDate);
        return results.stream()
                .map(result -> new EmployeeOrganizationSalaryResDto(
                        (String) result[0],
                        ((Number) result[1]).longValue(),
                        ((Number) result[2]).doubleValue()
                ))
                .toList();
    }

    @Override
    public List<OrganizationEmployeeSalaryResDto> fourthAssignment(UUID id,String date) {
        LocalDate firstDate = getFirstDate(date);
        LocalDate lastDate = getLastDate(date);
        List<Object[]> results =  repository.getFourthAssign(id,firstDate,lastDate);
        return results.stream().map(result -> {
            UUID employeeId = (UUID) result[0];
            String employeeFirstName = (String) result[1];
            String employeeLastName = (String) result[2];
            String pinfl = (String) result[3];
            UUID organizationId = (UUID) result[4];
            String organizationName = (String) result[5];
            Float averageSalary = (Float) result[6];

            return new OrganizationEmployeeSalaryResDto(
                    employeeId,
                    employeeFirstName,
                    employeeLastName,
                    pinfl,
                    organizationId,
                    organizationName,
                    averageSalary
            );
        }).collect(Collectors.toList());

    }

    @Override
    public List<EmployeeSalaryVacationResDto> fifthAssignment(String date) {
        LocalDate firstDate = getFirstDate(date);
        LocalDate lastDate = getLastDate(date);
        List<Object[]> results =  repository.getFifthAssign(firstDate,lastDate);
        return results.stream()
                .map(result -> new EmployeeSalaryVacationResDto(
                        (UUID) result[0],
                        (String) result[1],
                        (String) result[2],
                        (String) result[3],
                        ((Number) result[4]).doubleValue(),
                        ((Number) result[5]).doubleValue()
                ))
                .toList();
    }


    private LocalDate getFirstDate(String date) {
        try {
            YearMonth yearMonth = YearMonth.parse(date, DateTimeFormatter.ofPattern("yyyy.MM"));
            return yearMonth.atDay(1);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private LocalDate getLastDate(String date) {
        try {
            YearMonth yearMonth = YearMonth.parse(date, DateTimeFormatter.ofPattern("yyyy.MM"));
            return yearMonth.atEndOfMonth();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }


}
