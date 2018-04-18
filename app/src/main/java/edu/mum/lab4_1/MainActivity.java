package edu.mum.lab4_1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import edu.mum.R;


public class MainActivity extends Activity {

    private AutoCompleteTextView actv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        actv = findViewById(R.id.actv_movie);
        final String[] moives = {"Spider Man", "Hunted House", "Beauty and Beast", "Future", "Alice","Little Price"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moives);
        actv.setAdapter(arrayAdapter);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, moives[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
