
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FileRenderer implements ListCellRenderer
{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        System.out.println(value);
        
        JLabel l = new JLabel(value.toString());
        l.setOpaque(true);
        

        l.setFont(new Font ("Courier New", Font.PLAIN , 11));
        Component c = l; 
        
        if(isSelected)
            c.setBackground(Color.lightGray);
        else
            c.setBackground(Color.white);
        
        return c;
    }


    
}
