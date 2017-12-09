package com.itla.mudat.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.User;
import com.itla.mudat.helpers.IApp;
import com.itla.mudat.views.users.ListUser;
import com.itla.mudat.views.users.RegisterUser;

import java.util.List;

/**
 * Created by maste on 12/2/2017.
 */

public class ListUserAdapter extends BaseAdapter {

    private List<User> users;
    private Activity context;

    public ListUserAdapter(List<User> users, Activity context){
        this.users = users;
        this.context = context;

    }

    public void setUsers(List<User> users){
        this.users = users;
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.list_item_user_row, null,true);
        }

        final User user = users.get(i);

        TextView email = (TextView) view.findViewById(R.id.item_user_email);
        TextView name = (TextView) view.findViewById(R.id.item_user_name);
        ImageButton login = (ImageButton) view.findViewById(R.id.btn_login_user);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IApp.setUserLogged(user);
            }
        });
        email.setText(user.getEmail());
        name.setText(user.getName());
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
