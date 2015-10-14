package dao.springDataRepository;

import model.CdDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dmakarov on 9/25/2015.
 */
@Repository
public interface CdDiskRepository extends JpaRepository<CdDisk, Long> {
    CdDisk findByArtist(String artist);
}
