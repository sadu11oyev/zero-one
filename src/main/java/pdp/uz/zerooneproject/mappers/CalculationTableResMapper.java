package pdp.uz.zerooneproject.mappers;

import org.mapstruct.*;
import pdp.uz.zerooneproject.entity.CalculationTable;
import pdp.uz.zerooneproject.model.response.CalculationTableResDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CalculationTableResMapper {

    @Mapping(source = "organization.name", target = "organizationName")
    @Mapping(source = "employee.firstName",target = "employeeFirstName")
    @Mapping(source = "employee.lastName",target = "employeeLastName")
    CalculationTableResDto toResDto(CalculationTable calculationTable);

}