package com.example.asadrao.expandablelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvsubjects;
    String [] subjects = {"Advance Object Oriented Programming","Automata Theory","Operating System"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvsubjects = (ListView)findViewById(R.id.lvSubjects);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subjects);
        lvsubjects.setAdapter(adapter);
        lvsubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Toast.makeText(MainActivity.this, "Position 1", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
                }
                else if (position == 1)
                {
                    Toast.makeText(MainActivity.this, "Position 2", Toast.LENGTH_SHORT).show();
                }
                else if (position == 2)
                {
                    Toast.makeText(MainActivity.this, "Position 3", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
