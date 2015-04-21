package com.example.tommy.sqldemo.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.tommy.sqldemo.Data.KickWax;
import com.example.tommy.sqldemo.Data.MyDBHandler;
import com.example.tommy.sqldemo.R;

public class NewEditKickWax extends ActionBarActivity {

    private MyDBHandler db;
    private EditText editTextName, editTextProducer, editTextType, editTextComment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_edit_kick_wax);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextProducer = (EditText)findViewById(R.id.editProducer);
        editTextType = (EditText)findViewById(R.id.editType);
        editTextComment = (EditText)findViewById(R.id.editComment);


        db = new MyDBHandler(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_edit_kick_wax, menu);
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

    public void buttonSaveClick(View view) {
        KickWax kickWax = new KickWax(editTextProducer.getText().toString(),editTextName.getText().toString(), editTextType.getText().toString(),editTextComment.getText().toString());
        db.AddWax(kickWax);
        setResult(1);
        finish();
    }
}
