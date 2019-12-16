package com.example.chan.osrshighscores;

/**
 * Created by Chan on 12/3/2017.
 */

public class PlayerCompare {

    private String levelDiff;

    public PlayerCompare()
    {
    }


    /*
    * This method will compare the levels of two players by taking in two strings and parsing them as Integers
     */
    public String comparePlayersLevel(String levelOne, String levelTwo)
    {
        if(Integer.parseInt(levelOne) == -1)
        {
            levelDiff = String.valueOf(1 - Integer.parseInt(levelTwo));
        }
        else if (Integer.parseInt(levelTwo) == -1){
            levelDiff = String.valueOf(Integer.parseInt(levelOne) - 1);
        }
        else
        {
            levelDiff = String.valueOf(Integer.parseInt(levelOne) - Integer.parseInt(levelTwo));
        }
        if(Integer.parseInt(levelDiff)>0)
        {
            return "+" + levelDiff;
        }
        return levelDiff;
    }

    public String getLevelDiff()
    {
        return levelDiff;
    }

}
