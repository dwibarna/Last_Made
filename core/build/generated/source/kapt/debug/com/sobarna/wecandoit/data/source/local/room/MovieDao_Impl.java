package com.sobarna.wecandoit.data.source.local.room;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sobarna.wecandoit.data.source.local.entity.MovieEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MovieEntity> __insertionAdapterOfMovieEntity;

  private final EntityDeletionOrUpdateAdapter<MovieEntity> __updateAdapterOfMovieEntity;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovieEntity = new EntityInsertionAdapter<MovieEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `movie_table` (`id`,`original_language`,`original_title`,`overview`,`popularity`,`poster_path`,`release_date`,`title`,`vote_average`,`vote_count`,`favorite`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MovieEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getOriginal_language() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOriginal_language());
        }
        if (value.getOriginal_title() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOriginal_title());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        stmt.bindDouble(5, value.getPopularity());
        if (value.getPoster_path() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPoster_path());
        }
        if (value.getRelease_date() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRelease_date());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTitle());
        }
        stmt.bindDouble(9, value.getVote_average());
        stmt.bindLong(10, value.getVote_count());
        final int _tmp;
        _tmp = value.getFavorite() ? 1 : 0;
        stmt.bindLong(11, _tmp);
      }
    };
    this.__updateAdapterOfMovieEntity = new EntityDeletionOrUpdateAdapter<MovieEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `movie_table` SET `id` = ?,`original_language` = ?,`original_title` = ?,`overview` = ?,`popularity` = ?,`poster_path` = ?,`release_date` = ?,`title` = ?,`vote_average` = ?,`vote_count` = ?,`favorite` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MovieEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getOriginal_language() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOriginal_language());
        }
        if (value.getOriginal_title() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOriginal_title());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        stmt.bindDouble(5, value.getPopularity());
        if (value.getPoster_path() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPoster_path());
        }
        if (value.getRelease_date() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRelease_date());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTitle());
        }
        stmt.bindDouble(9, value.getVote_average());
        stmt.bindLong(10, value.getVote_count());
        final int _tmp;
        _tmp = value.getFavorite() ? 1 : 0;
        stmt.bindLong(11, _tmp);
        stmt.bindLong(12, value.getId());
      }
    };
  }

  @Override
  public Object insertMovie(final List<MovieEntity> movie, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMovieEntity.insert(movie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public void updateFavoriteMovie(final MovieEntity movie) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMovieEntity.handle(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<List<MovieEntity>> getAllMovie() {
    final String _sql = "SELECT * FROM movie_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"movie_table"}, new Callable<List<MovieEntity>>() {
      @Override
      public List<MovieEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "original_title");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final List<MovieEntity> _result = new ArrayList<MovieEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MovieEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpOriginal_language;
            if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
              _tmpOriginal_language = null;
            } else {
              _tmpOriginal_language = _cursor.getString(_cursorIndexOfOriginalLanguage);
            }
            final String _tmpOriginal_title;
            if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
              _tmpOriginal_title = null;
            } else {
              _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final String _tmpRelease_date;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpRelease_date = null;
            } else {
              _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final double _tmpVote_average;
            _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final int _tmpVote_count;
            _tmpVote_count = _cursor.getInt(_cursorIndexOfVoteCount);
            final boolean _tmpFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _tmpFavorite = _tmp != 0;
            _item = new MovieEntity(_tmpId,_tmpOriginal_language,_tmpOriginal_title,_tmpOverview,_tmpPopularity,_tmpPoster_path,_tmpRelease_date,_tmpTitle,_tmpVote_average,_tmpVote_count,_tmpFavorite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<MovieEntity>> getFavoriteMovie() {
    final String _sql = "SELECT * FROM movie_table where favorite = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"movie_table"}, new Callable<List<MovieEntity>>() {
      @Override
      public List<MovieEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "original_title");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final List<MovieEntity> _result = new ArrayList<MovieEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MovieEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpOriginal_language;
            if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
              _tmpOriginal_language = null;
            } else {
              _tmpOriginal_language = _cursor.getString(_cursorIndexOfOriginalLanguage);
            }
            final String _tmpOriginal_title;
            if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
              _tmpOriginal_title = null;
            } else {
              _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpPoster_path;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPoster_path = null;
            } else {
              _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final String _tmpRelease_date;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpRelease_date = null;
            } else {
              _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final double _tmpVote_average;
            _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final int _tmpVote_count;
            _tmpVote_count = _cursor.getInt(_cursorIndexOfVoteCount);
            final boolean _tmpFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _tmpFavorite = _tmp != 0;
            _item = new MovieEntity(_tmpId,_tmpOriginal_language,_tmpOriginal_title,_tmpOverview,_tmpPopularity,_tmpPoster_path,_tmpRelease_date,_tmpTitle,_tmpVote_average,_tmpVote_count,_tmpFavorite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
