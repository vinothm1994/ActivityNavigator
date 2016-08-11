package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SuperHeroListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_hero_list_view);
    }
    @Override
    protected void onStart(){
        super.onStart();

        String[] name={"batman" ,"superman","captainamerica","ironman","hulk"};
        ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        ListView listView=(ListView)findViewById(R.id.lvSuperHero);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = ((TextView)view).getText().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                Intent intent=new Intent(getBaseContext(),ListViewResultSuperHero.class);
                intent.putExtra("HeroName",item);
                startActivity(intent);
            }
        });



    }

}
