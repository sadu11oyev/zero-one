package pdp.uz.zerooneproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdp.uz.zerooneproject.entity.Region;
import pdp.uz.zerooneproject.mappers.RegionMapper;
import pdp.uz.zerooneproject.model.request.RegionReqDto;
import pdp.uz.zerooneproject.model.response.RegionResDto;
import pdp.uz.zerooneproject.repo.RegionRepository;
import pdp.uz.zerooneproject.service.RegionService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;
    @Override
    public List<RegionResDto> getAll() {
        List<Region> regions = regionRepository.findAll();
        return regions.stream().map(regionMapper::toResDto).toList();
    }

    @Override
    public UUID save(RegionReqDto regionDto) {
        Region region = regionMapper.toEntity(regionDto);
        regionRepository.save(region);
        return region.getId();
    }

    @Override
    public String editRegion(UUID id, RegionReqDto regionDto) {
        Optional<Region> opt= regionRepository.findById(id);
        if (opt.isEmpty()){
            return "Not found";
        }else {
            Region region = opt.get();
            region.setName(regionDto.getName());
            regionRepository.save(region);
            return region.getName();
        }
    }

    @Override
    public void deleteRegion(UUID id) {
        regionRepository.deleteById(id);
    }

}
