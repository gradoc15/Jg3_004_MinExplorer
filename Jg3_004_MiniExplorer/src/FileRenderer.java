
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class FileRenderer implements ListCellRenderer
{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        
        
        JLabel l = new JLabel(value.toString());
        l.setOpaque(true);
        

        l.setFont(new Font ("Courier New", Font.PLAIN , 11));
        
       
        
        if(((Datei)value).isDirectory())
        {
           l.setForeground(Color.red);
           l.setBackground(new Color(Color.GRAY.getRed(), Color.GRAY.getGreen(), Color.GRAY.getBlue(), 150));
        }
        else
        {
            l.setForeground(Color.blue);
            l.setBackground(new Color(Color.lightGray.getRed(), Color.lightGray.getGreen(), Color.lightGray.getBlue(), 200));
        }
        
        Component c = l; 
        
        return c;
    }


    
}
