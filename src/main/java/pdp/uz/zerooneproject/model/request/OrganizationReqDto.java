package pdp.uz.zerooneproject.model.request;

import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link pdp.uz.zerooneproject.entity.Organization}
 */
@Value
public class OrganizationReqDto implements Serializable {
    String name;
    UUID regionId;
    UUID organizationId;
}