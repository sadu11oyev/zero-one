package pdp.uz.zerooneproject.mappers;

import org.mapstruct.*;
import pdp.uz.zerooneproject.entity.Organization;
import pdp.uz.zerooneproject.model.response.OrganizationResDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationResMapper {

    @Mapping(source = "region.name", target = "regionName")
    @Mapping(source = "organization.name", target = "organizationName")
    OrganizationResDto toResDto(Organization organization);

}