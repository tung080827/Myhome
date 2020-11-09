package com.tung080827.myhome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Internet extends BroadcastReceiver
{
    @Override
    public void onReceive(final Context context, Intent intent)
    {
        if (intent.getAction().equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE"))
        {
            if(isInternet(context))
            {
                // Your Code
            }
        }
    }

    public boolean isInternet(Context context)
    {
        ConnectivityManager IM = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = IM.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
