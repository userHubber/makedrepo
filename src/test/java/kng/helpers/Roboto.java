package kng.helpers;

import java.awt.AWTException;
import java.awt.Robot;

public class Roboto {

   public  Robot rob;

    public Roboto() {
        try {
            rob = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
}
