package com.example.chan.osrshighscores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by Chan on 11/30/2017.
 */

public class NotesAllActivity extends AppCompatActivity {
    private NotesDatabase db;
    private ClickView clickListener;
    private static Notes clickedNote;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Create the database
        db = new NotesDatabase(this, null, null, 1);


        clickListener = new ClickView();
        createView();

        //Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onRestart()
    {
        super.onRestart();
        createView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

        switch(id)
        {
            case R.id.action_add:
               Intent add = new Intent(this, NoteAddActivity.class);
                startActivity(add);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



/*
* This method creates the view for the layout, since the number of notes is not the same every time.
* A TableLayout within a RelativeLayout within a ScrollLayout is being used.
 */
    public void createView()
    {

        ArrayList<Notes> notes = db.getAll(); //Gather all the notes stored in the DB

        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.notes_activity, null); // inflate the XML layout so we can add the TableLayout to it.

        TableLayout table = (TableLayout)v.findViewById(R.id.tableNote);

        for(Notes note: notes)
        {
            TableRow row = new TableRow(this);
            row.setWeightSum(1.0f); //the sum of the row is 1
            if(note.getMarked()) //if marked, BG will be green, otherwise it will be red
            {
                row.setBackgroundResource(R.drawable.notes_item_true);
            }
            else
            {
                row.setBackgroundResource(R.drawable.notes_item);
            }

            //Set the params for the subject editText
            TableRow.LayoutParams lpSub = new TableRow.LayoutParams(0, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, getResources().getDisplayMetrics()));
            lpSub.weight=0.4f;
            TextView subject = new TextView(this);
            subject.setGravity(Gravity.CENTER);
            subject.setLayoutParams(lpSub);
            subject.setPadding(15,5,5,5);
            subject.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            subject.setTypeface(null, Typeface.BOLD);
            subject.setTextColor(Color.parseColor("#528B8B"));
            subject.setMaxLines(2);
            subject.setEllipsize(TextUtils.TruncateAt.END);


            //Set the params for the body editText
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            lp.weight=0.4f;
            lp.setMargins(5,0,0,0);
            TextView body = new TextView(this);
            body.setLayoutParams(lp);
            body.setGravity(Gravity.CENTER);
            body.setPadding(5,5,5,5);
            body.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            body.setMaxLines(1);
            body.setEllipsize(TextUtils.TruncateAt.END);

            //params for the imageicon arrow
            ImageView icon = new ImageView(this);
            icon.setImageResource(R.drawable.ic_navigate_next_black_24dp);
            TableRow.LayoutParams lpArrow = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            lpArrow.weight=0.2f;
            lp.setMargins(10,0,0,0);
            icon.setLayoutParams(lpArrow);
            icon.setPadding(5,5,15,5);

            subject.setText(note.getSubject());
            body.setText(note.getBody());
            row.setId(note.getID());

            //To use the layout weight property properly, the width of the views must be added as 0
            row.setGravity(Gravity.CENTER_VERTICAL);
            row.addView(subject, new TableRow.LayoutParams(0, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, getResources().getDisplayMetrics()), 0.3f));
            row.addView(body, new TableRow.LayoutParams(0, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, getResources().getDisplayMetrics()), 0.6f));
            row.addView(icon, new TableRow.LayoutParams(0, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, getResources().getDisplayMetrics()), 0.1f));
            row.setClickable(true);
            row.setOnClickListener(clickListener);

            table.addView(row);

            //Add line to TableRow
            TableRow rowLine = new TableRow(this);
            rowLine.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            View vLine = new View(this);
            TableRow.LayoutParams lpLine = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1);
            lpLine.weight = 1.0f;
            vLine.setLayoutParams(lpLine);
            vLine.setBackgroundColor(Color.parseColor("#B1BCBE"));

            rowLine.addView(vLine);
            table.addView(rowLine);
        }
        setContentView(v);
    }


    private class ClickView implements View.OnClickListener {
        public void onClick(View v) // if the row is clicked, we need to get the id of the note and store it so we can transfer the data over to a new activity
        {
            TableRow row = (TableRow)v;
            int id = row.getId();
            clickedNote = db.getOne(id);
            Intent in = new Intent(NotesAllActivity.this, NoteEditActivity.class);
            NotesAllActivity.this.startActivity(in);
        }
    }

    protected static Notes getClickedNote()
    {
        return clickedNote;
    }


    /*
    * Methods onClicks for the buttons on the bottom
     */
    public void settings(View v)
    {
        Toast.makeText(this, "Coming soon with addition of Goals", Toast.LENGTH_SHORT).show();
    }
    public void goals(View v)
    {
        Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
    }
    public void search(View v)
    {
        Intent in = new Intent(this, MainActivity.class);
        this.startActivity(in);
        overridePendingTransition(0,0);
    }
    public void compare(View v)
    {
        Intent intent = new Intent(this, CompareActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
}
