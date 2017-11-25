package com.itla.mudat.dao;

import android.database.Cursor;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.repository.SqlRepositoryHelpTest;

/**
 * Created by maste on 11/20/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ConexionSQLiteHelperTest {

    private ConexionSQLiteHelper con;

    @Before
    public void setUp() throws Exception {
        con = SqlRepositoryHelpTest.getConexionSQLiteHelper();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void shouldTablesExist()
    {
        SQLiteDatabase db = con.getReadableDatabase();
        for(String table : DbHelpers.APP_TABLES_NAMES)
        {
            assertTrue(tableExists(db,table));
        }
    }

    boolean tableExists(SQLiteDatabase db, String tableName)
    {

        if (tableName == null || db == null || !db.isOpen())
        {
            return false;
        }
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[] {"table", tableName});
        if (!cursor.moveToFirst())
        {
            cursor.close();
            return false;
        }
        int count = cursor.getInt(0);
        cursor.close();
        return count > 0;
    }
}
