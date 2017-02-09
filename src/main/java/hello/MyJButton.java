package hello;/**
 * Created by vincentvu on 1/26/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import javax.swing.JButton;


public class MyJButton extends JButton {
    private ActionListener actionListener;

    @Autowired
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void init() {
        this.addActionListener(actionListener);
    }
}
