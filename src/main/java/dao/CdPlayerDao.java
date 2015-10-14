package dao;

import model.CdPlayer;

/**
 * Created by dmakarov on 9/24/2015.
 */
public interface CdPlayerDao {
    void saveCdPlayer(CdPlayer cdPlayer);

    CdPlayer getCdPlayer(long id);

    long updateCdPlayer(CdPlayer cdPlayer);

    void deleteCdPlayer(CdPlayer cdPlayer);
}
