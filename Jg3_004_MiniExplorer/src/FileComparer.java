
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FileComparer implements Comparator<Datei>
{

    @Override
    public int compare(Datei o1, Datei o2)
    {
        
       if(o1.isDirectory() && !o2.isDirectory())
           return -1;
       else if(!o1.isDirectory() && o2.isDirectory())
           return 1;
       else 
           return 0;
    }

    
}
