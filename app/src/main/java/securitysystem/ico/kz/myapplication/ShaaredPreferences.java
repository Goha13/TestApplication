package securitysystem.ico.kz.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ShaaredPreferences {
    Context context;
    SharedPreferences sharedPreferences;
    public ShaaredPreferences(Context context) {
        this.context=context;
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
    }
    public void save(String key, String value)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public String load(String key)
    {
        String value = sharedPreferences.getString(key,"");
        return value;
    }
}
