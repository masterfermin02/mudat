package com.itla.mudat.repository;

import com.itla.mudat.dao.ConexionSQLiteHelper;

import static android.support.test.InstrumentationRegistry.getTargetContext;

/**
 * Created by maste on 11/25/2017.
 */

public class SqlRepositoryHelpTest {

    public SqlRepositoryHelpTest(){

    }

    public static final ConexionSQLiteHelper getConexionSQLiteHelper()
    {
        return new ConexionSQLiteHelper(getTargetContext(),"mudat_db_test", null, 3);
    }
}
