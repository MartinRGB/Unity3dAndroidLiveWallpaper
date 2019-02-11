package ulw.ulw.ulw;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import java.io.IOException;

public class WallpaperUtility
{


    static boolean isULWActive(Context context) {
        boolean isSelfActive = false;
        WallpaperManager wpm = WallpaperManager.getInstance(context);
        WallpaperInfo info = wpm.getWallpaperInfo();

        if (info != null && info.getPackageName().equals(context.getPackageName())) {
            isSelfActive = true;
        }

        return isSelfActive;
    }


    static void StopWallpaperService(Context context) {
        WallpaperManager wpm = WallpaperManager.getInstance(context);
        try {
            wpm.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


//    public static void ResetServices() {
//
//        if (WallpaperUtility.isULWActive(selfActivity.getApplicationContext())) {
//            Log.d(LogCatDebugTag, "We're already running");
//            // Still might be a preview, but the user is already running your LWP.
//        } else {
//            Log.d(LogCatDebugTag, "We're not running, this should be a preview");
//            // Should definitely be a preview.
//        }
//    }