package dao.jdbc;

import dao.CdPlayerDao;
import model.CdPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import services.coreServices.CdDiskService;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dmakarov on 9/21/2015.
 */
@Repository
public class CdPlayerDaoJdbcImpl implements CdPlayerDao {
    @Autowired
    CdDiskService cdDiskService;

    private static Logger LOGGER = LoggerFactory.getLogger(CdPlayerDaoJdbcImpl.class);
    private final static String CD_PLAYER_ADD_QUARY = "insert into CdPlayer (CdPlayerid, disk_cddiskid) values (?, ?)";
    private final static String CD_PLAYER_UPDATE_QUARY = "update CdPlayer set disk_cddiskid=? where CdPlayerid = ?";
    private final static String CD_PLAYER_DELETE_QUARY = "delete from CdPlayer where CdPlayerid = ?";

    private JdbcOperations jdbcOperations;

    @Autowired
    public CdPlayerDaoJdbcImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public CdPlayer getCdPlayer(long id) {
        LOGGER.info("GETTING CdPlayer WITH ID: {}", id);

        CdPlayer cdPlayer = this.jdbcOperations.queryForObject(
                "select CDPLAYERID, DISK_CDDISKID from CdPlayer where CDPLAYERID = ?",
                new Object[]{id},
                new RowMapper<CdPlayer>() {
                    public CdPlayer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        CdPlayer cdPlayer = new CdPlayer();
                        cdPlayer.setId(rs.getInt("CdPlayerid"));
                        cdPlayer.setDisk(cdDiskService.getCdDisk(rs.getInt("disk_cddiskid")));
                        return cdPlayer;
                    }
                });
        return cdPlayer;
    }


    public void saveCdPlayer(CdPlayer cdPlayer) {
        LOGGER.info("ADDING NEW CdPlayer: {}, {}", cdPlayer.getId(), cdPlayer.getDisk());
        jdbcOperations.update(CD_PLAYER_ADD_QUARY,  cdPlayer.getDisk().getId(), cdPlayer.getId());
    }


    public long updateCdPlayer(CdPlayer cdPlayer) {
        jdbcOperations.update(CD_PLAYER_UPDATE_QUARY,  cdPlayer.getDisk().getId(), cdPlayer.getId());
        return cdPlayer.getId();
    }

    public void deleteCdPlayer(CdPlayer cdPlayer) {
        jdbcOperations.update(CD_PLAYER_DELETE_QUARY, cdPlayer.getId());
    }
}
