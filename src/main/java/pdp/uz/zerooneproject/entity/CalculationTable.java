package pdp.uz.zerooneproject.entity;

import jakarta.persistence.*;
import lombok.*;
import pdp.uz.zerooneproject.entity.enums.CalculationType;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "calculation_table")
public class CalculationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Employee employee;
    private Integer amount;
    private Float rate;
    private LocalDate date;

    @ManyToOne
    private Organization organization;

    @Enumerated(EnumType.STRING)
    private CalculationType calculationType;
}
