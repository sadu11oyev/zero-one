package pdp.uz.zerooneproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.zerooneproject.entity.Region;

import java.util.UUID;

@Repository
public interface RegionRepository extends JpaRepository<Region, UUID> {

}