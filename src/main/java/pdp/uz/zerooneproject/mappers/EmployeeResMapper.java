package pdp.uz.zerooneproject.mappers;

import org.mapstruct.*;
import pdp.uz.zerooneproject.entity.Employee;
import pdp.uz.zerooneproject.model.response.EmployeeResDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeResMapper {

    @Mapping(source = "organization.name",target = "organizationName")
    EmployeeResDto toResDto(Employee employee);

}