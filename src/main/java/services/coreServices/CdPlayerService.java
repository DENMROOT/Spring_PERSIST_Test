package services.coreServices;

import model.CdPlayer;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CdPlayerService {
    void saveCdPlayer(CdPlayer cdPlayer);

    CdPlayer getCdPlayer(long id);

    long updateCdDick(CdPlayer cdPlayer);

    void deleteCdPlayer(CdPlayer cdPlayer);
}
