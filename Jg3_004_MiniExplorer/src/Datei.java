
import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Datei extends File
{
    private File path;
    private int help = 0;
    
    public Datei(String pathname, File f)
    {
        super(pathname);
        path = f;
    }
    
    public Datei(String pathname, File f, boolean b)
    {
        super(pathname);
        path = f;
        help = 1;
    }
    
    public Datei(String pathname)
    {
        super(pathname);
        path = new File(pathname);
        help = 1;
    }
    
   
    
    public String toString()
    {
        System.out.println(help);
        if(help == 1)
            return "..";
        else if(this.isDirectory())
            return this.getName();
        else
        {
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.lastModified()), ZoneId.systemDefault());
            System.out.println(date);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy h:m");
            
            long mem = this.length()/1000;
            
            if(mem < 1)
                mem = 1;
            
            return String.format("%-15s %20s %5sKB RWX",this.getName(),date.format(dtf),""+mem);
            
        }
    }
    

    
}
