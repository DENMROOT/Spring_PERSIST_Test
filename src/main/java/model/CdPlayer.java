package model;

import javax.persistence.*;

/**
 * Created by dmakarov on 9/14/2015.
 */
@Entity
@Table(name = "CDPLAYER")
public class CdPlayer{
    @Id
    @Column (name = "CDPLAYERID")
    private long id;

    @OneToOne
    private CdDisk disk;

    public CdPlayer() {
    }

    public CdPlayer(CdDisk disk) {
        this.disk = disk;
    }

    public CdDisk getDisk() {
        return disk;
    }

    public void setDisk(CdDisk disk) {
        this.disk = disk;
    }

    public void playDisk() {
        this.disk.play();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
