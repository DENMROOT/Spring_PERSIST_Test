package dao.springDataRepository;

import model.CdDisk;
import model.CdPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dmakarov on 9/25/2015.
 */
@Repository
public interface CdPlayerRepository extends JpaRepository<CdPlayer, Long> {
}
