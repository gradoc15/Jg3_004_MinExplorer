
import java.io.File;

public class Datei extends File
{
    private File path;
    
    public Datei(String pathname, File f)
    {
        super(pathname);
        path = f;
    }
    

    
}
