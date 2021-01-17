package org.itstep.customlist;

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
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context ctx, List<Student> group) {
        super(ctx, 0, group);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AppCompatActivity context = (AppCompatActivity) getContext();
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rootView = layoutInflater.inflate(R.layout.student_list_item, parent, false);
        ImageView photoImageView = rootView.findViewById(R.id.imageViewPhoto);
        TextView nameView = rootView.findViewById(R.id.textViewName);
        TextView groupView = rootView.findViewById(R.id.textViewGroup);
        Student student = getItem(position);
        photoImageView.setImageResource(student.getPhotoId());
        nameView.setText(student.getName());
        groupView.setText(student.getGroup());
        return rootView;
    }
}
