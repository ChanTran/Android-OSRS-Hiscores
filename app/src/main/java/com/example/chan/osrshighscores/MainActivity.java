package com.example.chan.osrshighscores;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private PlayerSkills player;
    private EditText user;
    private boolean firstEnter;
    private NumberFormat numberFormatter = new DecimalFormat("#,###,###,###");
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstEnter = true;

        user = (EditText)findViewById(R.id.usernameEdit);


        //When the user presses the enter button
        user.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            public boolean onEditorAction(TextView v, int actionId, KeyEvent e)
            {
                player = null;
                if(actionId == EditorInfo.IME_ACTION_DONE || actionId == 5 || (e.getAction() == KeyEvent.ACTION_DOWN && (e.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_NULL && e.getAction() == KeyEvent.ACTION_DOWN))
                {
                    Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                    user = (EditText)findViewById(R.id.usernameEdit);
                    OpenWeb job = new OpenWeb(); // Use the Async class to help execute the URL link to find player
                    job.execute(user.getText().toString());

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(user.getWindowToken(), 0);

                    return true;
                }
                return false;
            }
        });
    }

   /* public void onRestart()
    {
        super.onRestart();
        if(!user.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Updating...", Toast.LENGTH_SHORT).show();
            OpenWeb job = new OpenWeb();
            job.execute(user.getText().toString());
        }
    }*/

   /*
    *This class helps load the URL in the background to be able to parse the information from the Runescape website.
    */
    private class OpenWeb extends AsyncTask<String, Void, String> {
        private String[] arr;
        private boolean networkConnected = false;

        @Override
        protected String doInBackground(String[] params) {
            if(new Network(MainActivity.this).checkNetwork())
            {
                arr = URLinformation.getSkillLevels(params[0]); //Opens the url and finds the info
                player = new PlayerSkills(arr); //Parses the info into presentable data
                networkConnected = true;
            }
            return "";
        }

        /*
        * Executed once the URL is loaded and information is found
         */
        @Override
        protected void onPostExecute(String message) {
            if(networkConnected)
            {
                if(player != null && !player.getStatus()) // if the player does not exist, show dialog for player not found and execute the unranked information
                {
                    PlayerSkills playerNew = getPlayer();
                    getIntent().putExtra("player", playerNew);

                    Toast.makeText(MainActivity.this, "Player not found", Toast.LENGTH_LONG).show();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    SkillsFragment fragment = new SkillsFragment();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_up,R.anim.slide_down);
                    fragmentTransaction.replace(R.id.relativeLay, fragment);
                    fragmentTransaction.commit();
                }
                else if(player != null) // otherwise we found the player
                {
                    PlayerSkills playerNew = getPlayer();
                    getIntent().putExtra("player", playerNew);

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    SkillsFragment fragment = new SkillsFragment();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_up,R.anim.slide_down);
                    fragmentTransaction.replace(R.id.relativeLay, fragment);
                    fragmentTransaction.commit();
                }
                if(firstEnter)
                {
                    TextView view = (TextView)findViewById(R.id.hint);
                    view.setVisibility(View.INVISIBLE);
                    firstEnter = false;
                }
            }
            else
            {
                Toast.makeText(MainActivity.this, "No internet connection available", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*
           Executed when the enter button is pressed
     */
    public void enter(View v)
    {
        Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
        user = (EditText)findViewById(R.id.usernameEdit);
        OpenWeb job = new OpenWeb();
        job.execute(user.getText().toString());


        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(user.getWindowToken(), 0);
    }


    /*
     * This method gathers the data from the Player object for the specified press by the user.
     * We need info on the skill, rank, level, XP, and image to display for the PopupWindow
     */
    public void clicked(View v)
    {
        String skill = "";
        String skillLevel = "";
        String skillXP = "";
        String skillRank = "";
        Drawable image = null;

        switch(v.getId())
        {
            case R.id.attack:
                skill = "Attack";
                skillLevel = player.getAttackLevel();
                skillXP = player.getAttackXP();
                skillRank = player.getAttackRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.attack, null);
                break;
            case R.id.strength:
                skill = "Strength";
                skillLevel = player.getStrengthLevel();
                skillXP = player.getStrengthXP();
                skillRank = player.getStrengthRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.strength, null);
                break;
            case R.id.defense:
                skill = "Defense";
                skillLevel = player.getDefenceLevel();
                skillXP = player.getDefenceXP();
                skillRank = player.getDefenceRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.defense, null);
                break;
            case R.id.ranged:
                skill = "Ranged";
                skillLevel = player.getRangedLevel();
                skillXP = player.getRangedXP();
                skillRank = player.getRangedRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.ranged, null);
                break;
            case R.id.prayer:
                skill = "Prayer";
                skillLevel = player.getPrayerLevel();
                skillXP = player.getPrayerXP();
                skillRank = player.getPrayerRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.prayer, null);
                break;
            case R.id.magic:
                skill = "Magic";
                skillLevel = player.getMagicLevel();
                skillXP = player.getMagicXP();
                skillRank = player.getMagicRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.magic, null);
                break;
            case R.id.runecraft:
                skill = "Runecrafting";
                skillLevel = player.getRunecraftLevel();
                skillXP = player.getRunecraftXP();
                skillRank = player.getRunecraftRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.ruencrafting, null);
                break;
            case R.id.construction:
                skill = "Construction";
                skillLevel = player.getConstructionLevel();
                skillXP = player.getConstructionXP();
                skillRank = player.getConstructionRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.construction, null);
                break;
            case R.id.hitpoints:
                skill = "Hitpoints";
                skillLevel = player.getHitpointsLevel();
                skillXP = player.getHitpointsXP();
                skillRank = player.getHitpointsRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.hitpoints, null);
                break;
            case R.id.agility:
                skill = "Agility";
                skillLevel = player.getAgilityLevel();
                skillXP = player.getAgilityXP();
                skillRank = player.getAgilityRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.agility, null);
                break;
            case R.id.herblore:
                skill = "Herblore";
                skillLevel = player.getHerbloreLevel();
                skillXP = player.getHerbloreXP();
                skillRank = player.getHerbloreRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.herblore, null);
                break;
            case R.id.thieving:
                skill = "Thieving";
                skillLevel = player.getThievingLevel();
                skillXP = player.getThievingXP();
                skillRank = player.getThievingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.thieving, null);
                break;
            case R.id.crafting:
                skill = "Crafting";
                skillLevel = player.getCraftingLevel();
                skillXP = player.getCraftingXP();
                skillRank = player.getCraftingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.crafting, null);
                break;
            case R.id.fletching:
                skill = "Fletching";
                skillLevel = player.getFletchingLevel();
                skillXP = player.getFletchingXP();
                skillRank = player.getFletchingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.fletching, null);
                break;
            case R.id.slayer:
                skill = "Slayer";
                skillLevel = player.getSlayerLevel();
                skillXP = player.getSlayerXP();
                skillRank = player.getSlayerRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.slayer, null);
                break;
            case R.id.hunter:
                skill = "Hunter";
                skillLevel = player.getHunterLevel();
                skillXP = player.getHunterXP();
                skillRank = player.getHunterRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.hunter, null);
                break;
            case R.id.mining:
                skill = "Mining";
                skillLevel = player.getMiningLevel();
                skillXP = player.getMiningXP();
                skillRank = player.getMiningRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.mining, null);
                break;
            case R.id.smithing:
                skill = "Smithing";
                skillLevel = player.getSlayerLevel();
                skillXP = player.getSmithingXP();
                skillRank = player.getSmithingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.smithing, null);
                break;
            case R.id.fishing:
                skill = "Fishing";
                skillLevel = player.getFishingLevel();
                skillXP = player.getFishingXP();
                skillRank = player.getFishingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.fishing, null);
                break;
            case R.id.cooking:
                skill = "Cooking";
                skillLevel = player.getCookingLevel();
                skillXP = player.getCookingXP();
                skillRank = player.getCookingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.cooking, null);
                break;
            case R.id.firemaking:
                skill = "Firemaking";
                skillLevel = player.getFiremakingLevel();
                skillXP = player.getFiremakingXP();
                skillRank = player.getFiremakingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.firemaking, null);
                break;
            case R.id.woodcutting:
                skill = "Woodcutting";
                skillLevel = player.getWoodcuttingLevel();
                skillXP = player.getWoodcuttingXP();
                skillRank = player.getWoodcuttingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.woodcutting, null);
                break;
            case R.id.farming:
                skill = "Farming";
                skillLevel = player.getFarmingLevel();
                skillXP = player.getFarmingXP();
                skillRank = player.getFarmingRank();
                image = ResourcesCompat.getDrawable(getResources(), R.drawable.farming, null);
                break;
        }

        createPopUpWindow(skill, skillLevel, skillXP, skillRank, image);
    }

    /*
    * Creates the PopupWindow for the press
    * The Content depends on what view the user pressed on
     */
    public void createPopUpWindow(String skill, String skillLevel, String skillXP, String skillRank, Drawable img) {
        player.calculateXpDiff(skillXP);
        double percent = player.getPercent();
        int xpDiff = player.getXpDiff();
        if(percent<0)
        {
            percent = 0;
        }

        //Get Screen size
        Point p = new Point();
        getWindowManager().getDefaultDisplay().getSize(p);
        int width = p.x;
        int height = p.y;

        //Create popupwindow
        LayoutInflater layoutInflater
                = (LayoutInflater) getBaseContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_window, null);
        popupWindow = new PopupWindow(
                popupView,
                (int)(width*.8),
                (int)(height*.6));
        popupWindow.setAnimationStyle(R.style.Animation);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(popupView, Gravity.CENTER,0 ,0);
        Button btnDismiss = (Button) popupView.findViewById(R.id.buttonClose);

        ButtonListener list = new ButtonListener();
        btnDismiss.setOnClickListener(list);

        //Update Views
        TextView skillName = (TextView)popupView.findViewById(R.id.skillName);
        skillName.setText(skill);
        skillName.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);

        TextView skillLevelText = (TextView)popupView.findViewById(R.id.levelDisplay);
        skillLevelText.setText(skillLevel);

        TextView skillXpText = (TextView)popupView.findViewById(R.id.xpDisplay);
        skillXpText.setText(numberFormatter.format(Long.parseLong(skillXP)));

        TextView skillRankText = (TextView)popupView.findViewById(R.id.rankDisplay);
        skillRankText.setText(numberFormatter.format(Integer.parseInt(skillRank)));

        ProgressBar pBar = (ProgressBar)popupView.findViewById(R.id.progressBar);
        TextView pText = (TextView)popupView.findViewById(R.id.txtProgress);
        TextView skillText = (TextView)popupView.findViewById(R.id.xpUntil);

        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(pBar, "progress", 0, (int)percent);
        progressAnimator.setDuration(1750);
        progressAnimator.setInterpolator(new AccelerateInterpolator());
        progressAnimator.start();

        pText.setText((int)percent + "%");
        skillText.setText("EXP until next level: " + numberFormatter.format(xpDiff));
    }

    private class ButtonListener implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            popupWindow.dismiss();
        }
    }

    public PlayerSkills getPlayer()
    {
        return new PlayerSkills(player);
    }



    /*
     * The methods below are for the row of buttons on the bottom of the screen, some are not shown at the moment because they are for future updates.
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
    public void compare(View v)
    {
        Intent intent = new Intent(this, CompareActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

}
