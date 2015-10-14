package services.jpaServices;

import model.CdDisk;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface JpaRepoCdDiskService {
    void saveCdDisk(CdDisk cdDisk);

    CdDisk getCdDisk(long id);

    long updateCdDick(CdDisk cdDisk);

    void deleteCdDisk(CdDisk cdDisk);

    CdDisk getCdDiskByArtist(String artist);
}
