package services.coreServices.impl;

import dao.CdDiskDao;
import model.CdDisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.coreServices.CdDiskService;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Component
public class CdDiskServiceImpl implements CdDiskService {
    @Autowired
    private CdDiskDao cdDiskDao;

    public void saveCdDisk(CdDisk cdDisk) {
        cdDiskDao.saveCdDisk(cdDisk);
    }

    public CdDisk getCdDisk(long id) {
        return cdDiskDao.getCdDisk(id);
    }

    public long updateCdDick(CdDisk cdDisk) {
        return cdDiskDao.updateCdDisk(cdDisk);
    }

    public void deleteCdDisk(CdDisk cdDisk) {
        cdDiskDao.deleteCdDisk(cdDisk);
    }
}
