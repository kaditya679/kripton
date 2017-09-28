package sqlite.feature.foreignkeyaction;

import com.abubusoft.kripton.android.annotation.BindDataSource;

@BindDataSource(daoSet={ArtistDao.class, AlbumDao.class, TrackDao.class}, fileName = "artist.db", generateSchema=true)
public interface ArtistDataSource {

}
