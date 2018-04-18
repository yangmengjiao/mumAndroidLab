package edu.mum.lesson7.qustion2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.mum.R;

public class CreateAccountActivity extends AppCompatActivity implements  View.OnClickListener{
    private Button btn1;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        btn1 = findViewById(R.id.createNew);
        btn1.setOnClickListener(this);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pwd);
    }

    @Override
    public void onClick(View v) {
        if (addAccountHelper()){
            Toast.makeText(getApplicationContext(),"Account created successfully ",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Please input all required fileds ",Toast.LENGTH_LONG).show();
        }
    }

    private boolean addAccountHelper(){
        Intent data = new Intent();
        String firstNameStr = firstName.getText().toString();
        String lastNameStr = lastName.getText().toString();
        String emailStr = email.getText().toString();
        String passwordStr = password.getText().toString();

        if(!firstNameStr.isEmpty() && !lastNameStr.isEmpty() && !emailStr.isEmpty() && !passwordStr.isEmpty()){
            data.putExtra("firstName",firstNameStr);
            data.putExtra("lastName",lastNameStr);
            data.putExtra("email",emailStr);
            data.putExtra("password",passwordStr);
            setResult(RESULT_OK,data);
            return  true;
        }else {
            return false;
        }
    }
}
