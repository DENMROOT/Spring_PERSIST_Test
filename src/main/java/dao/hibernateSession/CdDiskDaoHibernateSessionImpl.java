package dao.hibernateSession;

import dao.CdDiskDao;
import model.CdDisk;
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
public class CdDiskDaoHibernateSessionImpl implements CdDiskDao{
    @Autowired
    private SessionFactory sessionFactory;

    public CdDiskDaoHibernateSessionImpl() {
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void saveCdDisk(CdDisk cdDisk) {
        currentSession().save(cdDisk);
    }

    public CdDisk getCdDisk(long id) {
        return (CdDisk) currentSession().get(CdDisk.class, id);
    }

    public long updateCdDisk(CdDisk cdDisk) {
        String hqlUpdate =
                "update CdDisk cd " +
                        "set cd.artist = :newArtist " +
                        ", cd.title = :newTitle " +
                        "where cd.id = :id";
        return currentSession().createQuery(hqlUpdate)
                .setString("newArtist", cdDisk.getArtist() )
                .setString("newTitle", cdDisk.getTitle() )
                .setLong("id", cdDisk.getId())
                .executeUpdate();
    }

    public void deleteCdDisk(CdDisk cdDisk) {

    }
}
