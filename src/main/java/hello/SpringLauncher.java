package hello;/**
 * Created by vincentvu on 1/26/2017.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class SpringLauncher {
    public static void main(String[] args) {
        ApplicationContext AC = new ClassPathXmlApplicationContext("");
        MyJFrame frame = AC.getBean(MyJFrame.class);
        frame.init();

    }
}
