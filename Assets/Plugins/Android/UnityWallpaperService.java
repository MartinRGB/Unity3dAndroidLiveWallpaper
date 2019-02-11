package ulw.ulw.ulw;
import android.content.res.Configuration;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;

public class UnityWallpaperService extends WallpaperService
{

    public void onCreate() {
        super.onCreate();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        App.mUnityPlayer.configurationChanged(configuration);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        App.mUnityPlayer.lowMemory();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i == 15) {
            App.mUnityPlayer.lowMemory();
        }
    }
    public Engine onCreateEngine() {
        return new UnityWallpaperEngine();
    }

    private class UnityWallpaperEngine extends Engine
    {

        public void onTouchEvent(MotionEvent motionEvent) {
            App.mUnityPlayer.injectEvent(motionEvent);
        }

        public void onVisibilityChanged(boolean z) {
            super.onVisibilityChanged(z);


            if(isPreview() && WallpaperUtility.isULWActive(getApplicationContext())) App.PS = z;

            if (z) {
                    App.mUnityPlayer.pause();
                    App.mUnityPlayer.displayChanged(0, getSurfaceHolder().getSurface());
                    App.mUnityPlayer.resume();
            }
            else
            {
                if(!App.ACT == true)
                {
                    if(!App.PS)
                    {
                        App.mUnityPlayer.pause();
                    }
                    App.PS = false;
                }
            }
            App.mUnityPlayer.windowFocusChanged(z);
        }
    }
}