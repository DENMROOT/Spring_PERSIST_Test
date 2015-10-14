package services.jpaServices.impl;

import dao.springDataRepository.CdDiskRepository;
import model.CdDisk;
import services.jpaServices.JpaRepoCdDiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Component
public class JpaRepoCdDiskServiceImpl implements JpaRepoCdDiskService {
    @Autowired
    private CdDiskRepository cdDiskDao;

    public void saveCdDisk(CdDisk cdDisk) {
        cdDiskDao.save(cdDisk);
    }

    public CdDisk getCdDisk(long id) {
        return cdDiskDao.getOne(id);
    }

    public long updateCdDick(CdDisk cdDisk) {
        cdDiskDao.save(cdDisk);
        return cdDiskDao.getOne(cdDisk.getId()).getId();
    }

    public void deleteCdDisk(CdDisk cdDisk) {
        cdDiskDao.delete(cdDisk);
    }

    public CdDisk getCdDiskByArtist(String artist) {
        return cdDiskDao.findByArtist(artist);
    }
}
