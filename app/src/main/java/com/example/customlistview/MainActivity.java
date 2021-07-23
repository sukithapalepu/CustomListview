package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);

        String[] data = {"Facebook", "Instagram", "Whatsapp", "Youtube", "Twitter", "Linkedin"};
        Integer[] imgid = {R.drawable.download, R.drawable.insta, R.drawable.wtsapp, R.drawable.youtube, R.drawable.twitter, R.drawable.linkedin};
        Customadapter customadapter = new Customadapter(this, data, imgid);
        lv.setAdapter(customadapter);
    }

    public class Customadapter extends BaseAdapter {
        private final Context context;
        private final String[] data;
        private final Integer[] imgid;


        public Customadapter(Context context, String[] data, Integer[] imgid) {
            this.context = context;
            this.data = data;
            this.imgid = imgid;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int i, View convertview, ViewGroup viewGroup){

            if(convertview == null) {
                convertview = LayoutInflater.from(context).inflate(R.layout.customlist, viewGroup,false);
            }

            ImageView img = (ImageView) convertview.findViewById(R.id.img);
            TextView name = (TextView) convertview.findViewById(R.id.name);

            img.setImageResource(imgid[i]);
            name.setText(data[i]);
            return convertview;
        }
    }
}






