package com.myapplicationdev.android.demodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvId, tvDesc, tvDate;

    public TaskAdapter(Context context, int resource,
                       ArrayList<Task> objects) {
        super(context, resource, objects);

        task = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvId = rowView.findViewById(R.id.tvId);
        tvDesc = rowView.findViewById(R.id.tvDesc);
        tvDate = rowView.findViewById(R.id.tvDate);

        Task currTask = task.get(position);

        tvId.setText("" + currTask.getId());
        tvDesc.setText(currTask.getDescription());
        tvDate.setText(currTask.getDate());

        return rowView;
    }
}
