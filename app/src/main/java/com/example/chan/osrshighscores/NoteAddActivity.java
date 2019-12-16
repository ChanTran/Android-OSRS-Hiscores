package com.example.chan.osrshighscores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chan on 12/1/2017.
 */

public class NoteAddActivity extends AppCompatActivity {
    private NotesDatabase db;
    private EditText subject;
    private EditText body;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_add_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAdd);
        setSupportActionBar(toolbar);

        db = new NotesDatabase(this, null, null, 1);
        subject = (EditText)findViewById(R.id.subjectEditText);
        body = (EditText)findViewById(R.id.bodyEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id)
        {
            case R.id.action_addSave: //The add button has been clicked
                if(subject.getText().toString().isEmpty() || body.getText().toString().isEmpty()) // If the body or subject is empty, require them to enter something.
                {
                    Toast.makeText(this, "Please enter a subject and a body", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Notes note = new Notes(subject.getText().toString(), body.getText().toString(), 0);
                    db.addNote(note);
                    Toast.makeText(this, "Note added", Toast.LENGTH_SHORT).show();
                    this.finish();
                }
                return true;
            case R.id.action_cancel: //Cancel button has been clicked
                Toast.makeText(this, "Note Cancelled", Toast.LENGTH_SHORT).show();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
