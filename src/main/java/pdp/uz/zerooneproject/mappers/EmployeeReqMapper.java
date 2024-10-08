package pdp.uz.zerooneproject.mappers;

import org.mapstruct.*;
import pdp.uz.zerooneproject.entity.Employee;
import pdp.uz.zerooneproject.model.request.EmployeeReqDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeReqMapper {
    Employee toEntity(EmployeeReqDto employeeReqDto);

}