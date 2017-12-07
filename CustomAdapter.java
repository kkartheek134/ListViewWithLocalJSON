package com.android.gemini.localjsonexample;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by kkavalireddy on 12/7/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Random rnd = new Random();
    List<MyPlaces> places;
    Context context;

    public CustomAdapter(Context context,List<MyPlaces> places) {
        this.places = places;
        this.context = context;
//        LayoutInflater inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int i) {
        return places.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    /*public class ViewHolder{
        TextView textView,textView1,textView2;

        ViewHolder(TextView textView,TextView textView1,TextView textView2)
        {
            this.textView = textView;
            this.textView1 = textView1;
            this.textView2 = textView2;
        }
    }*/
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = View.inflate(context,R.layout.customlayout,null);
        TextView textView = (TextView)v.findViewById(R.id.place);
        TextView textView1 = (TextView)v.findViewById(R.id.latitude);
        TextView textView2 = (TextView)v.findViewById(R.id.longitude);

        textView.setText(textView.getText().toString()+" :  "+places.get(position).getName());
        textView1.setText(textView1.getText().toString()+" :  "+places.get(position).getLatitude());
        textView2.setText(textView2.getText().toString()+" :  "+places.get(position).getLongitude());
        int color = Color.argb(100, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        v.setBackgroundColor(color);
        return v;
    }
}
