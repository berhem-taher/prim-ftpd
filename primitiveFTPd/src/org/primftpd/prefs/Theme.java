package org.primftpd.prefs;

import android.content.Context;
import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatDelegate;

public class Theme
{
    public static Boolean isDark(Context context){
        int uiMode = context.getResources().getConfiguration().uiMode;
        int currentNightMode = uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES;
    }

    public static int byString(String themeStr) {
		switch (themeStr) {
			case "system":
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P){
					return AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
				}else{
					return AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY;
				}
			case "dark":
				return AppCompatDelegate.MODE_NIGHT_YES;
			case "light":	
				return AppCompatDelegate.MODE_NIGHT_NO;
		}
		return AppCompatDelegate.MODE_NIGHT_YES;
	}
}