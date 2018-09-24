
import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DateiModell extends AbstractListModel
{
    private ArrayList<Datei> data = new ArrayList();
    
    public void add()
    {
        
        File f = new File(System.getProperty("user.dir"));
        System.out.println(f);
        File[] fileArray = f.listFiles();
        
        for(int i = 0; i < fileArray.length; i++)
        {
            data.add(new Datei(fileArray[i].getName()));
        }
        
        fireIntervalAdded(data, 0, data.size()-1);
    }
    
    @Override
    public int getSize()
    {
        return data.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return data.get(index);
    }
    
}
