package com.example.mysqlandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    int position;
    private Context context;
    private ArrayList pr_id,pr_name,pr_description,pr_category;
        CustomAdapter(Context context, ArrayList pr_id, ArrayList pr_name, ArrayList pr_description, ArrayList pr_category) {
            this.context = context;
            this.pr_id =  pr_id;
            this.pr_name = pr_name;
            this.pr_description = pr_description;
            this.pr_category = pr_category;
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
            //this.position = position;

            holder.pr_id_txt.setText(String.valueOf(pr_id.get(position)));
            holder.pr_name_txt.setText(String.valueOf(pr_name.get(position)));
            holder.pr_description_txt.setText(String.valueOf(pr_description.get(position)));
            holder.pr_category_txt.setText(String.valueOf(pr_category.get(position)));

            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,UpdateActivity.class);
                    intent.putExtra("prd_id",String.valueOf(pr_id.get(position)));
                    intent.putExtra("prd_name",String.valueOf(pr_name.get(position)));
                    intent.putExtra("prd_description",String.valueOf(pr_description.get(position)));
                    intent.putExtra("prd_category",String.valueOf(pr_category.get(position)));

                    context.startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return pr_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView pr_id_txt, pr_name_txt,pr_description_txt,pr_category_txt;
            LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pr_id_txt = itemView.findViewById(R.id.pr_id_txt);
            pr_name_txt = itemView.findViewById(R.id.pr_name_txt);
            pr_description_txt = itemView.findViewById(R.id.pr_description_txt);
            pr_category_txt = itemView.findViewById(R.id.pr_category_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
