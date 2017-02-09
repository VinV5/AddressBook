package hello;/**
 * Created by vincentvu on 1/26/2017.
 */
import org.springframework.stereotype.*;

import javax.swing.JLabel;
import java.awt.*;

public class MyJLabel extends JLabel{
    public MyJLabel(String name){
        setText(name);
    }
}
