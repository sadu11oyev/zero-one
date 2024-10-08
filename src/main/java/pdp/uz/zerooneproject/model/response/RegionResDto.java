package pdp.uz.zerooneproject.model.response;

import lombok.Value;
import pdp.uz.zerooneproject.entity.Region;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Region}
 */
@Value
public class RegionResDto implements Serializable {
    UUID id;
    String name;
}