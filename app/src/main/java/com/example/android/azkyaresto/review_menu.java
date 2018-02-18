package com.example.android.azkyaresto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class review_menu extends AppCompatActivity {

    private TextView mkn;
    private TextView hrg;
    private ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_menu);
        Intent intent = getIntent();
        String food = intent.getStringExtra("food");
        Integer price = intent.getIntExtra("price",0);
        Integer photo = intent.getIntExtra("photo",0);

        Log.d("getIntExtra", ""+price+photo);

        mkn = (TextView)findViewById(R.id.food_title);
        hrg = (TextView)findViewById(R.id.food_price);
        pic = (ImageView)findViewById(R.id.food_pic);

        mkn.setText(food);
        hrg.setText("Rp. "+price);
        pic.setImageResource(photo);
    }
}
