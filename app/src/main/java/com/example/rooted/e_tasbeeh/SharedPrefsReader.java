package com.example.rooted.e_tasbeeh;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;


public class SharedPrefsReader {

    SharedPreferences mySharedPreferences = null;

    String t;
    Boolean b1;
    Boolean b2;
    Boolean b3;
    public static int num=0;

    public SharedPrefsReader(SharedPreferences mySharedPreferences) {
        this.mySharedPreferences = mySharedPreferences;




    }

    public float getRating()
    {

return mySharedPreferences.getFloat("rating",0);
    }


    public String PrayerTimeAlarm(String p)
    {
        String prayer="";
        switch (p){
            case "fajrr":
               prayer= mySharedPreferences.getString("fajrr","");
                break;
            case "duhrr":
                prayer= mySharedPreferences.getString("duhrr","");
                break;
            case "ashrr":
                prayer= mySharedPreferences.getString("ashrr","");

            break;
            case "maghribb":
                prayer= mySharedPreferences.getString("maghribb","");
                break;
            case "eshaa":
                prayer=mySharedPreferences.getString("eshaa","");
                break;


        }
        return prayer;

    }


public boolean enableNight()
{
    return mySharedPreferences.getBoolean("night",false);
}
    public boolean canPlaySound()
    {
        b1=mySharedPreferences.getBoolean("tapsound",true);

        return b1;

    }
    public boolean canVibrate()
    {
        b2=mySharedPreferences.getBoolean("vibrate",false);

        return b2;

    }
    public boolean cansendNotif()
    {
        b3=mySharedPreferences.getBoolean("notification",false);

        return b3;

    }
    public String activatePrayerAlarm()
    {
       return mySharedPreferences.getString("prayerAlarmDay","null");
    }
    public Typeface getTextStyle(Context context)
    {
        t= mySharedPreferences.getString("style","no");

        Typeface typeface = ResourcesCompat.getFont(context, R.font.helvitecia);

        switch (t)
        {
            case "default":

                typeface = ResourcesCompat.getFont(context, R.font.helvitecia);
                num=1;
                break;
            case "Style1":

                typeface = ResourcesCompat.getFont(context, R.font.helvetica);
                num=2;
                break;
            case "Style2":
                typeface = ResourcesCompat.getFont(context, R.font.font2);
                num=3;
                break;
            case "Style3":
                typeface = ResourcesCompat.getFont(context, R.font.osr);

                num=4;
                break;
            case "Style4":
                typeface = ResourcesCompat.getFont(context, R.font.font4);
                num=5;
                break;
            case "Style5":
                typeface = ResourcesCompat.getFont(context, R.font.font10);
                num=6;
                break;
            case "Style6":
                typeface = ResourcesCompat.getFont(context, R.font.font6);
                num=7;
                break;
            case "Style7":
                typeface = ResourcesCompat.getFont(context, R.font.font3);
                num=8;
                break;
            case "Style8":
                typeface = ResourcesCompat.getFont(context, R.font.font8);
                num=9;
                break;
            case "Style9":
                typeface = ResourcesCompat.getFont(context, R.font.font9);
                num=10;
                break;
            case "Style10":
                typeface = ResourcesCompat.getFont(context, R.font.osb);
                num=11;
                break;
                default:
                    typeface = ResourcesCompat.getFont(context, R.font.helvitecia);
                    break;






        }

        return typeface;

    }






}
