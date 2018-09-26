
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
    public DateiModell()
    {
        ini();
    }
    
    private ArrayList<Datei> data = new ArrayList();
    
    private File actualPath;
    
    public void ini()
    {
        actualPath = new File(System.getProperty("user.dir"));
    }
    
    public  void changePath(int idx)
    {
       actualPath = new File(data.get(idx).getAbsolutePath());
        System.out.println("path changed --> "+actualPath.getAbsolutePath());
    }
    
    public void showAll()
    {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        for(Datei d : data)
        {
            System.out.println(d.getAbsolutePath());
        }
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
    
    
    public void add()
    {
          data.clear();
          
          File[] fileArray = actualPath.listFiles();
          File x = null;
          
          try
          {
              data.add(new Datei(actualPath.getParent(), actualPath.getParentFile(), true));
          }
          catch(Exception e)
          {
              if(actualPath.getAbsolutePath().equals("C:\\"))
                  actualPath = new File("D:\\");
              else if(actualPath.getAbsolutePath().equals("D:\\"))
                  actualPath =  new File("C:\\");
              
              data.add(new Datei(actualPath.getAbsolutePath(), new File(actualPath.getAbsolutePath()), true));
          }
          
          
          for(int i = 0; i < fileArray.length; i++)
          {
              data.add(new Datei(fileArray[i].getAbsolutePath(), fileArray[i]));
              System.out.println(fileArray[i].getAbsolutePath());
              
              x = fileArray[i];
          }
          System.out.println("++");
          System.out.println(actualPath.getAbsolutePath());
          System.out.println(actualPath.getParent());
          
          fireContentsChanged(data, 0, data.size()-1);

        sort();
    }
    
    public void sort()
    {
        Collections.sort(data, new FileComparer());
        fireContentsChanged(data, 0, data.size()-1);
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
    
    public String getActPath()
    {
        return actualPath.getAbsolutePath();
    }
    
}
