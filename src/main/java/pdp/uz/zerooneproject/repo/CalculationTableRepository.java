package pdp.uz.zerooneproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pdp.uz.zerooneproject.entity.CalculationTable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface CalculationTableRepository extends JpaRepository<CalculationTable, UUID> {

    @Query(nativeQuery = true, value = """
        SELECT ee.pinfl, SUM(ct.rate) as allRates
        FROM calculation_table ct JOIN employee ee on ct.employee_id = ee.id
        WHERE ct.date BETWEEN :startDate AND :endDate
        GROUP BY ee.pinfl
        HAVING SUM(ct.rate) > :rate
            """)
    List<Object[]> getSecondAssign(@Param("startDate") LocalDate startDate,
                                                   @Param("endDate") LocalDate endDate,
                                                   @Param("rate") Float rate);


    @Query(nativeQuery = true, value = """
            SELECT e.pinfl,
                   COUNT(DISTINCT o.id) AS totalOrganizations,
                   SUM(ct.amount) AS totalSalary
            FROM calculation_table ct
                     JOIN employee e ON ct.employee_id = e.id
                     JOIN organization o ON ct.organization_id = o.id
                     JOIN region r ON o.region_id = r.id
            WHERE ct.date BETWEEN :startDate AND :endDate
            GROUP BY e.pinfl
            HAVING COUNT(DISTINCT r.id) > 1;
            """)
    List<Object[]> getThirdAssign(@Param("startDate") LocalDate startDate,
                                @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true, value = """
            SELECT
                e.id AS employeeId,
                e.first_name AS employeeFirstName,
                e.last_name AS employeeLastName,
                e.pinfl AS pinfl,
                o.id AS organizationId,
                o.name AS organizationName,
                AVG(ct.amount) AS averageSalary
            FROM
                calculation_table ct
            JOIN
                employee e ON ct.employee_id = e.id
            JOIN
                organization o ON e.organization_id = o.id
            WHERE
                o.id = :organizationId
                AND ct.date BETWEEN :startDate AND :endDate
            GROUP BY
                e.id, o.id;
            
        """)
    List<Object[]> getFourthAssign(@Param("organizationId") UUID organizationId,
                                 @Param("startDate") LocalDate startDate,
                                 @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true, value = """
            SELECT e.id AS employeeId,
               e.first_name AS employeeFirstName,
               e.last_name AS employeeLastName,
               e.pinfl AS pinfl,
               SUM(CASE WHEN ct.calculation_type = 'SALARY' THEN ct.amount ELSE 0 END) AS totalSalary,
               SUM(CASE WHEN ct.calculation_type = 'VACATION' THEN ct.amount ELSE 0 END) AS totalVacationPay
        FROM calculation_table ct
        JOIN employee e ON ct.employee_id = e.id
        WHERE ct.date BETWEEN :startDate AND :endDate
        AND ct.calculation_type IN ('SALARY', 'VACATION')
        GROUP BY e.id, e.first_name, e.last_name
        HAVING SUM(CASE WHEN ct.calculation_type = 'SALARY' THEN 1 ELSE 0 END) > 0
           AND SUM(CASE WHEN ct.calculation_type = 'VACATION' THEN 1 ELSE 0 END) > 0;
        """)
    List<Object[]> getFifthAssign(@Param("startDate") LocalDate startDate,
                                @Param("endDate") LocalDate endDate);
}