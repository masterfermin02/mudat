package com.itla.mudat.views.users;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.components.users.UserLoginComponent;
import com.itla.mudat.entity.Adsense;
import com.itla.mudat.entity.User;
import com.itla.mudat.entity.UserType;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.helpers.IApp;
import com.itla.mudat.repository.user.UserByEmailAndPassSpecification;
import com.itla.mudat.repository.user.UserSqlRepository;
import com.itla.mudat.views.ClientMenu;
import com.itla.mudat.views.PublicadorMenu;
import com.itla.mudat.views.adsenses.ListAdsense;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton btnLogin = (ImageButton) findViewById(R.id.btn_login);
        ImageButton btnCancel = (ImageButton) findViewById(R.id.btn_cancel);
        final EditText email = (EditText) findViewById(R.id.login_correo);
        final EditText pass = (EditText) findViewById(R.id.login_pass);
        final UserSqlRepository repository = new UserSqlRepository(DbHelpers.getDbConnection(this));
        final TextView error = (TextView)  findViewById(R.id.lbl_login_error);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = repository.get(new UserByEmailAndPassSpecification(email.getText().toString(),pass.getText().toString()));
                if(u.getId() > 0){
                    Class c;
                    if(u.getUserType() == UserType.PUBLICADOR){
                        c = PublicadorMenu.class;

                    }else{
                        c = ListAdsense.class;
                    }
                    Intent intent = new Intent(getApplicationContext(), c);
                    startActivity(intent);
                }else{
                    error.setVisibility(View.VISIBLE);
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
