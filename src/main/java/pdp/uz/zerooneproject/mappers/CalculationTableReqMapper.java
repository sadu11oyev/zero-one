package pdp.uz.zerooneproject.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import pdp.uz.zerooneproject.entity.CalculationTable;
import pdp.uz.zerooneproject.model.request.CalculationTableReqDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CalculationTableReqMapper {
    CalculationTable toEntity(CalculationTableReqDto calculationTableReqDto);


}