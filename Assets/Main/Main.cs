using UnityEngine;
using UnityEngine.UI;
using System;
public class Main : MonoBehaviour
{
    private AndroidJavaClass activityClass;
    private AndroidJavaClass wrapperClass;
    private AndroidJavaObject wrapperObject;

    private string activity = "ulw.ulw.ulw.UnityPlayerActivity";
    private string wrapper = "ulw.ulw.ulw.Wrapper";

    // Start is called before the first frame update
    void Start()
    {
        activityClass = new AndroidJavaClass(activity);
        wrapperClass = new AndroidJavaClass(wrapper);
        wrapperObject = wrapperClass.CallStatic<AndroidJavaObject>("instance");

    }

    public void StartWallpaperService()
    {
        activityClass.CallStatic("StartService");
    }


    public void Wrapper()
    {
        wrapperObject.Call("Start");
    }
}
