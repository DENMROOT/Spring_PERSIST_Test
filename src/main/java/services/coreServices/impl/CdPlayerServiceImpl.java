package services.coreServices.impl;

import dao.CdPlayerDao;
import model.CdPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.coreServices.CdPlayerService;

/**
 * Created by dmakarov on 9/24/2015.
 */
@Component
public class CdPlayerServiceImpl implements CdPlayerService {
    @Autowired
    private CdPlayerDao CdPlayerDao;

    public void saveCdPlayer(CdPlayer cdPlayer) {
        CdPlayerDao.saveCdPlayer(cdPlayer);
    }

    public CdPlayer getCdPlayer(long id) {
        return CdPlayerDao.getCdPlayer(id);
    }

    public long updateCdDick(CdPlayer cdPlayer) {
        return CdPlayerDao.updateCdPlayer(cdPlayer);
    }

    public void deleteCdPlayer(CdPlayer cdPlayer) {
        CdPlayerDao.deleteCdPlayer(cdPlayer);
    }
}
