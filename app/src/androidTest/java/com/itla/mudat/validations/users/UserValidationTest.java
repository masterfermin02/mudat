package com.itla.mudat.validations.users;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import com.itla.mudat.components.users.UserComponent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static junit.framework.Assert.assertTrue;

/**
 * Created by maste on 12/1/2017.
 */
@RunWith(AndroidJUnit4.class)
public class UserValidationTest  {

    Context context;

    @Before
    public void setUp() throws Exception {
        context = getTargetContext();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void it_should_pass_validation()
    {
        UserComponent userComponent = new UserComponent();
        EditText name = new EditText(this.context);
        name.setText("name");
        EditText phone = new EditText(this.context);
        phone.setText("phone");
        userComponent.setName(name);
        userComponent.setPhone(phone);
        UserValidation userValidation = new UserValidation(userComponent);
        assertTrue(userValidation.validate());
    }

    @Test
    public void it_should_not_pass_validation()
    {
        UserComponent userComponent = new UserComponent();
        EditText name = new EditText(this.context);
        name.setText("");
        EditText phone = new EditText(this.context);
        phone.setText("");
        userComponent.setName(name);
        userComponent.setPhone(phone);
        UserValidation userValidation = new UserValidation(userComponent);
        assertTrue(!userValidation.validate());
    }
}
