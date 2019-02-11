package ulw.ulw.ulw;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.unity3d.player.UnityPlayer;

public class App extends Application
{

    public static boolean PS;
    public static boolean ACT = false;

    public static UnityPlayer mUnityPlayer;

    private static App instance;

    public App() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }



    @Override
    public void onCreate()
    {
        super.onCreate();
        if (mUnityPlayer == null)
        {
            mUnityPlayer = new UnityPlayer(getContext());
            mUnityPlayer.requestFocus();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mUnityPlayer.configurationChanged(newConfig);
    }
}
