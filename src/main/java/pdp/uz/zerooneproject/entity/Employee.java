package pdp.uz.zerooneproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String pinfl;
    private LocalDate hireData;

    @ManyToOne
    private Organization organization;
}
