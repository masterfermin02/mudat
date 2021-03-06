package com.itla.mudat.repository.adsense;

import android.support.test.runner.AndroidJUnit4;

import com.itla.mudat.dao.ConexionSQLiteHelper;
import com.itla.mudat.entity.Adsense;
import com.itla.mudat.entity.Category;
import com.itla.mudat.entity.User;
import com.itla.mudat.repository.SqlRepositoryHelpTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by maste on 11/25/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AdsenseSqlRepositoryTest {

    private ConexionSQLiteHelper con;
    private AdsenseSqlRepository repository;

    @Before
    public void setup() throws Exception {
        con = SqlRepositoryHelpTest.getConexionSQLiteHelper();
        repository = new AdsenseSqlRepository(con);
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void it_should_add_adsense()
    {
        Adsense adsense = createAdsense();
        repository.add(adsense);
        assertTrue(!repository.query(new AdsenseByTitleSpecification("Title1")).isEmpty());
    }

    @Test
    public void it_should_be_empty_list()
    {
        List<Adsense> adsenses = repository.query(new AdsenseByIdSpecification(-1));
        assertTrue(adsenses.isEmpty());
    }

    @Test
    public void it_should_update_category()
    {
        repository.add(createAdsense());
        Adsense adsense = repository.get(new AdsenseByTitleSpecification("Title1"));
        String title = "Title-updated";
        adsense.setTitle(title);
        repository.update(adsense);

        assertEquals(repository.get(new AdsenseByTitleSpecification(title)).getTitle(), title);
    }

    @Test
    public void it_should_remove_category()
    {
        AdsenseByTitleSpecification adsenseByTitleSpecification = new AdsenseByTitleSpecification("Title-updated");
        Adsense adsense = repository.get(adsenseByTitleSpecification);
        repository.remove(adsense);
        assertTrue(repository.query(new AdsenseByIdSpecification(adsense.getId())).isEmpty());
    }

    @Test
    public void it_should_remove_category_by_specification()
    {
        repository.remove(new DeleteAdsenseByTitleSpecification("Title1"));
        assertTrue(repository.query(new AdsenseByTitleSpecification("Title1")).isEmpty());
    }

    public Adsense createAdsense()
    {
        Adsense adsense = new Adsense();
        Category category = new Category();
        category.setName("Category1");
        User user = new User();
        user.setName("Juan");
        Date createdAt = new Date();
        String condiction = "this is the condiction";
        double price = 10.5;
        String title = "Title1";
        String location = "location";
        String details = "details";
        adsense.setCategory(category);
        adsense.setUser(user);
        adsense.setCreatedAt(createdAt);
        adsense.setCondiction(condiction);
        adsense.setPrice(price);
        adsense.setTitle(title);
        adsense.setLocation(location);
        adsense.setDetails(details);
        return adsense;
    }
}
