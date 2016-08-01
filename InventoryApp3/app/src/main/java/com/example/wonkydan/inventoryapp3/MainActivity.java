package com.example.wonkydan.inventoryapp3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);

                startActivity(intent);
            }
        });

        setListView();
    }

    public void setListView(){
        boolean table = new InventoryContentProvider().onCreate();
        if(table){

        Cursor cursor = new InventoryContentProvider().query(InventoryContentProvider.INVENTORY_URI, new String [] {"ALL_KEYS"}, null, null, null);

        String[] fromDB = new String[] {DatabaseContract.Table1.TABLE_TITLE};
        int[] toView = new int[] {R.id.list_title};

        //set up cursor adapter
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this, R.layout.list_item, cursor, fromDB, toView, 0);

        //find list view
        listView = (ListView) findViewById(R.id.list_item);

        //set the list view to the cursor adapter
        listView.setAdapter(simpleCursorAdapter);}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home_page) {

            return true;
        } else if (id == R.id.new_item){
            Intent intent = new Intent(MainActivity.this, AddActivity.class);

            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
