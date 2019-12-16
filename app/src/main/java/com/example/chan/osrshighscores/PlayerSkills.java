package com.example.chan.osrshighscores;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Chan on 11/26/2017.
 */

public class PlayerSkills implements Serializable {

    private String[] skillsSplit;
    private String[] skillsSplitXP;
    private String[] skillsSplitRank;
    private NumberFormat numberFormatter = new DecimalFormat("#,###,###,###");
    private final static int NUMBERS_DATA = 24;
    private final static int[] expTable = {83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523, 3973, 4470, 5018, 5624, 6291, 7028, 7842,
            8740, 9730, 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648, 37224, 41171, 45529, 50339,  55649, 61512, 67983,
            75127, 83014, 91721, 101333, 111945, 123660, 136594, 150872, 166636, 184040, 203254, 224466, 247886, 273742, 302288, 333804, 368599, 407015,
            449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1096278, 1210421, 1336443, 1475581, 1629200, 1798808, 1986068, 2192818,
            2421087, 2673114, 2951373, 3258594, 3597792, 3972294, 4385776, 4842295, 5346332, 5902831, 6517253, 7195629, 7944614, 8771558, 9684577, 10692629,
            11805606, 13034431}; // Needed to calculate the XP to next level




    //Below are the skills and info needed to store for each individual skill
    private String totalLevel;
    private String totalLevelXP;
    private String totalLevelRank;


    private String attackXP;
    private String attackRank;
    private String attackLevel;

    private String strengthXP;
    private String strengthRank;
    private String strengthLevel;

    private String defenceXP;
    private String defenceRank;
    private String defenceLevel;

    private String rangedXP;
    private String rangedRank;
    private String rangedLevel;

    private String prayerXP;
    private String prayerRank;
    private String prayerLevel;

    private String magicXP;
    private String magicRank;
    private String magicLevel;

    private String runecraftXP;
    private String runecraftRank;
    private String runecraftLevel;

    private String constructionXP;
    private String constructionRank;
    private String constructionLevel;

    private String hitpointsXP;
    private String hitpointsRank;
    private String hitpointsLevel;

    private String agilityXP;
    private String agilityRank;
    private String agilityLevel;

    private String herbloreXP;
    private String herbloreRank;
    private String herbloreLevel;

    private String thievingXP;
    private String thievingRank;
    private String thievingLevel;

    private String craftingXP;
    private String craftingRank;
    private String craftingLevel;

    private String fletchingXP;
    private String fletchingRank;
    private String fletchingLevel;

    private String slayerXP;
    private String slayerRank;
    private String slayerLevel;

    private String hunterXP;
    private String hunterRank;
    private String hunterLevel;

    private String miningXP;
    private String miningRank;
    private String miningLevel;

    private String smithingXP;
    private String smithingRank;
    private String smithingLevel;

    private String fishingXP;
    private String fishingRank;
    private String fishingLevel;

    private String cookingXP;
    private String cookingRank;
    private String cookingLevel;

    private String firemakingXP;
    private String firemakingRank;
    private String firemakingLevel;

    private String woodcuttingXP;
    private String woodcuttingRank;
    private String woodcuttingLevel;

    private String farmingXP;
    private String farmingRank;
    private String farmingLevel;

    private boolean playerFound = true;
    private double percent;
    private int xpDiff;

    public PlayerSkills(PlayerSkills player)
    {
        totalLevel = player.getTotalLevel();
        totalLevelXP = player.getTotalLevelXP();
        totalLevelRank = player.getTotalLevelRank();

        //Updating the skills panel based off of info read off of runescape website , lvl, xp, rank
        setAttack(player.getAttackLevel(), player.getAttackXP(), player.getAttackRank());
        setDefence(player.getDefenceLevel(), player.getDefenceXP(), player.getDefenceRank());
        setStrength(player.getStrengthLevel(), player.getStrengthXP(), player.getStrengthRank());
        setHitpoints(player.getHitpointsLevel(), player.getHitpointsXP(), player.getHitpointsRank());
        setRanged(player.getRangedLevel(), player.getRangedXP(), player.getRangedRank());
        setPrayer(player.getPrayerLevel(), player.getPrayerXP(), player.getPrayerRank());
        setMagic(player.getMagicLevel(), player.getMagicXP(), player.getMagicRank());
        setCooking(player.getCookingLevel(), player.getCookingXP(), player.getCookingRank());
        setWoodcutting(player.getWoodcuttingLevel(), player.getWoodcuttingXP(), player.getWoodcuttingRank());
        setFletching(player.getFletchingLevel(), player.getFletchingXP(), player.getFletchingRank());
        setFishing(player.getFishingLevel(), player.getFishingXP(), player.getFishingRank());
        setFiremaking(player.getFiremakingLevel(), player.getFiremakingXP(), player.getFiremakingRank());
        setCrafting(player.getCraftingLevel(), player.getCraftingXP(), player.getCraftingRank());
        setSmithing(player.getSmithingLevel(), player.getSmithingXP(), player.getSmithingRank());
        setMining(player.getMiningLevel(), player.getMiningXP(), player.getMiningRank());
        setHerblore(player.getHerbloreLevel(), player.getHerbloreXP(), player.getHerbloreRank());
        setAgility(player.getAgilityLevel(), player.getAgilityXP(), player.getAgilityRank());
        setThieving(player.getThievingLevel(), player.getThievingXP(), player.getThievingRank());
        setSlayer(player.getSlayerLevel(), player.getSlayerXP(), player.getSlayerRank());
        setFarming(player.getFarmingLevel(), player.getFarmingXP(), player.getFarmingRank());
        setRunecraft(player.getRunecraftLevel(), player.getRunecraftXP(), player.getRunecraftRank());
        setHunter(player.getHunterLevel(), player.getHunterXP(), player.getHunterRank());
        setConstruction(player.getConstructionLevel(), player.getConstructionXP(), player.getConstructionRank());
    }


    public PlayerSkills(String[] data)
   {
       if(data.length == 0) // This means that the data was not found
       {
           //Username is invalid
           totalLevelXP = "0";
           totalLevelRank = "0";
           totalLevel = "0";
           setAttack("1", "0", "0");
           setDefence("1", "0", "0");
           setStrength("1", "0", "0");
           setHitpoints("1", "0", "0");
           setRanged("1", "0", "0");
           setPrayer("1", "0", "0");
           setMagic("1", "0", "0");
           setCooking("1", "0", "0");
           setWoodcutting("1", "0", "0");
           setFletching("1", "0", "0");
           setFishing("1", "0", "0");
           setFiremaking("1", "0", "0");
           setCrafting("1", "0", "0");
           setSmithing("1", "0", "0");
           setMining("1", "0", "0");
           setHerblore("1", "0", "0");
           setAgility("1", "0", "0");
           setThieving("1", "0", "0");
           setSlayer("1", "0", "0");
           setFarming("1", "0", "0");
           setRunecraft("1", "0", "0");
           setHunter("1", "0", "0");
           setConstruction("1", "0", "0");
           playerFound = false;
       }
       else // The data is found, we can start parsing the data
       {
           skillsSplit = new String[NUMBERS_DATA];
           skillsSplitXP = new String[NUMBERS_DATA];
           skillsSplitRank = new String[NUMBERS_DATA];
           for(int i = 0; i < NUMBERS_DATA; i++)
           {
               String[] commaSplit = data[i].split(",");
               if(commaSplit[0].equals("-1"))
                   skillsSplitRank[i] = "0"; // The index at 0 displays the rank of the skill
               else
                   skillsSplitRank[i] = commaSplit[0];
               skillsSplit[i] = commaSplit[1]; // The index at 1 displays the level of the skill
               if(commaSplit[2].equals("-1")) // The index at 2 displays the xp gained in the skill
                   skillsSplitXP[i] = "0";
               else
                   skillsSplitXP[i] = commaSplit[2];
           }
           totalLevel = skillsSplit[0];
           totalLevelXP = numberFormatter.format(Long.parseLong(skillsSplitXP[0]));
           totalLevelRank = numberFormatter.format(Long.parseLong(skillsSplitRank[0]));

           //Updating the skills panel based off of info read off of runescape website
           setAttack(skillsSplit[1], skillsSplitXP[1], skillsSplitRank[1]);
           setDefence(skillsSplit[2], skillsSplitXP[2], skillsSplitRank[2]);
           setStrength(skillsSplit[3], skillsSplitXP[3], skillsSplitRank[3]);
           setHitpoints(skillsSplit[4], skillsSplitXP[4], skillsSplitRank[4]);
           setRanged(skillsSplit[5], skillsSplitXP[5], skillsSplitRank[5]);
           setPrayer(skillsSplit[6], skillsSplitXP[6], skillsSplitRank[6]);
           setMagic(skillsSplit[7], skillsSplitXP[7], skillsSplitRank[7]);
           setCooking(skillsSplit[8], skillsSplitXP[8], skillsSplitRank[8]);
           setWoodcutting(skillsSplit[9], skillsSplitXP[9], skillsSplitRank[9]);
           setFletching(skillsSplit[10], skillsSplitXP[10], skillsSplitRank[10]);
           setFishing(skillsSplit[11], skillsSplitXP[11], skillsSplitRank[11]);
           setFiremaking(skillsSplit[12], skillsSplitXP[12], skillsSplitRank[12]);
           setCrafting(skillsSplit[13], skillsSplitXP[13], skillsSplitRank[13]);
           setSmithing(skillsSplit[14], skillsSplitXP[14], skillsSplitRank[14]);
           setMining(skillsSplit[15], skillsSplitXP[15], skillsSplitRank[15]);
           setHerblore(skillsSplit[16], skillsSplitXP[16], skillsSplitRank[16]);
           setAgility(skillsSplit[17], skillsSplitXP[17], skillsSplitRank[17]);
           setThieving(skillsSplit[18], skillsSplitXP[18], skillsSplitRank[18]);
           setSlayer(skillsSplit[19], skillsSplitXP[19], skillsSplitRank[19]);
           setFarming(skillsSplit[20], skillsSplitXP[20], skillsSplitRank[20]);
           setRunecraft(skillsSplit[21], skillsSplitXP[21], skillsSplitRank[21]);
           setHunter(skillsSplit[22], skillsSplitXP[22], skillsSplitRank[22]);
           setConstruction(skillsSplit[23], skillsSplitXP[23], skillsSplitRank[23]);
       }
   }

   /*
    * Calculates the XP difference in all scenarios
    * Calculates the percentage and the whole number needed to reach the next level
    */
    public void calculateXpDiff(String XP)
    {
        percent = 0.0;
        xpDiff = 0;
        for(int i = 0; i < expTable.length; i++)
        {
            int userXP = Integer.parseInt(XP);
            if(i == 0 && userXP < expTable[i])
            {
                percent = (double)userXP/expTable[i] * 100.0;
                xpDiff = expTable[i] - userXP;
                break;
            }
            else if(userXP<expTable[i])
            {
                double subt = (userXP - expTable[i-1]);
                double subtArr = expTable[i] - expTable[i-1];
                percent = (subt/subtArr) * 100.0;
                xpDiff = expTable[i] - userXP;
                break;
            }
            else if(i == expTable[expTable.length-1] && userXP>expTable[i])
            {
                percent = 0.0;
                xpDiff = 0;
                break;
            }
            else if(userXP>expTable[i])
            {
                continue;
            }
        }
    }

    public double getPercent()
    {
        return percent;
    }
    public int getXpDiff()
    {
        return xpDiff;
    }
   public boolean getStatus()
   {
       return playerFound;
   }


   /*
    * Below are the mutators and accessors for every single skill
    * This is needed in order to store and set each TextView properly according to the data parsed.
    */
    public void setAttack(String level, String XP, String rank)
    {
        attackXP = XP;
        attackRank = rank;
        attackLevel = level;
    }
    public void setStrength(String level, String XP, String rank)
    {
        strengthXP = XP;
        strengthRank = rank;
        strengthLevel = level;
    }
    public void setDefence(String level, String XP, String rank)
    {
        defenceXP = XP;
        defenceRank = rank;
        defenceLevel = level;
    }
    public void setRanged(String level, String XP, String rank)
    {
        rangedXP = XP;
        rangedRank = rank;
        rangedLevel = level;
    }
    public void setPrayer(String level, String XP, String rank)
    {
        prayerXP = XP;
        prayerRank = rank;
        prayerLevel = level;
    }
    public void setMagic(String level, String XP, String rank)
    {
        magicXP = XP;
        magicRank = rank;
        magicLevel = level;
    }
    public void setRunecraft(String level, String XP, String rank)
    {
        runecraftXP = XP;
        runecraftRank = rank;
        runecraftLevel = level;
    }
    public void setConstruction(String level, String XP, String rank)
    {
        constructionXP = XP;
        constructionRank = rank;
        constructionLevel = level;
    }
    public void setHitpoints(String level, String XP, String rank)
    {
        hitpointsXP = XP;
        hitpointsRank = rank;
        hitpointsLevel = level;
    }
    public void setAgility(String level, String XP, String rank)
    {
        agilityXP = XP;
        agilityRank = rank;
        agilityLevel = level;
    }
    public void setHerblore(String level, String XP, String rank)
    {
        herbloreXP = XP;
        herbloreRank = rank;
        herbloreLevel = level;
    }
    public void setThieving(String level, String XP, String rank)
    {
        thievingXP = XP;
        thievingRank = rank;
        thievingLevel = level;
    }
    public void setCrafting(String level, String XP, String rank)
    {
        craftingXP = XP;
        craftingRank = rank;
        craftingLevel = level;
    }
    public void setFletching(String level, String XP, String rank)
    {
        fletchingXP = XP;
        fletchingRank = rank;
        fletchingLevel = level;
    }
    public void setSlayer(String level, String XP, String rank)
    {
        slayerXP = XP;
        slayerRank = rank;
        slayerLevel = level;
    }
    public void setHunter(String level, String XP, String rank)
    {
        hunterXP = XP;
        hunterRank = rank;
        hunterLevel = level;
    }
    public void setMining(String level, String XP, String rank)
    {
        miningXP = XP;
        miningRank = rank;
        miningLevel = level;
    }
    public void setSmithing(String level, String XP, String rank)
    {
        smithingXP = XP;
        smithingRank = rank;
        smithingLevel = level;
    }
    public void setFishing(String level, String XP, String rank)
    {
        fishingXP = XP;
        fishingRank = rank;
        fishingLevel = level;
    }
    public void setCooking(String level, String XP, String rank)
    {
        cookingXP = XP;
        cookingRank = rank;
        cookingLevel = level;
    }
    public void setFiremaking(String level, String XP, String rank)
    {
        firemakingXP = XP;
        firemakingRank = rank;
        firemakingLevel = level;
    }
    public void setWoodcutting(String level, String XP, String rank)
    {
        woodcuttingXP = XP;
        woodcuttingRank = rank;
        woodcuttingLevel = level;
    }
    public void setFarming(String level, String XP, String rank)
    {
        farmingXP = XP;
        farmingRank = rank;
        farmingLevel = level;
    }


    //Accessors
    public String getTotalLevel()
    {
        return totalLevel;
    }
    public String getTotalLevelRank()
    {
        return totalLevelRank;
    }
    public String getTotalLevelXP()
    {
        return totalLevelXP;
    }

    public String getAttackXP() {
        return attackXP;
    }

    public String getAttackRank() {
        return attackRank;
    }

    public String getAttackLevel() {
        return attackLevel;
    }

    public String getStrengthXP() {
        return strengthXP;
    }

    public String getStrengthRank() {
        return strengthRank;
    }

    public String getStrengthLevel() {
        return strengthLevel;
    }

    public String getDefenceXP() {
        return defenceXP;
    }

    public String getDefenceRank() {
        return defenceRank;
    }

    public String getDefenceLevel() {
        return defenceLevel;
    }

    public String getRangedXP() {
        return rangedXP;
    }

    public String getRangedRank() {
        return rangedRank;
    }

    public String getRangedLevel() {
        return rangedLevel;
    }

    public String getPrayerXP() {
        return prayerXP;
    }

    public String getPrayerRank() {
        return prayerRank;
    }

    public String getPrayerLevel() {
        return prayerLevel;
    }

    public String getMagicXP() {
        return magicXP;
    }

    public String getMagicRank() {
        return magicRank;
    }

    public String getMagicLevel() {
        return magicLevel;
    }

    public String getRunecraftXP() {
        return runecraftXP;
    }

    public String getRunecraftRank() {
        return runecraftRank;
    }

    public String getRunecraftLevel() {
        return runecraftLevel;
    }

    public String getConstructionXP() {
        return constructionXP;
    }

    public String getConstructionRank() {
        return constructionRank;
    }

    public String getConstructionLevel() {
        return constructionLevel;
    }

    public String getHitpointsXP() {
        return hitpointsXP;
    }

    public String getHitpointsRank() {
        return hitpointsRank;
    }

    public String getHitpointsLevel() {
        return hitpointsLevel;
    }

    public String getAgilityXP() {
        return agilityXP;
    }

    public String getAgilityRank() {
        return agilityRank;
    }

    public String getAgilityLevel() {
        return agilityLevel;
    }

    public String getHerbloreXP() {
        return herbloreXP;
    }

    public String getHerbloreRank() {
        return herbloreRank;
    }

    public String getHerbloreLevel() {
        return herbloreLevel;
    }

    public String getThievingXP() {
        return thievingXP;
    }

    public String getThievingRank() {
        return thievingRank;
    }

    public String getThievingLevel() {
        return thievingLevel;
    }

    public String getCraftingXP() {
        return craftingXP;
    }

    public String getCraftingRank() {
        return craftingRank;
    }

    public String getCraftingLevel() {
        return craftingLevel;
    }

    public String getFletchingXP() {
        return fletchingXP;
    }

    public String getFletchingRank() {
        return fletchingRank;
    }

    public String getFletchingLevel() {
        return fletchingLevel;
    }

    public String getSlayerXP() {
        return slayerXP;
    }

    public String getSlayerRank() {
        return slayerRank;
    }

    public String getSlayerLevel() {
        return slayerLevel;
    }

    public String getHunterXP() {
        return hunterXP;
    }

    public String getHunterRank() {
        return hunterRank;
    }

    public String getHunterLevel() {
        return hunterLevel;
    }

    public String getMiningXP() {
        return miningXP;
    }

    public String getMiningRank() {
        return miningRank;
    }

    public String getMiningLevel() {
        return miningLevel;
    }

    public String getSmithingXP() {
        return smithingXP;
    }

    public String getSmithingRank() {
        return smithingRank;
    }

    public String getSmithingLevel() {
        return smithingLevel;
    }

    public String getFishingXP() {
        return fishingXP;
    }

    public String getFishingRank() {
        return fishingRank;
    }

    public String getFishingLevel() {
        return fishingLevel;
    }

    public String getCookingXP() {
        return cookingXP;
    }

    public String getCookingRank() {
        return cookingRank;
    }

    public String getCookingLevel() {
        return cookingLevel;
    }

    public String getFiremakingXP() {
        return firemakingXP;
    }

    public String getFiremakingRank() {
        return firemakingRank;
    }

    public String getFiremakingLevel() {
        return firemakingLevel;
    }

    public String getWoodcuttingXP() {
        return woodcuttingXP;
    }

    public String getWoodcuttingRank() {
        return woodcuttingRank;
    }

    public String getWoodcuttingLevel() {
        return woodcuttingLevel;
    }

    public String getFarmingXP() {
        return farmingXP;
    }

    public String getFarmingRank() {
        return farmingRank;
    }

    public String getFarmingLevel() {
        return farmingLevel;
    }
}
