package com.mirzahansuslu.mymoviewiki.Db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mirzahansuslu.mymoviewiki.Model.MovieModel;
import com.mirzahansuslu.mymoviewiki.Repository.MainRepo;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "movies";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_REALNAME = "realname";
    private static final String COLUMN_TEAM = "team";
    private static final String COLUMN_FIRSTAPPEARANCE = "firstappearance";
    private static final String COLUMN_CREATEDBY = "createdby";
    private static final String COLUMN_PUBLISHER = "publisher";
    private static final String COLUMN_IMAGEURL = "imageurl";
    private static final String COLUMN_BIO = "bio";

    public MovieDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_REALNAME + " TEXT, "
                + COLUMN_TEAM + " TEXT, "
                + COLUMN_FIRSTAPPEARANCE + " TEXT, "
                + COLUMN_CREATEDBY + " TEXT, "
                + COLUMN_PUBLISHER + " TEXT, "
                + COLUMN_IMAGEURL + " TEXT, "
                + COLUMN_BIO + " TEXT"
                + ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public void insertMovies(List<MovieModel> movieList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (MovieModel movie : movieList) {
            values.put(COLUMN_NAME, movie.getName());
            values.put(COLUMN_TEAM, movie.getTeam());
            values.put(COLUMN_PUBLISHER, movie.getPublisher());
            values.put(COLUMN_IMAGEURL, movie.getImageUrl());
        }
    }

    @SuppressLint("Range")
    public List<MovieModel> getAllMovies() {
        List<MovieModel> movieList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAllQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MovieModel movie = new MovieModel();
                movie.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                movie.setTeam(cursor.getString(cursor.getColumnIndex(COLUMN_TEAM)));
                movie.setPublisher(cursor.getString(cursor.getColumnIndex(COLUMN_PUBLISHER)));
                movie.setImageUrl(cursor.getString(cursor.getColumnIndex(COLUMN_IMAGEURL)));

                movieList.add(movie);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return movieList;
    }
}


