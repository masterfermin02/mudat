package com.itla.mudat.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.User;

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

        User user = users.get(i);

        TextView email = (TextView) view.findViewById(R.id.item_user_email);
        TextView name = (TextView) view.findViewById(R.id.item_user_name);
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
