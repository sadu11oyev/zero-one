package pdp.uz.zerooneproject.model.response;

import lombok.Value;
import pdp.uz.zerooneproject.entity.Employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link Employee}
 */
@Value
public class EmployeeResDto implements Serializable {
    UUID id;
    String firstName;
    String lastName;
    String pinfl;
    LocalDate hireData;
    String organizationName;
}