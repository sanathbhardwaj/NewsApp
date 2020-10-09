package com.digital.tpf;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HeadlineDescriptionActivity extends AppCompatActivity {

    ImageButton backarrow;
    String image, description;
    TextView desc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headline_description);

        image = getIntent().getStringExtra("image");
        description = getIntent().getStringExtra("description");

        imageView = findViewById(R.id.banner);
        desc = findViewById(R.id.desc);
//
//        System.out.println(image);
//        System.out.println(description);

        Glide.with(this).load(image).placeholder(R.drawable.placeholder).into(imageView);
        desc.setText(description);

        backarrow = findViewById(R.id.backarrow);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}