package com.example.attend.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attend.R;
import com.example.attend.model.teacher_model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class teacher_adapter extends FirebaseRecyclerAdapter<teacher_model,teacher_adapter.onviewholder> {

    public teacher_adapter(@NonNull FirebaseRecyclerOptions<teacher_model> options) {
        super(options);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull onviewholder holder, int position, @NonNull teacher_model model) {

        holder.name.setText("Name: "+model.getTeacher_name());
        holder.department.setText("Department : "+model.getDepartment());
        holder.year.setText("Year : "+model.getYear());
        holder.Phone.setText("Phone No : "+model.getPhone());


    }

    @NonNull
    @Override
    public onviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teracher_layout,parent,false);
        return new onviewholder(view);
    }



    public class onviewholder extends RecyclerView.ViewHolder {

        TextView name , department , year  , Phone ;

        public onviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teach_name);
            department = itemView.findViewById(R.id.teach_department);
            year = itemView.findViewById(R.id.teach_year);
            Phone = itemView.findViewById(R.id.teach_phone);
        }
    }
}
