package com.itla.mudat.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Adsense;

import java.util.List;

/**
 * Created by maste on 12/9/2017.
 */

public class ListAdsenseAdapter extends BaseAdapter {

    private List<Adsense> adsenses;
    private Activity context;

    public ListAdsenseAdapter(List<Adsense> adsenses, Activity context)
    {
        this.adsenses = adsenses;
        this.context = context;

    }

    public void setAdsenses(List<Adsense> adsenses)
    {
        this.adsenses = adsenses;
    }

    @Override
    public int getCount() {
        return adsenses.size();
    }

    @Override
    public Object getItem(int i) {
        return adsenses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.list_item_adsense_row, null,true);
        }

        Adsense adsense = adsenses.get(i);

        TextView title = (TextView) view.findViewById(R.id.item_adsense_title);
        TextView categoryName = (TextView) view.findViewById(R.id.item_adsense_category_name);
        TextView userName = (TextView) view.findViewById(R.id.item_adsense_user_name);
        title.setText(adsense.getTitle());
        categoryName.setText(adsense.getCategory().getName().toString());
        userName.setText(adsense.getUser().getName());
        return view;
    }
}
