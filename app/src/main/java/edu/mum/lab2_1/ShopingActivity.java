package edu.mum.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.mum.R;

public class ShopingActivity extends AppCompatActivity {

    private TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        welcome = findViewById(R.id.welcome);
        welcome.setText("welcome" + email);

    }

    public void onclickItem(View v) {
        int id = v.getId();
        switch (id){
            case R.id.beauty:
                Toast.makeText(this,
                        "Beauty category",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.clothing:
                Toast.makeText(this,
                        "Clothing category",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.electronics:
                Toast.makeText(this,
                        " Electronics category ",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.food:
                Toast.makeText(this,
                        " Food category ",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
