package pdp.uz.zerooneproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pdp.uz.zerooneproject.entity.Organization;
import pdp.uz.zerooneproject.mappers.OrganizationReqMapper;
import pdp.uz.zerooneproject.mappers.OrganizationResMapper;
import pdp.uz.zerooneproject.model.request.OrganizationReqDto;
import pdp.uz.zerooneproject.model.response.OrganizationResDto;
import pdp.uz.zerooneproject.repo.OrganizationRepository;
import pdp.uz.zerooneproject.repo.RegionRepository;
import pdp.uz.zerooneproject.service.OrganizationService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository repository;
    private final OrganizationReqMapper reqMapper;
    private final OrganizationResMapper resMapper;
    private final RegionRepository regionRepository;

    @Override
    public List<OrganizationResDto> getAll() {
        List<Organization> organizations = repository.findAll();
        return organizations.stream().map(resMapper::toResDto).toList();
    }

    @Override
    public UUID addOrganization(OrganizationReqDto reqDto) {
        Organization organization = reqMapper.toEntity(reqDto);
        organization.setRegion(regionRepository.findById(reqDto.getRegionId()).get());
        if (reqDto.getOrganizationId()!=null){
            organization.setOrganization(repository.findById(reqDto.getOrganizationId()).get());
        }
        repository.save(organization);
        return organization.getId();
    }

    @Override
    public Object editOrganization(UUID organizationId, OrganizationReqDto reqDto) {
        if (organizationId==reqDto.getOrganizationId()){
            return "Change parent organization";
        }

        Optional<Organization> opt = repository.findById(organizationId);
        if (opt.isPresent()){
            Organization organization = opt.get();
            organization.setName(reqDto.getName());
            organization.setRegion(regionRepository.findById(reqDto.getRegionId()).get());
            organization.setOrganization(repository.findById(reqDto.getOrganizationId()).get());
            repository.save(organization);
            return resMapper.toResDto(organization);
        }else {
            return "Not found";
        }
    }

    @Override
    public void delete(UUID organizationId) {
        repository.deleteById(organizationId);
    }

}
