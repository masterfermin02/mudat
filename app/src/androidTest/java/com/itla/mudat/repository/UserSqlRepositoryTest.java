package com.itla.mudat.repository;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.itla.mudat.dao.ConexionSQLiteHelper;
import com.itla.mudat.entity.User;
import com.itla.mudat.entity.UserType;
import com.itla.mudat.repository.user.DeleteUserByNameSpecification;
import com.itla.mudat.repository.user.UserByIdSpecification;
import com.itla.mudat.repository.user.UserByNameSpecification;
import com.itla.mudat.repository.user.UserSqlRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by maste on 11/20/2017.
 */
@RunWith(AndroidJUnit4.class)
public class UserSqlRepositoryTest {
    private ConexionSQLiteHelper con;
    private UserSqlRepository repository;


    @Before
    public void setUp() throws Exception {

        con = new ConexionSQLiteHelper(getTargetContext(),"mudat_db_test", null, 1);
        repository = new UserSqlRepository(con);
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void addUser()
    {
        //SQLiteDatabase db = con.getReadableDatabase();
        User user = _createUser();
        repository.add(user);
        List<User> userList = repository.query(new UserByNameSpecification("Mario2"));
        assertEquals(userList.get(0).getName(), user.getName());
    }

    @Test
    public void userNotExist()
    {
        List<User> list = repository.query(new UserByIdSpecification(-1));
        assertTrue(list.isEmpty());
    }

    @Test
    public void updateUser()
    {
        repository.add(_createUser());
        List<User> userList = repository.query(new UserByNameSpecification("Mario2"));
        User user = userList.get(0);
        String name = "Mario-updated";
        user.setName(name);
        repository.update(user);
        userList = repository.query(new UserByNameSpecification(name));

        assertEquals(userList.get(0).getName(), name);
    }

    @Test
    public void removeUser()
    {
        UserByNameSpecification userByNameSpecification = new UserByNameSpecification("Mario-updated");
        List<User> userList = repository.query(userByNameSpecification);
        User user = userList.get(0);
        repository.remove(user);
        userList = repository.query(new UserByIdSpecification(user.getId()));
        assertTrue(userList.isEmpty());
    }

    @Test
    public void removeUserSpecification()
    {
        repository.remove(new DeleteUserByNameSpecification("Mario2"));
        List<User> userList = repository.query(new UserByNameSpecification("Mario2"));
        assertTrue(userList.isEmpty());
    }

    private User _createUser()
    {
        String name = "Mario2";
        UserType userType = UserType.CLIENTE;
        String identity = "123456";
        String email = "test@email.com";
        String phone = "8095556565";
        String pass = "123456";
        Boolean status = Boolean.TRUE;

        User user = new User();
        user.setName(name);
        user.setUserType(userType);
        user.setIdentity(identity);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPass(pass);
        user.setStatus(status);
        return user;
    }
}
