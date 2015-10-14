package JDBCTemplate;

import config.JDBCTemplateConfig;
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
import org.springframework.dao.EmptyResultDataAccessException;
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
@ContextConfiguration(classes = JDBCTemplateConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCTemplateTest {
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
    public void cdDisk2_ShouldBeAddedCorrectly () {
        cdDisk1.setId(2);
        cdDiskService.saveCdDisk(cdDisk1);
        CdDisk getCddisk = cdDiskService.getCdDisk(cdDisk1.getId());
        assertEquals(cdDisk1, getCddisk);
    }

    @Test
    public void cdDisk3_ShouldBeUpdatedProperly () {
        cdDisk1.setArtist("JUHAHA");
        cdDisk1.setTitle("JUHAHA_SONG1");
        cdDiskService.updateCdDick(cdDisk1);
        CdDisk updatedCDDisk = cdDiskService.getCdDisk(cdDisk1.getId());
        assertEquals(cdDisk1, updatedCDDisk);
    }

    @Test (expected = EmptyResultDataAccessException.class)
    public void cdDisk4_ShouldBeDeletedProperly () {
        long diskid = cdDisk1.getId();
        cdDiskService.deleteCdDisk(cdDisk1);
        CdDisk updatedCDDisk = cdDiskService.getCdDisk(diskid);
    }

}
