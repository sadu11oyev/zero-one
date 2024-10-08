package pdp.uz.zerooneproject.service;

import pdp.uz.zerooneproject.model.request.OrganizationReqDto;
import pdp.uz.zerooneproject.model.response.OrganizationResDto;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {
    List<OrganizationResDto> getAll();

    UUID addOrganization(OrganizationReqDto reqDto);

    Object editOrganization(UUID organizationId, OrganizationReqDto organizationReqDto);

    void delete(UUID organizationId);
}
