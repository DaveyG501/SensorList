package io.daveyg.dev.sensorlist;

import android.content.Context;
import android.hardware.Sensor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Sensor> sensorList;
    private Context context;

    public MyAdapter(List<Sensor> sensorList, Context context) {
        this.sensorList = sensorList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Sensor sensor = sensorList.get(i);
        viewHolder.getTextViewHead().setText(sensor.getName());
        viewHolder.getTextViewDescription().setText(sensor.getStringType());
        viewHolder.getLinearLayout().setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(context, String.format("You Clicked %s!", sensor.getName()), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayout;
        private TextView textViewHead;
        private TextView textViewDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = itemView.findViewById(R.id.textViewHead);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }

        public TextView getTextViewHead() {
            return textViewHead;
        }

        public TextView getTextViewDescription() {
            return textViewDescription;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }
}
