package hello;/**
 * Created by vincentvu on 1/26/2017.
 */

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;


public class MyJPanel extends JPanel {
    private List panelComponents;

    public MyJPanel(){
        setLayout(new GridLayout(0,2));
    }

    public void setPanelComponents(List panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void init() {
        for (Iterator iter = panelComponents.iterator(); iter.hasNext(); ) {
            Component component = (Component) iter.next();
            add(component);
        }
    }
}
