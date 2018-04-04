package edu.mum.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private EditText et1;
    private EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button1);
        btn1.setOnClickListener(this);

        et1 = findViewById(R.id.input);
        et2 = findViewById(R.id.output);
    }



    @Override
    public void onClick(View v) {
        String et1Text = et1.getText().toString();
        if(!TextUtils.isEmpty(et1Text)){
           // String et1Text = et1.getText().toString();
            double lbs = Double.parseDouble(et1Text);

            double kgs = 0.4532*lbs;
            et2.setText(kgs+"");
        }else{
            return;
        }

    }
}
