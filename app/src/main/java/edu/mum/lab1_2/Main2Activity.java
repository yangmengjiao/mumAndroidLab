package edu.mum.lab1_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import edu.mum.R;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private EditText et1;
    ArrayList<String> array = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1=findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2=findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        et1 = findViewById(R.id.input);

        array.add("Hamburger");
        array.add("Pizza");
        array.add("Mexican");
        array.add("American");
        array.add("Chinese");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button1:
                String text = et1.getText().toString();
                if(!text.isEmpty()&&!array.contains(text)){
                    array.add(text);
                }

                break;
            case  R.id.button2:
                int index = (int)(Math.random()*(array.size()));
                String food = array.get(index);
                et1.setText(food);
                break;
            default:
                break;

        }
    }


}
