// This program allows users to customize a lunchbox. 
// They can select different lunchbox sizes by choosing a size from the scrollpane.
// They can customize their lunchbox color by clicking "Choose a color" 
// and then choosing a color from a color picker dialog. 
// They can then add food to their lunchbox by clicking the buttons that have the names of the food. 
// Once a button is clicked, the food that has its name on the button will show up in the lunchbox. 
// They can also “fill up” their water bottle using a slider
// and adding a nametag on the bottle by typing in the textfield and clicking "add".
// If they don't like their choice of food or they would like to give it another try,
// they can click "Restart" and everything will be back to its default setting.

package LunchBoxCustomizer;

import java.awt.*;
import javax.swing.*;

public class RunApp {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new RunApp();
         }
      });
   }

   public RunApp() {
      JFrame myFrame = new JFrame("My LunchBox");
      myFrame.setSize(1500, 800);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.add(new LunchBox());
      myFrame.setVisible(true);
   }
}