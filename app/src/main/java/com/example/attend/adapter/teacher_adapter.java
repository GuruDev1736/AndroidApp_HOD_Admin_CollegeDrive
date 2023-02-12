package com.example.attend.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attend.R;
import com.example.attend.model.teacher_model;
import com.example.attend.teacher_profile;
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

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(view.getContext(), teacher_profile.class);
               intent.putExtra("name",model.getTeacher_name());
               intent.putExtra("department",model.getDepartment());
               intent.putExtra("year",model.getYear());
               intent.putExtra("phone",model.getPhone());
               intent.putExtra("email",model.getEmail());
               intent.putExtra("password",model.getPassword());
               view.getContext().startActivity(intent);



            }
        });




    }

    @NonNull
    @Override
    public onviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teracher_layout,parent,false);
        return new onviewholder(view);
    }


    public class onviewholder extends RecyclerView.ViewHolder {

        TextView name , department , year  , Phone ;
        CardView cardView ;

        public onviewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teach_name);
            department = itemView.findViewById(R.id.teach_department);
            year = itemView.findViewById(R.id.teach_year);
            Phone = itemView.findViewById(R.id.teach_phone);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
