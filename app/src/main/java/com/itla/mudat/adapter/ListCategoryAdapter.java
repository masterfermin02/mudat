package com.itla.mudat.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Category;
import com.itla.mudat.entity.User;

import java.util.List;

/**
 * Created by maste on 12/4/2017.
 */

public class ListCategoryAdapter extends BaseAdapter {

    private List<Category> categories;
    private Activity context;

    public ListCategoryAdapter(List<Category> categories, Activity context){
        this.categories = categories;
        this.context = context;

    }
    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.list_item_category_row, null,true);
        }

        Category category = categories.get(i);

        TextView name = (TextView) view.findViewById(R.id.item_category_name);
        name.setText(category.getName());
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
