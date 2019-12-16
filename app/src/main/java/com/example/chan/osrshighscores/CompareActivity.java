package com.example.chan.osrshighscores;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Chan on 12/4/2017.
 */

public class CompareActivity extends AppCompatActivity {
    private PlayerSkills playerOne;
    private PlayerSkills playerTwo;
    private EditTextList listener;
    private EditText userOne;
    private EditText userTwo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_activity);

        //Get the edit text for the usernames and add an action listener
        listener = new EditTextList();
        userOne = (EditText)findViewById(R.id.playerOne);
        userTwo = (EditText)findViewById(R.id.playerTwo);

        userOne.setOnEditorActionListener(listener);
        userTwo.setOnEditorActionListener(listener);


    }

    /*
     * Performed when the user clicks on the return button or presses enter.
     * Opens up an Async task like the mainActivity and finds the data out on the Runescape website
     */
    private class EditTextList implements TextView.OnEditorActionListener {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent e) {
            playerOne = null;
            playerTwo = null;
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == 5 || (e.getAction() == KeyEvent.ACTION_DOWN && (e.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_NULL && e.getAction() == KeyEvent.ACTION_DOWN)) {
                if (userOne.getText().toString().isEmpty() || userTwo.getText().toString().isEmpty()) {
                    Toast.makeText(CompareActivity.this, "Please enter users in both fields", Toast.LENGTH_SHORT).show();
                } else {
                    userOne = (EditText) findViewById(R.id.playerOne);
                    userTwo = (EditText) findViewById(R.id.playerTwo);
                    OpenWeb job = new OpenWeb();
                    job.execute(userOne.getText().toString(), userTwo.getText().toString());

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(userOne.getWindowToken(), 0);
                    imm.hideSoftInputFromWindow(userTwo.getWindowToken(), 0);
                    return true;
                }
            }
            return false;
        }
    }

    //Enter button onClick
    public void enterCompare(View v) {
        if (userOne.getText().toString().isEmpty() || userTwo.getText().toString().isEmpty()) {
            Toast.makeText(CompareActivity.this, "Please enter users in both fields", Toast.LENGTH_SHORT).show();
        } else {
            userOne = (EditText) findViewById(R.id.playerOne);
            userTwo = (EditText) findViewById(R.id.playerTwo);
            OpenWeb job = new OpenWeb();
            job.execute(userOne.getText().toString(), userTwo.getText().toString());

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(userOne.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(userTwo.getWindowToken(), 0);
        }
    }

    //Switches the names of the editText
    public void switchNames(View v)
    {
        String first = userOne.getText().toString();
        String second = userTwo.getText().toString();
        userOne.setText(second);
        userTwo.setText(first);
    }
    /*
        *This class helps load the URL in the background to be able to parse the information from the Runescape website.
        */
    private class OpenWeb extends AsyncTask<String, Void, String> {
        private String[] arr;
        private String[] arrTwo;
        private boolean networkConnected = false;

        @Override
        protected String doInBackground(String[] params) {
            if(new Network(CompareActivity.this).checkNetwork())
            {
                arr = URLinformation.getSkillLevels(params[0]);
                arrTwo = URLinformation.getSkillLevels(params[1]);
                playerOne = new PlayerSkills(arr);
                playerTwo = new PlayerSkills(arrTwo);
                networkConnected = true;
            }
            return "";
        }

        @Override
        protected void onPostExecute(String message) {
            if(networkConnected)
            {
                if (playerOne != null && !playerOne.getStatus() || playerTwo != null && !playerTwo.getStatus()) {
                    Toast.makeText(CompareActivity.this, "User(s) not found", Toast.LENGTH_SHORT).show();
                }
                PlayerSkills playerOneNew = getPlayer(playerOne);
                PlayerSkills playerTwoNew = getPlayer(playerTwo);
                getIntent().putExtra("playerOne", playerOneNew);
                getIntent().putExtra("playerTwo", playerTwoNew);
                getIntent().putExtra("displayOne", userOne.getText().toString());
                getIntent().putExtra("displayTwo", userTwo.getText().toString());

                //Create the fragment here to add to the existing XML layout in the middle.
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                CompareFragment fragment = new CompareFragment();
                fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
                fragmentTransaction.replace(R.id.relativeLayCompare, fragment);
                fragmentTransaction.commit();
            }
            else
            {
                Toast.makeText(CompareActivity.this, "No internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public PlayerSkills getPlayer(PlayerSkills player) {
        return new PlayerSkills(player);
    }


    /*
     * Button onClicks
     */
    public void settings(View v)
    {
        Toast.makeText(this, "Coming soon with addition of Goals", Toast.LENGTH_SHORT).show();
    }
    public void goals(View v)
    {
        Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
    }
    public void notes(View v)
    {
        Intent intent = new Intent(this, NotesAllActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    public void search(View v)
    {
        Intent in = new Intent(this, MainActivity.class);
        this.startActivity(in);
        overridePendingTransition(0,0);
    }
}
