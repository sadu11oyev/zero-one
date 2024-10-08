package pdp.uz.zerooneproject.model.request;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link pdp.uz.zerooneproject.entity.Employee}
 */
@Value
public class EmployeeReqDto implements Serializable {
    String firstName;
    String lastName;
    String pinfl;
    LocalDate hireData;
    UUID organizationId;
}