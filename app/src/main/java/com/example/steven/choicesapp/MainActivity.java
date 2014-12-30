package com.example.steven.choicesapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private final String TAG = "MainActivity";

    private ListView list;
    private final String[] ACTIVITY_CHOICES = {"Open website","Go to contacts","Open dailer","Search google","Start voice command"};
    private final Intent[] ACTIVITY_INTENTS = {new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")),new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI),new Intent(Intent.ACTION_CALL_BUTTON),
    new Intent(Intent.ACTION_WEB_SEARCH),new Intent(Intent.ACTION_VOICE_COMMAND)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.lstView);
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ACTIVITY_CHOICES));
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setTextFilterEnabled(true);
        list.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        String item = (String) list.getItemAtPosition(i);
        Log.d(TAG,"you selected "+item+" at position "+i);
        openIntent(i);

    }

    public void openIntent(int pos)
    {
        startActivityForResult(ACTIVITY_INTENTS[pos],1);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {

        super.startActivityForResult(intent, requestCode);

    }
}
