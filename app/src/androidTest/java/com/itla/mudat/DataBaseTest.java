package com.itla.mudat;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

/**
 * Created by maste on 11/18/2017.
 */

public class DataBaseTest extends AndroidTestCase {

    private DBHelper db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        db = new DBHelper(context);
    }

    @Override
    public void tearDown() throws Exception {
        db.close();
        super.tearDown();
    }

    //According to Zainodis annotation only for legacy and not valid with gradle>1.1:
    //@Test
    public void testAddEntry(){
        // Here i have my new database wich is not connected to the standard database of the App
    }

}
