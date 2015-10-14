package dao.hibernateSession;

import dao.CdPlayerDao;
import model.CdPlayer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Repository
@Transactional
public class CdPlayerDaoHibernateSessionImpl implements CdPlayerDao{
    @Autowired
    private SessionFactory sessionFactory;

    public CdPlayerDaoHibernateSessionImpl() {
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void saveCdPlayer(CdPlayer cdPlayer) {
        currentSession().save(cdPlayer);
    }

    public CdPlayer getCdPlayer(long id) {
        return (CdPlayer) currentSession().get(CdPlayer.class, id);
    }

    public long updateCdPlayer(CdPlayer cdPlayer) {
        String hqlUpdate =
                "update CdPlayer cd " +
                        "set cd.artist = :newArtist " +
                        ", cd.title = :newTitle " +
                        "where cd.id = :id";
        return currentSession().createQuery(hqlUpdate)
                .setLong("id", cdPlayer.getId())
                .executeUpdate();
    }

    public void deleteCdPlayer(CdPlayer CdPlayer) {

    }
}