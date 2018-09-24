
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Datei extends File
{
    private File path;
    
    public Datei(String pathname, File f)
    {
        super(pathname);
        path = f;
    }
    
    public String toString()
    {
        if(this.isDirectory())
            return this.getName();
        else
        {
            LocalDateTime ldt = LocalDateTime.ofEpochSecond(this.lastModified(), 0, ZoneOffset.UTC);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("e.M.yyyy ss:mm");
            return ldt.format(dtf);
            
        }
    }
    

    
}
