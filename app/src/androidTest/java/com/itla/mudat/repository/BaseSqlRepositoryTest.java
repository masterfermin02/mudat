package com.itla.mudat.repository;

import com.itla.mudat.dao.ConexionSQLiteHelper;

import static android.support.test.InstrumentationRegistry.getTargetContext;

/**
 * Created by maste on 11/25/2017.
 */

public abstract class BaseSqlRepositoryTest {
    private final ConexionSQLiteHelper con;

    public  BaseSqlRepositoryTest(){
        con = new ConexionSQLiteHelper(getTargetContext(),"mudat_db_test", null, 2);
    }

    public final ConexionSQLiteHelper getConexionSQLiteHelper()
    {
        return this.con;
    }
}
