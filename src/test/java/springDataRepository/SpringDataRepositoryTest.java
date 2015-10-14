package springDataRepository;

import config.SpringDataRepositoryConfig;
import model.CdDisk;
import services.jpaServices.JpaRepoCdDiskService;
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

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dmakarov on 9/21/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataRepositoryConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringDataRepositoryTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    @Qualifier("yellowBean")
    private CdDisk cdDisk1;

    @Autowired
    private JpaRepoCdDiskService cdDiskService;

    @Test
    public void cdDisk1_ShouldNotBeNull () {
        assertNotNull(cdDisk1);
    }

    @Test
    @Transactional
    public void cdDisk2_ShouldBeAddedCorrectly () {
        cdDisk1.setId(2);
        cdDiskService.saveCdDisk(cdDisk1);
        CdDisk getCddisk = cdDiskService.getCdDisk(cdDisk1.getId());
        assertEquals(cdDisk1, getCddisk);
    }

    @Test
    public void cdDisk3_ShouldFindCdDiskByArtistCorrectly () {
        CdDisk findedCddisk = cdDiskService.getCdDiskByArtist("test_artist");
        assertNotNull(findedCddisk);
    }

}
