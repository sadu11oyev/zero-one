package pdp.uz.zerooneproject.mappers;

import org.mapstruct.*;
import pdp.uz.zerooneproject.entity.Region;
import pdp.uz.zerooneproject.model.request.RegionReqDto;
import pdp.uz.zerooneproject.model.response.RegionResDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionMapper {
    Region toEntity(RegionReqDto regionDto);

    RegionResDto toResDto(Region region);

}