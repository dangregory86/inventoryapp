package com.example.wonkydan.inventoryapp3;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText name;
    private EditText size;
    private EditText price;
    private EditText quantity;
    private InventoryDatabase inventoryDatabase;

    public InventoryDatabase getInventoryDatabase() {
        return inventoryDatabase;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = (EditText) findViewById(R.id.item_name);
        size = (EditText) findViewById(R.id.item_size);
        price = (EditText) findViewById(R.id.item_price);
        quantity = (EditText) findViewById(R.id.item_quantity);
        Button photoAdd = (Button) findViewById(R.id.photo_add_button);


        //adding info to database
        photoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the values and send to SQL database
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseContract.Table1.NAME, name.getText().toString());
                contentValues.put(DatabaseContract.Table1.SIZE, size.getText().toString());
                contentValues.put(DatabaseContract.Table1.PRICE, price.getText().toString());
                contentValues.put(DatabaseContract.Table1.QUANTITY, quantity.getText().toString());

                //inserting the values
                ContentResolver contentResolver = getApplication().getContentResolver();
                contentResolver.insert(InventoryContentProvider.INVENTORY_URI, contentValues);


                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


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
            Intent intent = new Intent(AddActivity.this, MainActivity.class);

            startActivity(intent);
            return true;
        } else if (id == R.id.new_item){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
