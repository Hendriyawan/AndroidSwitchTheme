package com.gdev.theme.switchbutton;
import android.support.v7.app.AppCompatActivity;
import android.content.*;
import android.preference.*;
/*13.09.2017 by Hendriyawan © GDEV*/
public class ThemeUtils
{
	private static SharedPreferences pref;
	private static SharedPreferences.Editor editor;
	
	//createTheme
	public static void createTheme(Context context)
	{
		pref = PreferenceManager.getDefaultSharedPreferences(context);
		boolean theme = pref.getBoolean("theme_app", false);
		if(theme)
		{
			context.setTheme(R.style.ThemeDark);
		}
		else {
			context.setTheme(R.style.ThemeLight);
		}
	}
	//getCheckedTheme
	public static boolean getCheckedTheme(Context context)
	{
		pref = PreferenceManager.getDefaultSharedPreferences(context);
		return pref.getBoolean("theme_app", false);
	}
	//setTheme
	public static void setTheme(AppCompatActivity activity, boolean theme)
	{
		pref = PreferenceManager.getDefaultSharedPreferences(activity);
		editor = pref.edit();
		editor.putBoolean("theme_app", theme);
		editor.apply();
		
		//refresh Activity
		activity.finish();
		activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		activity.startActivity(new Intent(activity, activity.getClass()));
	}
}