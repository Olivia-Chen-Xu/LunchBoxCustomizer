// This file provides the design of the app
//is required by RunApp.java

package LunchBoxCustomizer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import javax.swing.JColorChooser.*;
import java.awt.Polygon.*;

class LunchBox extends JPanel implements ListSelectionListener, ActionListener, ChangeListener {
   JList<String> allSizes;
   JLabel sizeLabel, defaultLabel, colorLabel, vegfruLabel, carbLabel, proLabel, snacLabel, watLabel, nameLabel;
   JScrollPane sizeScroll;
   String sizes[];
   int sizeIndex = 1;
   int boxWidth = 600;
   int boxHeight = 600;
   Color chosenColor = Color.WHITE;
   JColorChooser boxColor;
   JDialog colorChooserWindow;
   JSlider waterLevel;
   int waterHeight = 0;

   JButton broccoli, spinach, pea, carrot, cucumber, strawberry, blueberry, cherry;
   JButton macandcheese, spaghetti, bread, rice, tortilla;
   JButton egg, cheese, chickpea, bean, saussage, tofu;
   JButton chocolate, cookie, cracker, cupcake;
   JButton chooseColor, addName, restart;

   int broccoliNum, spinachNum, peaNum, carrotNum, cucumberNum, strawberryNum, blueberryNum, cherryNum;
   int macandcheeseNum, spaghettiNum, breadNum, riceNum, tortillaNum;
   int eggNum, cheeseNum, chickpeaNum, beanNum, saussageNum, tofuNum;
   int chocolateNum, cookieNum, crackerNum, cupcakeNum;

   JTextField nameTag;
   String name = "";

   public LunchBox() {
      setLayout(null);
      setBackground(new Color(255, 255, 240));

      setUpLunchBox();
      setUpVegAndFruMenu();
      setUpCarbMenu();
      setUpProMenu();
      setUpSnacMenu();
      setUpWaterBottle();
      clearLunchBox();

      restart = new JButton("Restart");
      restart.addActionListener(this);
      restart.setBounds(50, 690, 80, 40);
      add(restart);

   }

   public void valueChanged(ListSelectionEvent le) {
      sizeIndex = allSizes.getSelectedIndex();

      if (sizeIndex != -1) {
         sizeLabel.setText("Lunchbox Size: " + sizes[sizeIndex]);
         if (sizeIndex == 2) {
            this.boxWidth = 500;
            this.boxHeight = 500;
         } else if (sizeIndex == 1) {
            this.boxWidth = 600;
            this.boxHeight = 600;
         } else if (sizeIndex == 0) {
            this.boxWidth = 700;
            this.boxHeight = 700;
         }
      } else
         sizeLabel.setText("Pick a lunchbox size: ");
      repaint();
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Choose a color")) {
         colorChooserWindow = new JDialog();
         colorChooserWindow.add(boxColor);
         colorChooserWindow.setSize(600, 400);
         colorChooserWindow.setVisible(true);
      }
      if (e.getActionCommand().equals("Add")) {
         this.name = nameTag.getText();
      }

      if (e.getActionCommand().equals("Broccoli"))
         broccoliNum++;
      else if (e.getActionCommand().equals("Spinach"))
         spinachNum++;
      else if (e.getActionCommand().equals("Pea"))
         peaNum++;
      else if (e.getActionCommand().equals("Carrot"))
         carrotNum++;
      else if (e.getActionCommand().equals("Cucumber"))
         cucumberNum++;
      else if (e.getActionCommand().equals("Strawberry"))
         strawberryNum++;
      else if (e.getActionCommand().equals("Blueberry"))
         blueberryNum++;
      else if (e.getActionCommand().equals("Cherry"))
         cherryNum++;
      else if (e.getActionCommand().equals("Mac & Cheese"))
         macandcheeseNum++;
      else if (e.getActionCommand().equals("Spaghetti"))
         spaghettiNum++;
      else if (e.getActionCommand().equals("Bread"))
         breadNum++;
      else if (e.getActionCommand().equals("Rice"))
         riceNum++;
      else if (e.getActionCommand().equals("Tortilla"))
         tortillaNum++;
      else if (e.getActionCommand().equals("Egg"))
         eggNum++;
      else if (e.getActionCommand().equals("Cheese"))
         cheeseNum++;
      else if (e.getActionCommand().equals("Chickpea"))
         chickpeaNum++;
      else if (e.getActionCommand().equals("Bean"))
         beanNum++;
      else if (e.getActionCommand().equals("Saussage"))
         saussageNum++;
      else if (e.getActionCommand().equals("Tofu"))
         tofuNum++;
      else if (e.getActionCommand().equals("Chocolate"))
         chocolateNum++;
      else if (e.getActionCommand().equals("Cookie"))
         cookieNum++;
      else if (e.getActionCommand().equals("Cracker"))
         crackerNum++;
      else if (e.getActionCommand().equals("Cupcake"))
         cupcakeNum++;

      if (e.getActionCommand().equals("Restart")) {
         clearLunchBox();
      }
      repaint();
   }

   public void stateChanged(ChangeEvent e) {
      this.waterHeight = waterLevel.getValue();
      this.chosenColor = boxColor.getColor();
      repaint();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 40));
      g.drawString("Lunchbox Customizer", 900, 760);

      fillWater(g2d, this.waterHeight);
      drawBottle(g2d);
      addNameTag(g2d, this.name);
      drawBox(g2d, boxWidth, boxHeight, chosenColor);

      drawBroccoli(g2d, broccoliNum);
      drawSpinach(g2d, spinachNum);
      drawPea(g2d, peaNum);
      drawCarrot(g2d, carrotNum);
      drawCucumber(g2d, cucumberNum);
      drawStrawberry(g2d, strawberryNum);
      drawBlueberry(g2d, blueberryNum);
      drawCherry(g2d, cherryNum);
      drawMacAndCheese(g2d, macandcheeseNum);
      drawSpaghetti(g2d, spaghettiNum);
      drawBread(g2d, breadNum);
      drawRice(g2d, riceNum);
      drawTortilla(g2d, tortillaNum);
      drawEgg(g2d, eggNum);
      drawCheese(g2d, cheeseNum);
      drawChickpea(g2d, chickpeaNum);
      drawBean(g2d, beanNum);
      drawSaussage(g2d, saussageNum);
      drawTofu(g2d, tofuNum);
      drawChocolate(g2d, chocolateNum);
      drawCookie(g2d, cookieNum);
      drawCracker(g2d, crackerNum);
      drawCupcake(g2d, cupcakeNum);
   }

   private void setUpLunchBox() {
      sizes = new String[] { "Large", "Medium", "Small" };
      allSizes = new JList<String>(sizes);
      allSizes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      allSizes.addListSelectionListener(this);

      sizeScroll = new JScrollPane(allSizes);
      sizeLabel = new JLabel("Pick a lunchbox size: ");
      defaultLabel = new JLabel("(Default: Medium)");
      colorLabel = new JLabel("Pick a lunchbox color: ");

      chooseColor = new JButton("Choose a color");
      chooseColor.addActionListener(this);
      boxColor = new JColorChooser();
      boxColor.getSelectionModel().addChangeListener(this);
      boxColor.setBorder(BorderFactory.createTitledBorder("Choose Lunchbox Color"));

      sizeLabel.setBounds(10, 30, 200, 30);
      add(sizeLabel);
      defaultLabel.setBounds(20, 50, 150, 30);
      add(defaultLabel);
      sizeScroll.setBounds(175, 20, 80, 60);
      add(sizeScroll);
      colorLabel.setBounds(10, 100, 200, 30);
      add(colorLabel);
      chooseColor.setBounds(150, 100, 150, 30);
      add(chooseColor);

   }

   private void setUpVegAndFruMenu() {
      vegfruLabel = new JLabel("Add vegetables and fruits by clicking the buttons");
      broccoli = new JButton("Broccoli");
      spinach = new JButton("Spinach");
      pea = new JButton("Pea");
      carrot = new JButton("Carrot");
      cucumber = new JButton("Cucumber");
      strawberry = new JButton("Strawberry");
      blueberry = new JButton("Blueberry");
      cherry = new JButton("Cherry");

      broccoli.addActionListener(this);
      spinach.addActionListener(this);
      pea.addActionListener(this);
      carrot.addActionListener(this);
      cucumber.addActionListener(this);
      strawberry.addActionListener(this);
      blueberry.addActionListener(this);
      cherry.addActionListener(this);

      vegfruLabel.setBounds(10, 150, 400, 20);
      add(vegfruLabel);
      broccoli.setBounds(10, 180, 80, 30);
      add(broccoli);
      spinach.setBounds(100, 180, 80, 30);
      add(spinach);
      pea.setBounds(190, 180, 80, 30);
      add(pea);
      cucumber.setBounds(10, 215, 120, 30);
      add(cucumber);
      strawberry.setBounds(135, 215, 150, 30);
      add(strawberry);
      blueberry.setBounds(10, 250, 120, 30);
      add(blueberry);
      cherry.setBounds(135, 250, 80, 30);
      add(cherry);
      carrot.setBounds(220, 250, 80, 30);
      add(carrot);
   }

   private void setUpCarbMenu() {
      carbLabel = new JLabel("Add carbs by clicking the buttons:");
      macandcheese = new JButton("Mac & Cheese");
      spaghetti = new JButton("Spaghetti");
      bread = new JButton("Bread");
      rice = new JButton("Rice");
      tortilla = new JButton("Tortilla");

      macandcheese.addActionListener(this);
      spaghetti.addActionListener(this);
      bread.addActionListener(this);
      rice.addActionListener(this);
      tortilla.addActionListener(this);

      carbLabel.setBounds(10, 290, 400, 20);
      add(carbLabel);
      macandcheese.setBounds(10, 320, 120, 30);
      add(macandcheese);
      spaghetti.setBounds(135, 320, 100, 30);
      add(spaghetti);
      bread.setBounds(10, 355, 80, 30);
      add(bread);
      rice.setBounds(95, 355, 60, 30);
      add(rice);
      tortilla.setBounds(160, 355, 100, 30);
      add(tortilla);
   }

   private void setUpProMenu() {
      proLabel = new JLabel("Add proteins by clicking the buttons");
      egg = new JButton("Egg");
      cheese = new JButton("Cheese");
      chickpea = new JButton("Chickpea");
      bean = new JButton("Bean");
      saussage = new JButton("Saussage");
      tofu = new JButton("Tofu");

      egg.addActionListener(this);
      cheese.addActionListener(this);
      chickpea.addActionListener(this);
      bean.addActionListener(this);
      saussage.addActionListener(this);
      tofu.addActionListener(this);

      proLabel.setBounds(10, 395, 400, 20);
      add(proLabel);
      egg.setBounds(10, 420, 60, 30);
      add(egg);
      cheese.setBounds(75, 420, 80, 30);
      add(cheese);
      tofu.setBounds(160, 420, 70, 30);
      add(tofu);
      bean.setBounds(235, 420, 70, 30);
      add(bean);
      saussage.setBounds(10, 455, 100, 30);
      add(saussage);
      chickpea.setBounds(115, 455, 100, 30);
      add(chickpea);

   }

   private void setUpSnacMenu() {
      snacLabel = new JLabel("Add snacks by clicking the buttons");
      chocolate = new JButton("Chocolate");
      cookie = new JButton("Cookie");
      cracker = new JButton("Cracker");
      cupcake = new JButton("Cupcake");

      chocolate.addActionListener(this);
      cookie.addActionListener(this);
      cracker.addActionListener(this);
      cupcake.addActionListener(this);

      snacLabel.setBounds(10, 495, 400, 30);
      add(snacLabel);
      chocolate.setBounds(10, 530, 100, 30);
      add(chocolate);
      cookie.setBounds(115, 530, 80, 30);
      add(cookie);
      cracker.setBounds(10, 565, 90, 30);
      add(cracker);
      cupcake.setBounds(105, 565, 90, 30);
      add(cupcake);
   }

   private void setUpWaterBottle() {
      watLabel = new JLabel("Fill up the waterbottle by sliding the bar: ");
      waterLevel = new JSlider(0, 200, 0);
      waterLevel.addChangeListener(this);
      nameLabel = new JLabel("Add a nametag by typing your name here: ");
      nameTag = new JTextField();
      nameTag.addActionListener(this);
      addName = new JButton("Add");
      addName.addActionListener(this);

      nameLabel.setBounds(1150, 30, 400, 30);
      add(nameLabel);
      nameTag.setBounds(1200, 60, 150, 30);
      add(nameTag);
      addName.setBounds(1230, 90, 80, 30);
      add(addName);
      watLabel.setBounds(10, 620, 400, 30);
      add(watLabel);
      waterLevel.setBounds(20, 655, 200, 20);
      add(waterLevel);
   }

   private void drawBottle(Graphics2D g) {
      g.setColor(Color.BLACK);
      g.draw(new RoundRectangle2D.Double(1200, 250, 200, 400, 40, 40));
      g.fillRoundRect(1175, 250, 250, 20, 5, 5);
      g.drawRect(1295, 150, 10, 425);
   }

   private void fillWater(Graphics2D g, int k) {
      g.setColor(new Color(224, 255, 255));
      g.fillRoundRect(1200, 650 - 2 * k, 200, 2 * k, 40, 40);
   }

   private void addNameTag(Graphics2D g, String s) {
      g.setColor(Color.WHITE);
      g.fillRect(1225, 400, 150, 50);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Serif", Font.ITALIC, 20));
      g.drawString(s, 1250, 430);
   }

   private void drawBox(Graphics2D g, int w, int h, Color c) {
      g.setColor(c);
      g.fillRoundRect(750 - w / 2, 375 - h / 2, w, h, 40, 40);
      g.setColor(Color.BLACK);
      g.draw(new RoundRectangle2D.Double(750 - w / 2, 375 - h / 2, w, h, 40, 40));
      g.draw(new RoundRectangle2D.Double(750 - w / 2 + 5, 375 - h / 2 + 5, w - 10, h - 10, 40, 40));
      g.draw(new RoundRectangle2D.Double(750 - w / 2 + 20, 375 - h / 2 + 20, w / 2, h / 2, 40, 40)); // veg&fru box, top
                                                                                                     // left
      g.draw(new RoundRectangle2D.Double(750 - w / 2 + 20, 375 - h / 2 + 35 + h / 2, w / 3.5, h / 2.5, 40, 40));// snack
                                                                                                                // box,
                                                                                                                // bottom
                                                                                                                // left
      g.draw(new RoundRectangle2D.Double(750 - w / 2 + 40 + w / 3.5, 375 - h / 2 + 35 + h / 2, w / 1.65, h / 2.5, 40,
            40));// carbs box, bottom right
      g.draw(new RoundRectangle2D.Double(750 - w / 2 + 40 + w / 2, 375 - h / 2 + 20, w / 2.5, h / 2, 40, 40));// protein,
                                                                                                              // top
                                                                                                              // right
   }

   private void drawBroccoli(Graphics2D g, int k) {
      int x, y;

      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 3; b++) {
            x = (int) ((Math.random() * (boxWidth / 2 - 120) + 750 - boxWidth / 2 + 40));
            y = (int) ((Math.random() * (boxHeight / 2 - 80) + 375 - boxHeight / 2 + 20));

            g.setColor(new Color(154, 205, 50));
            g.fillRect(x + 35, y + 20, 30, 60);

            g.setColor(new Color(34, 139, 34));
            g.fillRoundRect(x + 15, y, 70, 60, 40, 40);
            g.fillOval(x, y + 10, 100, 40);
         }
      }
   }

   private void drawSpinach(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 10; b++) {
            x = (int) ((Math.random() * (boxWidth / 2 - 100) + 750 - boxWidth / 2 + 40));
            y = (int) ((Math.random() * (boxHeight / 2 - 40) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(0, 153, 0));
            g.fillOval(x, y, 80, 40);
            g.setColor(new Color(0, 51, 0));
            g.setStroke(new BasicStroke(2));
            g.draw(new Ellipse2D.Double(x, y, 80, 40));
            g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g.draw(new Line2D.Float(x - 20, y + 20, x + 60, y + 20));
         }
      }
   }

   private void drawPea(Graphics2D g, int k) {
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 20; b++) {
            g.setColor(new Color(50, 205, 50));
            g.fillOval((int) ((Math.random() * (boxWidth / 2 - 15) + 750 - boxWidth / 2 + 20)),
                  (int) ((Math.random() * (boxHeight / 2 - 15) + 375 - boxHeight / 2 + 20)), 15, 15);
         }
      }
   }

   private void drawCarrot(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 10; b++) {
            x = (int) ((Math.random() * (boxWidth / 2 - 50) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2 - 50) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(255, 127, 80));
            g.fillOval(x, y, 50, 50);
            g.setColor(new Color(255, 127, 80));
            g.setStroke(new BasicStroke(2));
            g.draw(new Ellipse2D.Double(x, y, 50, 50));

         }
      }
   }

   private void drawCucumber(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 10; b++) {
            x = (int) ((Math.random() * (boxWidth / 2 - 50) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2 - 50) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(240, 255, 240));
            g.fillOval(x, y, 50, 50);
            g.setColor(new Color(107, 142, 35));
            g.setStroke(new BasicStroke(3));
            g.draw(new Ellipse2D.Double(x, y, 50, 50));
            g.setColor(Color.WHITE);
            g.fillOval(x + 23, y + 18, 7, 7);
            g.fillOval(x + 18, y + 27, 7, 7);
            g.fillOval(x + 26, y + 27, 7, 7);
         }
      }
   }

   private void drawStrawberry(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 10; b++) {
            x = (int) ((Math.random() * (boxWidth / 2 - 50) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2 - 50) + 375 - boxHeight / 2 + 20));

            g.setColor(Color.RED);
            g.fillArc(x, y, 100, 50, 90, 180);
            g.setColor(new Color(128, 0, 0));
            g.setStroke(new BasicStroke(3));
            g.drawArc(x, y, 100, 50, 92, 176);
            g.setColor(new Color(255, 182, 193));
            g.fillArc(x + 15, y + 10, 60, 30, 90, 180);
         }
      }
   }

   private void drawBlueberry(Graphics2D g, int k) {
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 20; b++) {
            g.setColor(new Color(0, 0, 139));
            g.fillOval((int) ((Math.random() * (boxWidth / 2 - 20) + 750 - boxWidth / 2 + 20)),
                  (int) ((Math.random() * (boxHeight / 2 - 17) + 375 - boxHeight / 2 + 20)), 20, 17);
         }
      }
   }

   private void drawCherry(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 10; b++) {
            x = (int) ((Math.random() * (boxWidth / 2 - 35) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2 - 30) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(128, 0, 0));
            g.fillOval(x, y, 35, 30);
            g.setColor(new Color(107, 142, 35));
            g.setStroke(new BasicStroke(3));
            g.draw(new Line2D.Float(x + 17, y + 5, x + 17, y - 5));
         }
      }
   }

   private void drawMacAndCheese(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 100; b++) {
            x = (int) ((Math.random() * (boxWidth / 1.65 - 70) + 760 - boxWidth / 2 + 40 + boxWidth / 3.5));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 70) + 385 - boxHeight / 2 + 35 + boxHeight / 2));
            g.setColor(new Color(255, 250, 205));
            g.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g.drawArc(x, y, 50, 50, (int) (Math.random() * 360), 90);
         }
      }
   }

   private void drawSpaghetti(Graphics2D g, int k) {
      int x1, y1, x2, y2, cx1, cy1, cx2, cy2;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 50; b++) {
            x1 = (int) ((Math.random() * (boxWidth / 1.65) + 750 - boxWidth / 2 + 40 + boxWidth / 3.5));
            y1 = (int) ((Math.random() * (boxHeight / 2.5) + 375 - boxHeight / 2 + 35 + boxHeight / 2));
            x2 = (int) ((Math.random() * (boxWidth / 1.65) + 750 - boxWidth / 2 + 40 + boxWidth / 3.5));
            y2 = (int) ((Math.random() * (boxHeight / 2.5) + 375 - boxHeight / 2 + 35 + boxHeight / 2));
            cx1 = (int) ((Math.random() * (boxWidth / 1.65) + 750 - boxWidth / 2 + 40 + boxWidth / 3.5));
            cy1 = (int) ((Math.random() * (boxHeight / 2.5) + 375 - boxHeight / 2 + 35 + boxHeight / 2));
            cx2 = (int) ((Math.random() * (boxWidth / 1.65) + 750 - boxWidth / 2 + 40 + boxWidth / 3.5));
            cy2 = (int) ((Math.random() * (boxHeight / 2.5) + 375 - boxHeight / 2 + 35 + boxHeight / 2));
            g.setColor(new Color(255, 215, 0));
            g.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            CubicCurve2D spaghetti = new CubicCurve2D.Double();
            spaghetti.setCurve(x1, y1, cx1, cy1, cx2, cy2, x2, y2);
            g.draw(spaghetti);

         }
      }
   }

   private void drawBread(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 2; b++) {
            x = (int) ((Math.random() * (boxWidth / 1.65 - 160) + 760 - boxWidth / 2 + 40 + boxWidth / 3.5));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 160) + 385 - boxHeight / 2 + 35 + boxHeight / 2));
            g.setColor(new Color(255, 255, 240));
            g.fillRect(x, y, 150, 150);
            g.setColor(new Color(205, 133, 63));
            g.setStroke(new BasicStroke(5));
            g.draw(new RoundRectangle2D.Double(x, y, 150, 150, 40, 40));
         }
      }
   }

   private void drawRice(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 300; b++) {
            x = (int) ((Math.random() * (boxWidth / 1.65 - 10) + 750 - boxWidth / 2 + 40 + boxWidth / 3.5));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 5) + 375 - boxHeight / 2 + 35 + boxHeight / 2));
            g.setColor(Color.WHITE);
            g.fillOval(x, y, 10, 5);
         }
      }
   }

   private void drawTortilla(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 2; b++) {
            x = (int) ((Math.random() * (boxWidth / 1.65 - 190) + 760 - boxWidth / 2 + 40 + boxWidth / 3.5));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 190) + 385 - boxHeight / 2 + 35 + boxHeight / 2));
            g.setColor(new Color(240, 230, 140));
            g.fillOval(x, y, 180, 180);
            g.setColor(new Color(255, 215, 0));
            g.setStroke(new BasicStroke(2));
            g.drawOval(x, y, 180, 180);
         }
      }
   }

   private void drawEgg(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 1; b++) {
            x = (int) ((Math.random() * (boxWidth / 2.5 - 150) + 750 - boxWidth / 2 + 40 + boxWidth / 2));
            y = (int) ((Math.random() * (boxHeight / 2 - 100) + 375 - boxHeight / 2 + 20));
            g.setColor(Color.WHITE);
            g.fillOval(x, y, 150, 100);
            g.setColor(Color.LIGHT_GRAY);
            g.setStroke(new BasicStroke(1));
            g.drawOval(x, y, 150, 100);
            g.setColor(new Color(255, 165, 0));
            g.fillOval(x + 30, y + 10, 80, 80);
         }
      }
   }

   private void drawCheese(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 2; b++) {
            x = (int) ((Math.random() * (boxWidth / 2.5 - 100) + 750 - boxWidth / 2 + 40 + boxWidth / 2));
            y = (int) ((Math.random() * (boxHeight / 2 - 100) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(255, 215, 0));
            g.fillRect(x, y, 100, 100);
            g.setColor(new Color(255, 250, 205));
            g.setStroke(new BasicStroke(2));
            g.drawRect(x, y, 100, 100);
         }
      }
   }

   private void drawChickpea(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 20; b++) {
            x = (int) ((Math.random() * (boxWidth / 2.5 - 20) + 750 - boxWidth / 2 + 40 + boxWidth / 2));
            y = (int) ((Math.random() * (boxHeight / 2 - 20) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(255, 228, 181));
            g.fillOval(x, y, 20, 20);
         }
      }
   }

   private void drawBean(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 20; b++) {
            x = (int) ((Math.random() * (boxWidth / 2.5 - 30) + 750 - boxWidth / 2 + 40 + boxWidth / 2));
            y = (int) ((Math.random() * (boxHeight / 2 - 20) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(178, 34, 34));
            g.fillOval(x, y, 30, 20);
         }
      }
   }

   private void drawSaussage(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 3; b++) {
            x = (int) ((Math.random() * (boxWidth / 2.5 - 100) + 750 - boxWidth / 2 + 40 + boxWidth / 2));
            y = (int) ((Math.random() * (boxHeight / 2 - 75) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(250, 128, 114));
            g.fillOval(x, y, 100, 75);
            g.setColor(new Color(178, 34, 34));
            g.setStroke(new BasicStroke(2));
            g.drawOval(x, y, 100, 75);
            g.setColor(new Color(255, 204, 204));
            g.fillOval(x + 30, y + 60, 10, 10);
            g.fillOval(x + 50, y + 10, 10, 10);
            g.fillOval(x + 20, y + 20, 10, 10);
            g.fillOval(x + 70, y + 40, 10, 10);

         }
      }
   }

   private void drawTofu(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 3; b++) {
            x = (int) ((Math.random() * (boxWidth / 2.5 - 30) + 750 - boxWidth / 2 + 40 + boxWidth / 2));
            y = (int) ((Math.random() * (boxHeight / 2 - 30) + 375 - boxHeight / 2 + 20));
            g.setColor(new Color(255, 255, 224));
            g.fillRect(x, y, 30, 30);
         }
      }
   }

   private void drawChocolate(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 3; b++) {
            x = (int) ((Math.random() * (boxWidth / 3.5 - 50) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 50) + 410));
            g.setColor(new Color(160, 82, 45));
            g.fillRect(x, y, 50, 50);
            g.setColor(new Color(51, 0, 0));
            g.setStroke(new BasicStroke(2));
            g.drawRect(x, y, 50, 50);
         }
      }
   }

   private void drawCookie(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 3; b++) {
            x = (int) ((Math.random() * (boxWidth / 3.5 - 70) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 70) + 410));
            g.setColor(new Color(218, 165, 32));
            g.fillOval(x, y, 70, 70);
            g.setColor(new Color(51, 0, 0));
            g.fillOval(x + 30, y + 55, 10, 10);
            g.fillOval(x + 50, y + 15, 10, 10);
            g.fillOval(x + 20, y + 25, 10, 10);
            g.fillOval(x + 40, y + 40, 10, 10);

         }
      }
   }

   private void drawCracker(Graphics2D g, int k) {
      int x, y;
      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 3; b++) {
            x = (int) ((Math.random() * (boxWidth / 3.5 - 60) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 60) + 410));
            g.setColor(new Color(255, 215, 0));
            g.fillRect(x, y, 60, 60);
            g.setColor(new Color(184, 134, 11));
            g.setStroke(new BasicStroke(2));
            g.drawRect(x, y, 60, 60);
            g.draw(new Line2D.Float(x + 20, y + 25, x + 40, y + 25));
            g.draw(new Line2D.Float(x + 20, y + 35, x + 40, y + 35));
            g.draw(new Line2D.Float(x + 25, y + 20, x + 25, y + 40));
            g.draw(new Line2D.Float(x + 35, y + 20, x + 35, y + 40));
         }
      }
   }

   private void drawCupcake(Graphics2D g, int k) {
      int x, y;

      for (int a = 0; a < k; a++) {
         for (int b = 0; b < 1; b++) {
            x = (int) ((Math.random() * (boxWidth / 3.5 - 100) + 750 - boxWidth / 2 + 20));
            y = (int) ((Math.random() * (boxHeight / 2.5 - 100) + 410));
            g.setColor(new Color(139, 69, 19));
            g.fillRect(x + 20, y + 40, 60, 60);

            g.setColor(new Color(210, 105, 30));
            g.fillOval(x, y, 100, 75);
            g.setColor(new Color(51, 0, 0));
            g.fillOval(x + 60, y + 50, 10, 10);
            g.fillOval(x + 50, y + 15, 10, 10);
            g.fillOval(x + 20, y + 25, 10, 10);
            g.fillOval(x + 40, y + 40, 10, 10);

         }
      }
   }

   private void clearLunchBox() {
      broccoliNum = 0;
      spinachNum = 0;
      peaNum = 0;
      carrotNum = 0;
      cucumberNum = 0;
      strawberryNum = 0;
      blueberryNum = 0;
      cherryNum = 0;
      macandcheeseNum = 0;
      spaghettiNum = 0;
      breadNum = 0;
      riceNum = 0;
      tortillaNum = 0;
      eggNum = 0;
      cheeseNum = 0;
      chickpeaNum = 0;
      beanNum = 0;
      saussageNum = 0;
      tofuNum = 0;
      chocolateNum = 0;
      cookieNum = 0;
      crackerNum = 0;
      cupcakeNum = 0;
      chosenColor = Color.WHITE;
      waterHeight = 0;
      boxWidth = 600;
      boxHeight = 600;
      name = "";
   }

}