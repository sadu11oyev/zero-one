package pdp.uz.zerooneproject.model.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import pdp.uz.zerooneproject.entity.CalculationTable;
import pdp.uz.zerooneproject.entity.enums.CalculationType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link CalculationTable}
 */
@Value
public class CalculationTableResDto implements Serializable {
    UUID id;
    String employeeFirstName;
    String employeeLastName;
    Integer amount;
    Float rate;
    LocalDate date;
    String organizationName;
    @NotNull
    CalculationType calculationType;
}