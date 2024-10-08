package pdp.uz.zerooneproject.model.response;

import lombok.Value;
import pdp.uz.zerooneproject.entity.Organization;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Organization}
 */
@Value
public class OrganizationResDto implements Serializable {
    UUID id;
    String name;
    String regionName;
    String organizationName;
}