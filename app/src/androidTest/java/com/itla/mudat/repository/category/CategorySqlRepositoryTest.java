package com.itla.mudat.repository.category;

import android.support.test.runner.AndroidJUnit4;

import com.itla.mudat.dao.ConexionSQLiteHelper;
import com.itla.mudat.entity.Category;
import com.itla.mudat.repository.SqlRepositoryHelpTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by maste on 11/25/2017.
 */

@RunWith(AndroidJUnit4.class)
public class CategorySqlRepositoryTest   {

    private ConexionSQLiteHelper con;
    private CategorySqlRepository repository;

    @Before
    public void setUp() throws Exception {
        con = SqlRepositoryHelpTest.getConexionSQLiteHelper();
        repository = new CategorySqlRepository(con);
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void it_should_add_category()
    {
        Category category = createCategory();
        repository.add(category);
        assertEquals(repository.get(new CategoryByNameSpecification("category1")).getName(), category.getName());
    }

    @Test
    public void it_should_be_empty_list()
    {
        List<Category> list = repository.query(new CategoryByNameSpecification(""));
        assertTrue(list.isEmpty());
    }

    @Test
    public void it_should_update_category()
    {
        repository.add(createCategory());
        Category category = repository.get(new CategoryByNameSpecification("category1"));
        String name = "Mario-updated";
        category.setName(name);
        repository.update(category);

        assertEquals(repository.get(new CategoryByNameSpecification(name)).getName(), name);
    }

    @Test
    public void it_should_remove_category()
    {
        CategoryByNameSpecification userByNameSpecification = new CategoryByNameSpecification("Mario-updated");
        Category category = repository.get(userByNameSpecification);
        repository.remove(category);
        assertTrue(repository.query(new CategoryByIdSpecification(category.getId())).isEmpty());
    }

    @Test
    public void it_should_remove_category_by_specification()
    {
        repository.remove(new DeleteCategoryByNameSpecification("Mario2"));
        assertTrue(repository.query(new CategoryByNameSpecification("Mario2")).isEmpty());
    }
    private Category createCategory()
    {
        String name = "category1";
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
