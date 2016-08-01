package com.example.wonkydan.inventoryapp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImage;
    private TextView detailTitle;
    private TextView detailSize;
    private TextView detailPrice;
    private TextView detailQuantity;
    private Button minus;
    private TextView quantitySelected;
    private Button plus;
    private Button sell;
    private Button receive;
    private Button deleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

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
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);

            startActivity(intent);
            return true;
        } else if (id == R.id.new_item){
            Intent intent = new Intent(DetailActivity.this, AddActivity.class);

            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
