package com.example.tommy.sqldemo.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.tommy.sqldemo.Data.KickWax;
import com.example.tommy.sqldemo.Adapters.KickWaxAdapter;
import com.example.tommy.sqldemo.Data.MyDBHandler;
import com.example.tommy.sqldemo.R;

import java.util.ArrayList;


public class KickWaxActivity extends ActionBarActivity {
    private MyDBHandler db;
    ArrayList<KickWax> arrayOfKickWax = new ArrayList<KickWax>();
    private KickWaxAdapter kwadapter;
    private ListView listView;
    private static final int NEW_RECORD_SAVED = 1;
    //TODO Finn ut hvordan listen kan brukes direkte

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kick_wax);
        kwadapter = new KickWaxAdapter(this, arrayOfKickWax);
        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.list_wax);
        listView.setAdapter(kwadapter);
        db= new MyDBHandler(this);
        CheckAndUpdateData();
        /*arrayOfKickWax = db.getAllWaxes();
        kwadapter = new KickWaxAdapter(this, arrayOfKickWax);
        listView.setAdapter(kwadapter);
*/




        //AddData();
    }



    public void AddData() {


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == NEW_RECORD_SAVED) {
            // Make sure the request was successful
            if (resultCode == 1) {
               CheckAndUpdateData();
            }
        }
    }
    public void buttonWaxDetailsClicked(View v){
        Intent iinent= new Intent(KickWaxActivity.this,NewEditKickWax.class);
        startActivityForResult(iinent,NEW_RECORD_SAVED);


    }
    private void CheckAndUpdateData() {
        arrayOfKickWax = db.getAllWaxes();
        kwadapter = new KickWaxAdapter(this, arrayOfKickWax);
        listView.setAdapter(kwadapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kick_wax, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
