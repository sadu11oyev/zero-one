package pdp.uz.zerooneproject.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link pdp.uz.zerooneproject.entity.Region}
 */
@Getter
public class RegionReqDto implements Serializable {
    @NotNull
     String name;

}