package pdp.uz.zerooneproject.model.request;

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
public class CalculationTableReqDto implements Serializable {
    UUID employeeId;
    Integer amount;
    Float rate;
    LocalDate date;
    UUID organizationId;
    @NotNull
    CalculationType calculationType;
}