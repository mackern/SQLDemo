package com.example.tommy.sqldemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tommy.sqldemo.Data.KickWax;
import com.example.tommy.sqldemo.R;

import java.util.ArrayList;

/**
 * Created by Tommy on 20/03/2015.
 */
public class KickWaxAdapter extends ArrayAdapter<KickWax> {
    public KickWaxAdapter(Context context, ArrayList<KickWax> kickwaxs) {
        super(context, 0, kickwaxs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        KickWax kickwax = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.waxlist_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.txt_wax_name);
        TextView tvType = (TextView) convertView.findViewById(R.id.txt_wax_type);
        TextView tvProducer = (TextView) convertView.findViewById(R.id.txt_wax_producer);
        // Populate the data into the template view using the data object
        tvName.setText(kickwax.getName());
        tvType.setText(kickwax.getType());
        tvProducer.setText(kickwax.getProducer());

        // Return the completed view to render on screen
        return convertView;
    }
}