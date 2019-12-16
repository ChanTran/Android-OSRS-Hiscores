package com.example.chan.osrshighscores;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Chan on 12/4/2017.
 */

public class CompareFragment extends Fragment {
    private PlayerSkills playerOne;
    private PlayerSkills playerTwo;
    private PlayerCompare compare;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.compare_fragment, container, false);

        //Create the params for the layout
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, R.id.lineDivideCompare);
        params.setMargins(0,0,0,0);
        params.addRule(RelativeLayout.ABOVE,R.id.lineButtonCompare);
        view.setLayoutParams(params);

        //Find the player data here through the Serializable that the activity sent
        compare = new PlayerCompare();
        playerOne =(PlayerSkills) getActivity().getIntent().getSerializableExtra("playerOne");
        playerTwo = (PlayerSkills) getActivity().getIntent().getSerializableExtra("playerTwo");
        String displayOne = (String) getActivity().getIntent().getSerializableExtra("displayOne");
        String displayTwo = (String) getActivity().getIntent().getSerializableExtra("displayTwo");
        TextView dOne = (TextView) view.findViewById(R.id.displayOne);
        TextView dTwo = (TextView) view.findViewById(R.id.displayTwo);
        dOne.setText(displayOne);
        dTwo.setText(displayTwo);

        setTotalLevels(view);
        setLevels(view);


        return view;
    }

    /*
     *The methods below set the levels for each row
     * The Textview ids must be found and changed and depends on the username data that was found.
     */
    public void setTotalLevels(View v)
    {
        TextView totalLevelOne = (TextView) v.findViewById(R.id.totalLevelOne);
        TextView totalLevelTwo = (TextView) v.findViewById(R.id.totalLevelTwo);
        TextView totalLevelDiff = (TextView)v.findViewById(R.id.totalLevelDiff);

        totalLevelOne.setText(playerOne.getTotalLevel());
        totalLevelTwo.setText(playerTwo.getTotalLevel());
        totalLevelDiff.setText(compare.comparePlayersLevel(playerOne.getTotalLevel(), playerTwo.getTotalLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            totalLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            totalLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            totalLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
    }


    public void setLevels(View v)
    {
        //Attack
        TextView attackLevelOne = (TextView)v.findViewById(R.id.attackLevelOne);
        TextView attackLevelTwo = (TextView)v.findViewById(R.id.attackLevelTwo);
        TextView attackLevelDiff = (TextView)v.findViewById(R.id.attackDiff);
        attackLevelOne.setText(playerOne.getAttackLevel());
        attackLevelTwo.setText(playerTwo.getAttackLevel());
        attackLevelDiff.setText(compare.comparePlayersLevel(playerOne.getAttackLevel(), playerTwo.getAttackLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            attackLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            attackLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            attackLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Strength
        TextView strengthLevelOne = (TextView)v.findViewById(R.id.strengthLevelOne);
        TextView strengthLevelTwo = (TextView)v.findViewById(R.id.strengthLevelTwo);
        TextView strengthLevelDiff = (TextView)v.findViewById(R.id.strengthDiff);
        strengthLevelOne.setText(playerOne.getStrengthLevel());
        strengthLevelTwo.setText(playerTwo.getStrengthLevel());
        strengthLevelDiff.setText(compare.comparePlayersLevel(playerOne.getStrengthLevel(), playerTwo.getStrengthLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            strengthLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            strengthLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            strengthLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Defense
        TextView defenseLevelOne = (TextView)v.findViewById(R.id.defenseLevelOne);
        TextView defenseLevelTwo = (TextView)v.findViewById(R.id.defenseLevelTwo);
        TextView defenseLevelDiff = (TextView)v.findViewById(R.id.defenseDiff);
        defenseLevelOne.setText(playerOne.getDefenceLevel());
        defenseLevelTwo.setText(playerTwo.getDefenceLevel());
        defenseLevelDiff.setText(compare.comparePlayersLevel(playerOne.getDefenceLevel(), playerTwo.getDefenceLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            defenseLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            defenseLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            defenseLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Ranged
        TextView rangedLevelOne = (TextView)v.findViewById(R.id.rangedLevelOne);
        TextView rangedLevelTwo = (TextView)v.findViewById(R.id.rangedLevelTwo);
        TextView rangedLevelDiff = (TextView)v.findViewById(R.id.rangedDiff);
        rangedLevelOne.setText(playerOne.getRangedLevel());
        rangedLevelTwo.setText(playerTwo.getRangedLevel());
        rangedLevelDiff.setText(compare.comparePlayersLevel(playerOne.getRangedLevel(), playerTwo.getRangedLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            rangedLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            rangedLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            rangedLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Prayer
        TextView prayerLevelOne = (TextView)v.findViewById(R.id.prayerLevelOne);
        TextView prayerLevelTwo = (TextView)v.findViewById(R.id.prayerLevelTwo);
        TextView prayerLevelDiff = (TextView)v.findViewById(R.id.prayerDiff);
        prayerLevelOne.setText(playerOne.getPrayerLevel());
        prayerLevelTwo.setText(playerTwo.getPrayerLevel());
        prayerLevelDiff.setText(compare.comparePlayersLevel(playerOne.getPrayerLevel(), playerTwo.getPrayerLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            prayerLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            prayerLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            prayerLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Magic
        TextView magicLevelOne = (TextView)v.findViewById(R.id.magicLevelOne);
        TextView magicLevelTwo = (TextView)v.findViewById(R.id.magicLevelTwo);
        TextView magicLevelDiff = (TextView)v.findViewById(R.id.magicDiff);
        magicLevelOne.setText(playerOne.getMagicLevel());
        magicLevelTwo.setText(playerTwo.getMagicLevel());
        magicLevelDiff.setText(compare.comparePlayersLevel(playerOne.getMagicLevel(), playerTwo.getMagicLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            magicLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            magicLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            magicLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Runecraft
        TextView runecraftLevelOne = (TextView)v.findViewById(R.id.runecraftingLevelOne);
        TextView runecraftLevelTwo = (TextView)v.findViewById(R.id.runecraftingLevelTwo);
        TextView runecraftLevelDiff = (TextView)v.findViewById(R.id.runecraftingDiff);
        runecraftLevelOne.setText(playerOne.getRunecraftLevel());
        runecraftLevelTwo.setText(playerTwo.getRunecraftLevel());
        runecraftLevelDiff.setText(compare.comparePlayersLevel(playerOne.getRunecraftLevel(), playerTwo.getRunecraftLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            runecraftLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            runecraftLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            runecraftLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Construction
        TextView constructionLevelOne = (TextView)v.findViewById(R.id.constructionLevelOne);
        TextView constructionLevelTwo = (TextView)v.findViewById(R.id.constructionLevelTwo);
        TextView constructionLevelDiff = (TextView)v.findViewById(R.id.constructionDiff);
        constructionLevelOne.setText(playerOne.getConstructionLevel());
        constructionLevelTwo.setText(playerTwo.getConstructionLevel());
        constructionLevelDiff.setText(compare.comparePlayersLevel(playerOne.getConstructionLevel(), playerTwo.getConstructionLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            constructionLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            constructionLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            constructionLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Hitpoints
        TextView hitpointsLevelOne = (TextView)v.findViewById(R.id.hitpointsLevelOne);
        TextView hitpointsLevelTwo = (TextView)v.findViewById(R.id.hitpointsLevelTwo);
        TextView hitpointsLevelDiff = (TextView)v.findViewById(R.id.hitpointsDiff);
        hitpointsLevelOne.setText(playerOne.getHitpointsLevel());
        hitpointsLevelTwo.setText(playerTwo.getHitpointsLevel());
        hitpointsLevelDiff.setText(compare.comparePlayersLevel(playerOne.getHitpointsLevel(), playerTwo.getHitpointsLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            hitpointsLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            hitpointsLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            hitpointsLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Agility
        TextView agilityLevelOne = (TextView)v.findViewById(R.id.agilityLevelOne);
        TextView agilityLevelTwo = (TextView)v.findViewById(R.id.agilityLevelTwo);
        TextView agilityLevelDiff = (TextView)v.findViewById(R.id.agilityDiff);
        agilityLevelOne.setText(playerOne.getAgilityLevel());
        agilityLevelTwo.setText(playerTwo.getAgilityLevel());
        agilityLevelDiff.setText(compare.comparePlayersLevel(playerOne.getAgilityLevel(), playerTwo.getAgilityLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            agilityLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            agilityLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            agilityLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Herblore
        TextView herbloreLevelOne = (TextView)v.findViewById(R.id.herbloreLevelOne);
        TextView herbloreLevelTwo = (TextView)v.findViewById(R.id.herbloreLevelTwo);
        TextView herbloreLevelDiff = (TextView)v.findViewById(R.id.herbloreDiff);
        herbloreLevelOne.setText(playerOne.getHerbloreLevel());
        herbloreLevelTwo.setText(playerTwo.getHerbloreLevel());
        herbloreLevelDiff.setText(compare.comparePlayersLevel(playerOne.getHerbloreLevel(), playerTwo.getHerbloreLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            herbloreLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            herbloreLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            herbloreLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Thieving
        TextView thievingLevelOne = (TextView)v.findViewById(R.id.thievingLevelOne);
        TextView thievingLevelTwo = (TextView)v.findViewById(R.id.thievingLevelTwo);
        TextView thievingLevelDiff = (TextView)v.findViewById(R.id.thievingDiff);
        thievingLevelOne.setText(playerOne.getThievingLevel());
        thievingLevelTwo.setText(playerTwo.getThievingLevel());
        thievingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getThievingLevel(), playerTwo.getThievingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            thievingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            thievingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            thievingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Crafting
        TextView craftingLevelOne = (TextView)v.findViewById(R.id.craftingLevelOne);
        TextView craftingLevelTwo = (TextView)v.findViewById(R.id.craftingLevelTwo);
        TextView craftingLevelDiff = (TextView)v.findViewById(R.id.craftingDiff);
        craftingLevelOne.setText(playerOne.getCraftingLevel());
        craftingLevelTwo.setText(playerTwo.getCraftingLevel());
        craftingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getCraftingLevel(), playerTwo.getCraftingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            craftingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            craftingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            craftingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Fletching
        TextView fletchingLevelOne = (TextView)v.findViewById(R.id.fletchingLevelOne);
        TextView fletchingLevelTwo = (TextView)v.findViewById(R.id.fletchingLevelTwo);
        TextView fletchingLevelDiff = (TextView)v.findViewById(R.id.fletchingDiff);
        fletchingLevelOne.setText(playerOne.getFletchingLevel());
        fletchingLevelTwo.setText(playerTwo.getFletchingLevel());
        fletchingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getFletchingLevel(), playerTwo.getFletchingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            fletchingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            fletchingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            fletchingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Slayer
        TextView slayerLevelOne = (TextView)v.findViewById(R.id.slayerLevelOne);
        TextView slayerLevelTwo = (TextView)v.findViewById(R.id.slayerLevelTwo);
        TextView slayerLevelDiff = (TextView)v.findViewById(R.id.slayerDiff);
        slayerLevelOne.setText(playerOne.getSlayerLevel());
        slayerLevelTwo.setText(playerTwo.getSlayerLevel());
        slayerLevelDiff.setText(compare.comparePlayersLevel(playerOne.getSlayerLevel(), playerTwo.getSlayerLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            slayerLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            slayerLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            slayerLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Hunter
        TextView hunterLevelOne = (TextView)v.findViewById(R.id.hunterLevelOne);
        TextView hunterLevelTwo = (TextView)v.findViewById(R.id.hunterLevelTwo);
        TextView hunterLevelDiff = (TextView)v.findViewById(R.id.hunterDiff);
        hunterLevelOne.setText(playerOne.getHunterLevel());
        hunterLevelTwo.setText(playerTwo.getHunterLevel());
        hunterLevelDiff.setText(compare.comparePlayersLevel(playerOne.getHunterLevel(), playerTwo.getHunterLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            hunterLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            hunterLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            hunterLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Mining
        TextView miningLevelOne = (TextView)v.findViewById(R.id.miningLevelOne);
        TextView miningLevelTwo = (TextView)v.findViewById(R.id.miningLevelTwo);
        TextView miningLevelDiff = (TextView)v.findViewById(R.id.miningDiff);
        miningLevelOne.setText(playerOne.getMiningLevel());
        miningLevelTwo.setText(playerTwo.getMiningLevel());
        miningLevelDiff.setText(compare.comparePlayersLevel(playerOne.getMiningLevel(), playerTwo.getMiningLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            miningLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            miningLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            miningLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Smithing
        TextView smithingLevelOne = (TextView)v.findViewById(R.id.smithingLevelOne);
        TextView smithingLevelTwo = (TextView)v.findViewById(R.id.smithingLevelTwo);
        TextView smithingLevelDiff = (TextView)v.findViewById(R.id.smithingDiff);
        smithingLevelOne.setText(playerOne.getSmithingLevel());
        smithingLevelTwo.setText(playerTwo.getSmithingLevel());
        smithingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getSmithingLevel(), playerTwo.getSmithingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            smithingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            smithingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            smithingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Fishing
        TextView fishingLevelOne = (TextView)v.findViewById(R.id.fishingLevelOne);
        TextView fishingLevelTwo = (TextView)v.findViewById(R.id.fishingLevelTwo);
        TextView fishingLevelDiff = (TextView)v.findViewById(R.id.fishingDiff);
        fishingLevelOne.setText(playerOne.getFishingLevel());
        fishingLevelTwo.setText(playerTwo.getFishingLevel());
        fishingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getFishingLevel(), playerTwo.getFishingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            fishingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            fishingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            fishingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Cooking
        TextView cookingLevelOne = (TextView)v.findViewById(R.id.cookingLevelOne);
        TextView cookingLevelTwo = (TextView)v.findViewById(R.id.cookingLevelTwo);
        TextView cookingLevelDiff = (TextView)v.findViewById(R.id.cookingDiff);
        cookingLevelOne.setText(playerOne.getCookingLevel());
        cookingLevelTwo.setText(playerTwo.getCookingLevel());
        cookingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getCookingLevel(), playerTwo.getCookingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            cookingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            cookingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            cookingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Firemaking
        TextView firemakingLevelOne = (TextView)v.findViewById(R.id.firemakingLevelOne);
        TextView firemakingLevelTwo = (TextView)v.findViewById(R.id.firemakingLevelTwo);
        TextView firemakingLevelDiff = (TextView)v.findViewById(R.id.firemakingDiff);
        firemakingLevelOne.setText(playerOne.getFiremakingLevel());
        firemakingLevelTwo.setText(playerTwo.getFiremakingLevel());
        firemakingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getFiremakingLevel(), playerTwo.getFiremakingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            firemakingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            firemakingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            firemakingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Woodcutting
        TextView woodcuttingLevelOne = (TextView)v.findViewById(R.id.woodcuttingLevelOne);
        TextView woodcuttingLevelTwo = (TextView)v.findViewById(R.id.woodcuttingLevelTwo);
        TextView woodcuttingLevelDiff = (TextView)v.findViewById(R.id.woodcuttingDiff);
        woodcuttingLevelOne.setText(playerOne.getWoodcuttingLevel());
        woodcuttingLevelTwo.setText(playerTwo.getWoodcuttingLevel());
        woodcuttingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getWoodcuttingLevel(), playerTwo.getWoodcuttingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            woodcuttingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            woodcuttingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            woodcuttingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
        //Farming
        TextView farmingLevelOne = (TextView)v.findViewById(R.id.farmingLevelOne);
        TextView farmingLevelTwo = (TextView)v.findViewById(R.id.farmingLevelTwo);
        TextView farmingLevelDiff = (TextView)v.findViewById(R.id.farmingDiff);
        farmingLevelOne.setText(playerOne.getFarmingLevel());
        farmingLevelTwo.setText(playerTwo.getFarmingLevel());
        farmingLevelDiff.setText(compare.comparePlayersLevel(playerOne.getFarmingLevel(), playerTwo.getFarmingLevel()));
        if(Integer.parseInt(compare.getLevelDiff())>0)
        {
            farmingLevelDiff.setBackgroundColor(Color.parseColor("#90EE90"));
        }
        else if(Integer.parseInt(compare.getLevelDiff())<0)
        {
            farmingLevelDiff.setBackgroundColor(Color.parseColor("#E55757"));
        }
        else
        {
            farmingLevelDiff.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }
    }

}
