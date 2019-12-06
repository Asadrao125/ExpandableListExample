package com.example.asadrao.expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> langs;
    Map<String,List<String>> topics;
    ExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        fillData();
        listAdapter = new MyExListAdapter(this,langs,topics);
        expandableListView.setAdapter(listAdapter);
    }
    public void fillData()
    {
        langs = new ArrayList<>();
        topics = new HashMap<>();

        langs.add("Java");
        langs.add("Automata Theory");

        List<String> java = new ArrayList<>();
        List<String> at = new ArrayList<>();

        java.add("History");
        java.add("Number Class");
        java.add("Character Class");
        java.add("String Class");
        java.add("Modifiers");
        java.add("Control Structures");

        at.add("Deterministick Finite Automata");
        at.add("Non Deterministick Finite Automata");
        at.add("Moore and Mealy Machine");


        topics.put(langs.get(0),java);
        topics.put(langs.get(1),at);
    }
}
