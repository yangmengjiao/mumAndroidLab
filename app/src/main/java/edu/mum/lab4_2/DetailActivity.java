package edu.mum.lab4_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Locale;

import edu.mum.R;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");
        ImageView icon = findViewById(R.id.im_icon);
        TextView title = findViewById(R.id.tv_title);
        TextView color = findViewById(R.id.tv_color);
        TextView id = findViewById(R.id.tv_id);
        TextView dec = findViewById(R.id.tv_description);

        icon.setImageResource(R.drawable.walmart);
        title.setText(product.getTitle());
        color.setText(String.format(Locale.getDefault(), "Color : %s", product.getColor()));
        id.setText("Walmart : " + product.getItemId());
        dec.setText(product.getDec());
    }
}
