package dao;

import model.CdDisk;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CdDiskDao {
    void saveCdDisk(CdDisk cdDisk);

    CdDisk getCdDisk(long id);

    long updateCdDisk(CdDisk cdDisk);

    void deleteCdDisk(CdDisk cdDisk);
}
