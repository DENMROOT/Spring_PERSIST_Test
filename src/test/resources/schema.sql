drop table cdplayer if exists;
drop table cddisk if exists;
CREATE TABLE CDDISK
(
    CDDISKID    NUMERIC     NOT NULL,
    ARTIST      VARCHAR(30)     NOT NULL,
    TITLE       VARCHAR(50)     NOT NULL,
    constraint PK_CDDISK primary key (CDDISKID)
);

CREATE TABLE CDPLAYER
(
    CDPLAYERID    NUMERIC     NOT NULL,
    DISK_CDDISKID    NUMERIC     NOT NULL,
    constraint PK_CDPLAYER primary key (CDPLAYERID)
);