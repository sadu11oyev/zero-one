package pdp.uz.zerooneproject.service;

import pdp.uz.zerooneproject.model.request.RegionReqDto;
import pdp.uz.zerooneproject.model.response.RegionResDto;

import java.util.List;
import java.util.UUID;

public interface RegionService {
    List<RegionResDto> getAll();

    UUID save(RegionReqDto regionDto);

    String editRegion(UUID id, RegionReqDto regionDto);

    void deleteRegion(UUID id);
}
