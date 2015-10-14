package dao.jpaRepository;

import dao.CdDiskDao;
import model.CdDisk;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dmakarov on 9/22/2015.
 */
@Repository
@Transactional
public class CdDiskDaoRepositoryImpl implements CdDiskDao{
    @PersistenceContext
    private EntityManager em;

    public void saveCdDisk(CdDisk cdDisk) {
        em.persist(cdDisk);
    }

    public CdDisk getCdDisk(long id) {
        return em.find(CdDisk.class, id);
    }

    public long updateCdDisk(CdDisk cdDisk) {
        return em.merge(cdDisk).getId();
    }

    public void deleteCdDisk(CdDisk cdDisk) {

    }

}
