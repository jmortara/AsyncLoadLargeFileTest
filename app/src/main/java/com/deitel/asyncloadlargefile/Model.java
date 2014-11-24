package com.deitel.asyncloadlargefile;

import java.util.HashMap;

/**
 * Created by jason on 11/15/2014. Adding test comment.
 */
public class Model
{
    public static HashMap<String, String> globalDict;

    public static void setGlobalDict( HashMap<String, String> dict )
    {
        if ( globalDict == null )
        {
            globalDict = new HashMap<String, String>(dict); // creates a shallow copy
        }
    }
}
