package edu.mum.lesson7.qustion2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import edu.mum.R;


public class Main2_1_Activity extends AppCompatActivity  implements  View.OnClickListener{
    ArrayList<User> array = new ArrayList<User>();
    private Button btn1;
    private TextView createNew;
    private EditText email;
    private EditText pwd;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_1);
        User user1 = new User("mengjiao","yang","12","12");
        User user2 = new User("gabriel","zhoou","123@qq.com","123");
        User user3 = new User("jiaojiao","yang","123@qq.com","123");
        User user4 = new User("bingbing","xie","123@qq.com","123");
        User user5 = new User("gugu","tang","123@qq.com","123");
        array.add(user1);
        array.add(user2);
        array.add(user3);
        array.add(user4);
        array.add(user5);
        btn1 = findViewById(R.id.signIn);
        btn1.setOnClickListener(this);

        createNew = findViewById(R.id.create);
        createNew.setOnClickListener(this);

        email = findViewById(R.id.email);
        pwd = findViewById(R.id.pwd);

        pref = getSharedPreferences("login",MODE_PRIVATE);;
        if(pref.contains("emailStr") && pref.contains("pwdStr")){
                email.setText(pref.getString("emailStr","error"));
                pwd.setText(pref.getString("pwdStr","error"));
            Log.d("debug","here");

        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.signIn:
                String emailStr = email.getText().toString();
                String pwdStr = pwd.getText().toString();

                if(loginCheck()){

                    SharedPreferences.Editor editor =  pref.edit();
                    editor.putString("emailStr",emailStr);
                    editor.putString("pwdStr",pwdStr);
                    editor.commit();

                    Intent intent = new Intent(this,ShopingActivity.class);
                    intent.putExtra("email",""+emailStr);
                    startActivity(intent);

                    System.out.print("correct password");
                    finish();
                }else {
                    System.out.print("incorrect password");
                }


                break;
            case  R.id.create:

                Intent intent = new Intent(this,CreateAccountActivity.class);
                startActivityForResult(intent, 1);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                Bundle userBundel = data.getExtras();
                String firstName = userBundel.getString("firstName");
                String lastName = userBundel.getString("lastName");
                String email = userBundel.getString("email");
                String password = userBundel.getString("password");
                User user = new User(firstName,lastName,email,password);

                array.add(user);
            } }
    }

    private boolean loginCheck(){
        String emailStr = email.getText().toString();
        String pwdStr = pwd.getText().toString();
        for(int i=0;i<array.size();i++){
            if (array.get(i).getEmail().equals(emailStr) && array.get(i).getPassword().equals(pwdStr)){
                return  true;
            }
        }
        return false;
    }
}

