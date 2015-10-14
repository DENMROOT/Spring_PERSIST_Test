package dao.jpaRepository;

import dao.CdPlayerDao;
import model.CdPlayer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dmakarov on 9/22/2015.
 */
@Repository
@Transactional
public class CdPlayerDaoRepositoryImpl implements CdPlayerDao{
    @PersistenceContext
    private EntityManager em;

    public void saveCdPlayer(CdPlayer cdPlayer) {
        em.persist(cdPlayer);
    }

    public CdPlayer getCdPlayer(long id) {
        return em.find(CdPlayer.class, id);
    }

    public long updateCdPlayer(CdPlayer cdPlayer) {
        return em.merge(cdPlayer).getId();
    }

    public void deleteCdPlayer(CdPlayer cdPlayer) {

    }

}
