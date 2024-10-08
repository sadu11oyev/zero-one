package pdp.uz.zerooneproject.mappers;

import org.mapstruct.*;
import pdp.uz.zerooneproject.entity.Organization;
import pdp.uz.zerooneproject.model.request.OrganizationReqDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationReqMapper {
    Organization toEntity(OrganizationReqDto organizationReqDto);

}