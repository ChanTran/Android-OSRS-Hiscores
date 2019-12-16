package com.example.chan.osrshighscores;

/**
 * Created by Chan on 11/30/2017.
 */

public class Notes {
    private String body;
    private String subject;
    private int id;
    private boolean marked = false;


    /*
    * A note consists of a subject, body, and an autoincrementing id, and a flag
     */
    public Notes(String subject, String body, int id)
    {
        this.subject = subject;
        this.body = body;
        this.id = id;
    }

    public Notes(String subject, String body, int id, int flag)
    {
        this.subject = subject;
        this.body = body;
        this.id = id;
        if(flag == 0)
        {
            marked = false;
        }
        if(flag == 1)
        {
            marked = true;
        }
    }

    public Notes()
    {
        body = "";
        subject = "";
        id = 0;
    }

    public void setMarked(int flag)
    {
        if(flag == 0)
        {
            marked = false;
        }
        if(flag == 1)
        {
            marked = true;
        }
    }
    public boolean getMarked()
    {
        return marked;
    }
    public void setSubject(String sub)
    {
        subject = sub;
    }
    public void setBody(String body)
    {
        this.body = body;
    }
    public void setID(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }
    public String getSubject()
    {
        return subject;
    }
    public String getBody()
    {
        return body;
    }

}
