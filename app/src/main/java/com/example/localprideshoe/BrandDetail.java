package com.example.localprideshoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BrandDetail extends AppCompatActivity {

    public static final String EXTRA_SHOES = "extra_shoes";

    TextView Name, Detail;
    ImageView BrandImage, ShoesImage;
    private String title;

    private void setActionBarTitle (String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_detail);

        Name = findViewById(R.id.shoes_name);
        Detail = findViewById(R.id.detail);
        BrandImage = findViewById(R.id.img_brand);
        ShoesImage = findViewById(R.id.img_produk);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Shoes shoes = extras.getParcelable(EXTRA_SHOES);
            title = "DETAIL " + shoes.getName();
            setActionBarTitle(title);

            Name.setText(shoes.getName());
            Detail.setText(shoes.getDetail());
            Glide.with(this)
                    .load(shoes.getPhoto())
                    .apply(new RequestOptions())
                    .into(BrandImage);

            Glide.with(this)
                    .load(shoes.getShoesPhoto())
                    .apply(new RequestOptions().override(380,200))
                    .into(ShoesImage);

        }
    }
}
