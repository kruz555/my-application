package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class dataadapter extends RecyclerView.Adapter<dataadapter.myclass> {

    Context context;
    List<Object> data;

    public dataadapter(Context context, List<Object> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.userlist, parent, false);
        return new myclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, final int position) {
        int time;
        Random r = new Random();
        time=r.nextInt(10)+10;
//        holder.textView.setText(category[position]);
        final demodata model = (demodata) data.get(position);
        holder.user.setText(model.getUser());

        final JSONObject amodel=model.getAmodel();

        try {
            holder.Address.setText(amodel.getString("street") + ", "+amodel.getString("suite")+ ", "+amodel.getString("city")+ ", "+amodel.getString("zipcode"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.time.setText(""+time+"s");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,profile.class);
                intent.putExtra("user",model.getUser());
                intent.putExtra("name",model.getName());
                intent.putExtra("email",model.getEmail());
                intent.putExtra("address",  amodel.toString());
                intent.putExtra("mobile",model.getMobile());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myclass extends RecyclerView.ViewHolder {
        TextView user,Address,time;
        public myclass(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user);
            Address = itemView.findViewById(R.id.address);
            time = itemView.findViewById(R.id.time);
        }
    }
}
