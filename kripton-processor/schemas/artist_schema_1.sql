------------------------------------------------------------------------------------
--
-- Filename: artist_schema_1.sql
--
-- Date: Mon Jul 23 21:00:54 CEST 2018
--
------------------------------------------------------------------------------------

CREATE TABLE track (id INTEGER PRIMARY KEY AUTOINCREMENT, album_id INTEGER, FOREIGN KEY(album_id) REFERENCES album(id) ON DELETE CASCADE ON UPDATE SET NULL);
CREATE TABLE artist (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);
CREATE TABLE album (id INTEGER PRIMARY KEY AUTOINCREMENT, artist_id INTEGER, name TEXT, FOREIGN KEY(artist_id) REFERENCES artist(id) ON DELETE CASCADE ON UPDATE CASCADE);
