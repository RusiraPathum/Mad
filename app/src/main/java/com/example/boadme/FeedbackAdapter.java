package com.example.boadme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedbackAdapter extends ArrayAdapter<Feedback> {
    private Context context;
    private int resource;
    List<Feedback>feedbacks;

    FeedbackAdapter(Context context, int resource, List<Feedback> feedbacks){
        super(context, resource, feedbacks);
        this.context = context;
        this.resource = resource;
        this.feedbacks = feedbacks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView view_name = row.findViewById(R.id.view_name);
        TextView view_email= row.findViewById(R.id.view_email);
        TextView view_comment= row.findViewById(R.id.view_comment);

        ImageView imageView = row.findViewById(R.id.checkBox);

        Feedback feedback = feedbacks.get(position);
        view_name.setText(feedback.getCustomer_name ());
        view_email.setText(feedback.getCustomer_email ());
        view_comment.setText(feedback.getCustomer_comment ());
        imageView.setVisibility(row.INVISIBLE);

        if(feedback.getFinished() > 0){
            imageView.setVisibility(View.VISIBLE);
        }

        return row;

    }
}


