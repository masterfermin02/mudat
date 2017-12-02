package com.itla.mudat.views.users;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.R;
import com.itla.mudat.adapter.ListUserAdapter;
import com.itla.mudat.dao.ConexionSQLiteHelper;
import com.itla.mudat.entity.User;
import com.itla.mudat.helpers.DbHelpers;
import com.itla.mudat.repository.user.AllUserSpecification;
import com.itla.mudat.repository.user.UserSqlRepository;

import java.util.List;

public class ListUser extends AppCompatActivity {

    private UserSqlRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ListView listView = (ListView) findViewById(R.id.listViewUsers);

        repository = new UserSqlRepository(DbHelpers.getDbConnection(this));

        List<User> listUsers = repository.query(new AllUserSpecification());

        listView.setAdapter(new ListUserAdapter(listUsers, this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent rUser = new Intent(ListUser.this, RegisterUser.class);
                User u = (User) adapterView.getItemAtPosition(i);

                rUser.putExtra("user", u);
                startActivity(rUser);

            }
        });

    }
}
