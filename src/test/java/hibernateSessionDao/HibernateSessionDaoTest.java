package hibernateSessionDao;

import config.HibernateSessionConfig;
import model.CdDisk;
import model.CdPlayer;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.coreServices.CdDiskService;
import services.coreServices.CdPlayerService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dmakarov on 9/21/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateSessionConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HibernateSessionDaoTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    @Qualifier("yellowBean")
    private CdDisk cdDisk1;

    @Autowired
    private CdPlayer cdPlayer1;

    @Autowired
    private CdDiskService cdDiskService;

    @Autowired
    private CdPlayerService cdPlayerService;

    @Test
    public void cdDisk1_ShouldNotBeNull () {
        assertNotNull(cdDisk1);
    }

    @Test
    public void cdPlayer2_ShouldNotBeNull () {
        assertNotNull(cdPlayer1);
    }

    @Test
    public void cdDisk3_ShouldBeAddedCorrectly () {
        cdDisk1.setId(2);
        cdDiskService.saveCdDisk(cdDisk1);
        CdDisk getCddisk = cdDiskService.getCdDisk(cdDisk1.getId());
        assertEquals(cdDisk1, getCddisk);
    }

    @Test
    public void cdDisk4_ShouldBeUpdatedCorrectly () {
        cdDisk1.setArtist("Mama");
        cdDisk1.setTitle("Mama_Song");
        cdDiskService.updateCdDick(cdDisk1);
        CdDisk updatedDisk = cdDiskService.getCdDisk(cdDisk1.getId());
        assertEquals(cdDisk1, updatedDisk);
    }

    @Test
    public void cdPlayer5_CdPlayershouldPlayCd () {
        cdPlayer1.setId(1);
        cdPlayer1.setDisk(cdDisk1);
        cdPlayerService.saveCdPlayer(cdPlayer1);
        CdPlayer savedPlayer = cdPlayerService.getCdPlayer(cdPlayer1.getId());
        savedPlayer.playDisk();
        assertEquals("Mama" + ": " + "Mama_Song", log.getLog());
    }

}
