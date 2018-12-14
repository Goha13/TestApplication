package securitysystem.ico.kz.myapplication;

import android.content.Context;
import android.net.NetworkInfo;

public class ConnectivityManager {
    public static boolean isNetworkAvailable(Context context) {
        boolean networkavailable = false;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

            if (connectivityManager != null && activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                networkavailable = true;
            } else {
                networkavailable = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return networkavailable;
    }
}
