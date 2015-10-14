package dao.jdbc;

import dao.CdDiskDao;
import model.CdDisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dmakarov on 9/21/2015.
 */
@Repository
public class CdDiskDaoJdbcImpl implements CdDiskDao {
    private static Logger LOGGER = LoggerFactory.getLogger(CdDiskDaoJdbcImpl.class);
    private final static String CD_DISK_ADD_QUARY = "insert into cddisk (cddiskid, artist, title) values (?, ?, ?)";
    private final static String CD_DISK_UPDATE_QUARY = "update cddisk set artist=?, title = ? where cddiskid = ?";
    private final static String CD_DISK_DELETE_QUARY = "delete from cddisk where cddiskid = ?";

    private JdbcOperations jdbcOperations;

    @Autowired
    public CdDiskDaoJdbcImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public CdDisk getCdDisk(long id) {
        LOGGER.info("GETTING CDDISK WITH ID: {}", id);

        CdDisk cdDisk = this.jdbcOperations.queryForObject(
                "select CDDISKID, ARTIST, TITLE from cddisk where CDDISKID = ?",
                new Object[]{id},
                new RowMapper<CdDisk>() {
                    public CdDisk mapRow(ResultSet rs, int rowNum) throws SQLException {
                        CdDisk cdDisk = new CdDisk();
                        cdDisk.setId(rs.getInt("cddiskid"));
                        cdDisk.setArtist(rs.getString("artist"));
                        cdDisk.setTitle(rs.getString("title"));
                        return cdDisk;
                    }
                });
        return cdDisk;
    }


    public void saveCdDisk(CdDisk cdDisk) {
        LOGGER.info("ADDING NEW CDDISK: {}, {}", cdDisk.getArtist(), cdDisk.getTitle());
        jdbcOperations.update(CD_DISK_ADD_QUARY, cdDisk.getId(), cdDisk.getArtist(), cdDisk.getTitle());
    }


    public long updateCdDisk(CdDisk cdDisk) {
        jdbcOperations.update(CD_DISK_UPDATE_QUARY, cdDisk.getArtist(), cdDisk.getTitle(), cdDisk.getId());
        return cdDisk.getId();
    }

    public void deleteCdDisk(CdDisk cdDisk) {
        jdbcOperations.update(CD_DISK_DELETE_QUARY, cdDisk.getId());
    }
}
