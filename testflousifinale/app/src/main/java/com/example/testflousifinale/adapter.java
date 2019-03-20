package com.example.testflousifinale;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class adapter extends ArrayAdapter<depense> {
    private ArrayList<depense> List;
    private Context ctx;
    private int itm;


    public adapter(@NonNull Context context, int resource , ArrayList<depense> List) {
        super(context, resource,List);
        this.List =List;
        this.ctx=context;
        this.itm =resource; }

    @NonNull
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //super.getView(position, convertView, parent);
        convertView= LayoutInflater.from(ctx).inflate(itm,parent,false);

        TextView  prix=convertView.findViewById(R.id.idprix);

        TextView  achat=convertView.findViewById(R.id.iddepence);

        TextView date=convertView.findViewById(R.id.idate);

        prix.setText(Float.toString(List.get(position).getPrix()));
        achat.setText(List.get(position).getAchat());
        date.setText(List.get(position).getDate());

        return convertView; }

        }
