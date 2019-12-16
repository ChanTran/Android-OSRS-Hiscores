package com.example.chan.osrshighscores;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chan on 12/2/2017.
 */

public class NoteEditActivity extends AppCompatActivity {
    private NotesDatabase db;
    private EditText subject;
    private EditText body;
    private Notes note;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_edit_activity);

        //Create the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarEdit);
        setSupportActionBar(toolbar);

        //Get the note from the activity to display
        note = NotesAllActivity.getClickedNote();

        db = new NotesDatabase(this, null, null, 1); // Open the database
        subject = (EditText)findViewById(R.id.subjectEditTextOther);
        body = (EditText)findViewById(R.id.bodyEditTextOther);
        subject.setText(note.getSubject());
        body.setText(note.getBody());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
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
            case R.id.action_mark: //When this button is clicked, check to see if it is already marked or not and change the status
                if(note.getMarked())
                {
                    note.setMarked(0);
                    db.updateNote(note.getID(), 0);
                    Toast.makeText(this, "Note Unmarked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    note.setMarked(1);
                    db.updateNote(note.getID(), 1);
                    Toast.makeText(this, "Note Marked", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.action_editDone: // Save the note by updating it to database
                if(subject.getText().toString().isEmpty() || body.getText().toString().isEmpty())
                {
                    Toast.makeText(this, "Please enter a subject and a body", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int flag;
                    if(note.getMarked())
                    {
                        flag = 1;
                    }
                    else
                    {
                        flag = 0;
                    }
                    db.updateNote(note.getID(), subject.getText().toString(), body.getText().toString(), flag);
                    Toast.makeText(this, "Successfully saved note", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.action_delete: // Dialog will popup prompting the user to delete the note
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Delete Note Confirmation");
                alert.setMessage("Delete this note?");
                Dialog dia = new Dialog();
                alert.setPositiveButton("Yes", dia);
                alert.setNegativeButton("No", dia);
                alert.show();
                return true;
            case R.id.action_back:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class Dialog implements DialogInterface.OnClickListener{
        public void onClick(DialogInterface dialog, int id)
        {
            if(id==-1)//yes
            {
                db.deleteNote(note.getID());
                Toast.makeText(NoteEditActivity.this, "Note deleted", Toast.LENGTH_SHORT).show();
                NoteEditActivity.this.finish();
            }
            if(id == -2) //no, do nothing
            {}
        }
    }

}
