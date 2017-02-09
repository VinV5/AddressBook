package hello;/**
 * Created by vincentvu on 1/26/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MyJFrame extends JFrame{

    MyJPanel panel;

    @Autowired
    public void setPanel(MyJPanel panel){
        this.panel = panel;
    }

    public void init() {

        this.add(panel);
        setSize(new Dimension(1000, 1000));
        setVisible(true);

    }
}


