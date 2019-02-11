package ulw.ulw.ulw;
public class Wrapper
{
    private static Wrapper _instance;


    Wrapper()
    {
    }


    public void Start()
    {
        
    }

    public static Wrapper instance()
    {
        if(_instance == null)
        {
            _instance = new Wrapper();
        }

        return _instance;
    }


}
