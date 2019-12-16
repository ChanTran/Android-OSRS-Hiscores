package com.example.chan.osrshighscores;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 * Created by Chan on 11/26/2017.
 */

public class SkillsFragment extends Fragment {

    private NumberFormat numberFormatter = new DecimalFormat("#,###,###,###");
    private PlayerSkills player;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.level_fragment, container, false);

        //Params of the fragment, where to place them
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, R.id.lineDivide);
        params.setMargins(0,0,0,0);
        params.addRule(RelativeLayout.ABOVE,R.id.lineButton);
        view.setLayoutParams(params);

        //Get the PlayerSkills object which was serialized in the MainActivity
        player =(PlayerSkills) getActivity().getIntent().getSerializableExtra("player");
        setTotalLevels(view);
        setLevels(view);


        return view;
    }

    public void setTotalLevels(View v)
    {
        TextView totalLevel = (TextView) v.findViewById(R.id.totalLevelEdit);
        TextView totalLevelXP = (TextView) v.findViewById(R.id.totalLevelXPEdit);
        TextView totalLevelRank = (TextView) v.findViewById(R.id.totalLevelRankEdit);

        totalLevel.setText(player.getTotalLevel());
        totalLevelRank.setText(player.getTotalLevelRank());
        totalLevelXP.setText(player.getTotalLevelXP());
    }



    public void setLevels(View v)
    {
        //Attack, setting the TextViews to the information
        TextView attackLevel = (TextView) v.findViewById(R.id.attackLevel);
        TextView attackRank = (TextView) v.findViewById(R.id.attackRank);
        attackLevel.setText(player.getAttackLevel());
        attackRank.setText(numberFormatter.format(Integer.parseInt(player.getAttackRank())));
        //Strength
        TextView strengthLevel = (TextView) v.findViewById(R.id.strengthLevel);
        TextView strengthRank = (TextView) v.findViewById(R.id.strengthRank);
        strengthLevel.setText(player.getStrengthLevel());
        strengthRank.setText(numberFormatter.format(Integer.parseInt(player.getStrengthRank())));
        //defense
        TextView defenseLevel = (TextView) v.findViewById(R.id.defenseLevel);
        TextView defenseRank = (TextView) v.findViewById(R.id.defenseRank);
        defenseLevel.setText(player.getDefenceLevel());
        defenseRank.setText(numberFormatter.format(Integer.parseInt(player.getDefenceRank())));
        //ranged
        TextView rangedLevel = (TextView) v.findViewById(R.id.rangedLevel);
        TextView rangedRank = (TextView) v.findViewById(R.id.rangedRank);
        rangedLevel.setText(player.getRangedLevel());
        rangedRank.setText(numberFormatter.format(Integer.parseInt(player.getRangedRank())));
        //prayer
        TextView prayerLevel = (TextView) v.findViewById(R.id.prayerLevel);
        TextView prayerRank = (TextView) v.findViewById(R.id.prayerRank);
        prayerLevel.setText(player.getPrayerLevel());
        prayerRank.setText(numberFormatter.format(Integer.parseInt(player.getPrayerRank())));
        //magic
        TextView magicLevel = (TextView) v.findViewById(R.id.magicLevel);
        TextView magicRank = (TextView) v.findViewById(R.id.magicRank);
        magicLevel.setText(player.getMagicLevel());
        magicRank.setText(numberFormatter.format(Integer.parseInt(player.getMagicRank())));
        //runecraft
        TextView runecraftingLevel = (TextView) v.findViewById(R.id.runecraftLevel);
        TextView runecraftingRank = (TextView) v.findViewById(R.id.runecraftRank);
        runecraftingLevel.setText(player.getRunecraftLevel());
        runecraftingRank.setText(numberFormatter.format(Integer.parseInt(player.getRunecraftRank())));
        //construction
        TextView constructionLevel = (TextView) v.findViewById(R.id.constructionLevel);
        TextView constructionRank = (TextView) v.findViewById(R.id.constructionRank);
        constructionLevel.setText(player.getConstructionLevel());
        constructionRank.setText(numberFormatter.format(Integer.parseInt(player.getConstructionRank())));
        //hitpoints
        TextView hitpointsLevel = (TextView) v.findViewById(R.id.hitpointsLevel);
        TextView hitpointsRank = (TextView) v.findViewById(R.id.hitpointsRank);
        hitpointsLevel.setText(player.getHitpointsLevel());
        hitpointsRank.setText(numberFormatter.format(Integer.parseInt(player.getHitpointsRank())));
        //agility
        TextView agilityLevel = (TextView) v.findViewById(R.id.agilityLevel);
        TextView agilityRank = (TextView) v.findViewById(R.id.agilityRank);
        agilityLevel.setText(player.getAgilityLevel());
        agilityRank.setText(numberFormatter.format(Integer.parseInt(player.getAgilityRank())));
        //herblore
        TextView herbloreLevel = (TextView) v.findViewById(R.id.herbloreLevel);
        TextView herbloreRank = (TextView) v.findViewById(R.id.herbloreRank);
        herbloreLevel.setText(player.getHerbloreLevel());
        herbloreRank.setText(numberFormatter.format(Integer.parseInt(player.getHerbloreRank())));
        //thieving
        TextView thievingLevel = (TextView) v.findViewById(R.id.thievingLevel);
        TextView thievingRank = (TextView) v.findViewById(R.id.thievingRank);
        thievingLevel.setText(player.getThievingLevel());
        thievingRank.setText(numberFormatter.format(Integer.parseInt(player.getThievingRank())));
        //crafting
        TextView craftingLevel = (TextView) v.findViewById(R.id.craftingLevel);
        TextView craftingRank = (TextView) v.findViewById(R.id.craftingRank);
        craftingLevel.setText(player.getCraftingLevel());
        craftingRank.setText(numberFormatter.format(Integer.parseInt(player.getCraftingRank())));
        //fletching
        TextView fletchingLevel = (TextView) v.findViewById(R.id.fletchingLevel);
        TextView fletchingRank = (TextView) v.findViewById(R.id.fletchingRank);
        fletchingLevel.setText(player.getFletchingLevel());
        fletchingRank.setText(numberFormatter.format(Integer.parseInt(player.getFletchingRank())));
        //slayer
        TextView slayerLevel = (TextView) v.findViewById(R.id.slayerLevel);
        TextView slayerRank = (TextView) v.findViewById(R.id.slayerRank);
        slayerLevel.setText(player.getSlayerLevel());
        slayerRank.setText(numberFormatter.format(Integer.parseInt(player.getSlayerRank())));
        //hunter
        TextView hunterLevel = (TextView) v.findViewById(R.id.hunterLevel);
        TextView hunterRank = (TextView) v.findViewById(R.id.hunterRank);
        hunterLevel.setText(player.getHunterLevel());
        hunterRank.setText(numberFormatter.format(Integer.parseInt(player.getHunterRank())));
        //mining
        TextView miningLevel = (TextView) v.findViewById(R.id.miningLevel);
        TextView miningRank = (TextView) v.findViewById(R.id.miningRank);
        miningLevel.setText(player.getMiningLevel());
        miningRank.setText(numberFormatter.format(Integer.parseInt(player.getMiningRank())));
        //smithing
        TextView smithingLevel = (TextView) v.findViewById(R.id.smithingLevel);
        TextView smithingRank = (TextView) v.findViewById(R.id.smithingRank);
        smithingLevel.setText(player.getSmithingLevel());
        smithingRank.setText(numberFormatter.format(Integer.parseInt(player.getSmithingRank())));
        //fishing
        TextView fishingLevel = (TextView) v.findViewById(R.id.fishingLevel);
        TextView fishingRank = (TextView) v.findViewById(R.id.fishingRank);
        fishingLevel.setText(player.getFishingLevel());
        fishingRank.setText(numberFormatter.format(Integer.parseInt(player.getFishingRank())));
        //cooking
        TextView cookingLevel = (TextView) v.findViewById(R.id.cookingLevel);
        TextView cookingRank = (TextView) v.findViewById(R.id.cookingRank);
        cookingLevel.setText(player.getCookingLevel());
        cookingRank.setText(numberFormatter.format(Integer.parseInt(player.getCookingRank())));
        //firemaking
        TextView firemakingLevel = (TextView) v.findViewById(R.id.firemakingLevel);
        TextView firemakingRank = (TextView) v.findViewById(R.id.firemakingRank);
        firemakingLevel.setText(player.getFiremakingLevel());
        firemakingRank.setText(numberFormatter.format(Integer.parseInt(player.getFiremakingRank())));
        //woodcutting
        TextView woodcuttingLevel = (TextView) v.findViewById(R.id.woodcuttingLevel);
        TextView woodcuttingRank = (TextView) v.findViewById(R.id.woodcuttingRank);
        woodcuttingLevel.setText(player.getWoodcuttingLevel());
        woodcuttingRank.setText(numberFormatter.format(Integer.parseInt(player.getWoodcuttingRank())));
        //farming
        TextView farmingLevel = (TextView) v.findViewById(R.id.farmingLevel);
        TextView farmingRank = (TextView) v.findViewById(R.id.farmingRank);
        farmingLevel.setText(player.getFarmingLevel());
        farmingRank.setText(numberFormatter.format(Integer.parseInt(player.getFarmingRank())));
    }
}
