package org.mortbay.ijetty.log;

import org.eclipse.jetty.util.log.Logger;

import android.util.Log;

public class AndroidLog implements Logger
{
    public static final String __JETTY_TAG = "Jetty";
    public static boolean __isIgnoredEnabled = false;
    public String _name;
    



    public AndroidLog()
    {
        this ("org.mortbay.ijetty.AndroidLog");
    }
    
    public AndroidLog(String name)
    {     
        _name = name;
    }

    public String getName ()
    {
         return  _name;
    }


    public void debug(Throwable th)
    {
        if (Log.isLoggable(__JETTY_TAG, Log.DEBUG))
        {
            Log.d(__JETTY_TAG, "", th);
        }
    }
    
    public void debug(String msg, Throwable th)
    {
        if (Log.isLoggable(__JETTY_TAG, Log.DEBUG))
        {
            Log.d(__JETTY_TAG, msg, th);
        }
    }

    public void debug(String msg, Object... args)
    {
        if (Log.isLoggable(__JETTY_TAG, Log.DEBUG)) 
        {            
            Log.d(__JETTY_TAG, msg);
        }
    }

    public Logger getLogger(String name)
    {
       return new AndroidLog(name);
    }

    public void info(String msg, Object... args)
    {
        Log.i(__JETTY_TAG, msg);
    }

    public void info(Throwable th)
    {
        Log.i(__JETTY_TAG, "", th);
    }

    public void info(String msg, Throwable th)
    {
        Log.i(__JETTY_TAG, msg, th);
    }

    public boolean isDebugEnabled()
    {
        return Log.isLoggable(__JETTY_TAG, Log.DEBUG);
    }

    public void warn(Throwable th)
    {
        if (Log.isLoggable(__JETTY_TAG, Log.WARN))
            Log.e(__JETTY_TAG, "", th);
    }

    public void warn(String msg, Object... args)
    { 
        if (Log.isLoggable(__JETTY_TAG, Log.WARN))
            Log.w(__JETTY_TAG, msg);
    }

    public void warn(String msg, Throwable th)
    {  
        if (Log.isLoggable(__JETTY_TAG, Log.ERROR))
            Log.e(__JETTY_TAG, msg, th);
    }

    public boolean isIgnoredEnabled ()
    {
        return __isIgnoredEnabled;
    }


    public void ignore(Throwable ignored)
    {
       if (__isIgnoredEnabled)
           Log.w(__JETTY_TAG, "IGNORED", ignored);
    }

    public void setIgnoredEnabled(boolean enabled)
    {
        __isIgnoredEnabled = enabled;
    }

    public void setDebugEnabled(boolean enabled)
    {
        
    }
}