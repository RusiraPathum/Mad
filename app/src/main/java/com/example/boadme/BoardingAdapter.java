package com.example.boadme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BoardingAdapter extends ArrayAdapter<Boarding> {
    private Context context;
    private int resource;
    List<Boarding> boardings;

    //ListAdapter listAdapter = new ArrayAdapter<Boarding>(this,R.layout.single_boarding);


    public BoardingAdapter(Context context, int resource, List<Boarding>boardings) {
        super(context, resource, boardings);
        this.context = context;
        this.resource = resource;
        this.boardings = boardings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);


        TextView location = row.findViewById(R.id.location);
        TextView details = row.findViewById(R.id.details2);
        TextView price = row.findViewById(R.id.price);



        Boarding boarding = boardings.get(position);
        location.setText(boarding.getLocation());
        price.setText(boarding.getPrice());
        details.setText(boarding.getDetails2());


        return row;
    }
}
