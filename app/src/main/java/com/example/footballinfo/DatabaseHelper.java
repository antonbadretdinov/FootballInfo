package com.example.footballinfo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper {

        private static final String DATABASE_NAME = "simple.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME = "tableMatches";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_TEAMHOME = "TeamНоme";
        private static final String COLUMN_TEAMGUEST = "TeamGuest";
        private static final String COLUMN_GOALSHOME = "GoalsHome";
        private static final String COLUMN_GOALSGUEST = "GoalsGuast";

        private static final int NUM_COLUMN_ID = 0;
        private static final int NUM_COLUMN_TEAMHOME = 1;
        private static final int NUM_COLUMN_TEAMGUEST = 2;
        private static final int NUM_COLUMN_GOALSHOME = 3;
        private static final int NUM_COLUMN_GOALSGUEST = 4;

        private SQLiteDatabase mDataBase;

        public DatabaseHelper(Context context){
            OpenHelper openHelper = new OpenHelper(context);
            mDataBase = openHelper.getWritableDatabase();
        }

        public void insert(MatchInfo info){
            String query = "INSERT INTO"+ TABLE_NAME+
                    "("+","+COLUMN_TEAMHOME+","+COLUMN_TEAMGUEST+","+COLUMN_GOALSHOME+","+COLUMN_GOALSGUEST+")" +
                    "VALUES(\""+ "\""+info.getTeamhouse()+
                    "\",\""+info.getTeamguest()+
                    ","+info.getGoalshouse()+
                    ","+info.getGoalsguest()+")";
            mDataBase.execSQL(query);
        }

    public ArrayList<MatchInfo> selectAll() {
        Cursor mCursor = mDataBase.query(TABLE_NAME, null, null, null, null, null, null);

        ArrayList<MatchInfo> arr = new ArrayList<MatchInfo>();
        mCursor.moveToFirst();
        if (!mCursor.isAfterLast()) {
            do {
                int id = mCursor.getInt(NUM_COLUMN_ID);
                String TeamHome = mCursor.getString(NUM_COLUMN_TEAMHOME);
                String TeamGuest = mCursor.getString(NUM_COLUMN_TEAMGUEST);
                int GoalsHome = mCursor.getInt(NUM_COLUMN_GOALSHOME);
                int GoalsGuest=mCursor.getInt(NUM_COLUMN_GOALSGUEST);
                arr.add(new MatchInfo(id, TeamHome, TeamGuest, GoalsHome,GoalsGuest));
            } while (mCursor.moveToNext());
        }
        return arr;
    }

        private class OpenHelper extends SQLiteOpenHelper {

            OpenHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }
            @Override
            public void onCreate(SQLiteDatabase db) {
                String query = "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TEAMHOME+ " TEXT, " +
                        COLUMN_TEAMGUEST + " TEXT, " +
                        COLUMN_GOALSHOME + " INT,"+
                        COLUMN_GOALSGUEST +" INT);";
                db.execSQL(query);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                onCreate(db);
            }
        }
}
