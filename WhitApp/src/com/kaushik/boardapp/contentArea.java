/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.kaushik.boardapp;

/**
 *
 * @author kaushik kumar
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
 
/**
* Component for drawing !
*
* @author sylsau
*
*/
public class contentArea extends JComponent {
 private JLabel imageLabel;
  // Image in which we're going to draw
  private Image image;
  // Graphics2D object ==> used to draw on
  private Graphics2D g2;
  // Mouse coordinates
  private int currentX, currentY, oldX, oldY;
 
  public contentArea() {
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        // save coord x,y when mouse is pressed
        oldX = e.getX();
        oldY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX();
        currentY = e.getY();
 
        if (g2 != null) {
          // draw line if g2 context not null
          g2.drawLine(oldX, oldY, currentX, currentY);
          // refresh draw area to repaint
          repaint();
          // store current coords x,y as olds x,y
          oldX = currentX;
          oldY = currentY;
        }
      }
    });
  }
 
  @Override
  protected void paintComponent(Graphics g) {
    if (image == null) {
      // image to draw null ==> we create
      image = createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics();
      // enable antialiasing
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      // clear draw area
      clear();
    }
 
    g.drawImage(image, 0, 0, null);
  }
 
  // now we create exposed methods
  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();
  }
 
  public void red() {
    // apply red color on g2 context
    g2.setPaint(Color.red);
  }
 
  public void black() {
    g2.setPaint(Color.black);
  }
 
  public void magenta() {
    g2.setPaint(Color.magenta);
  }
 
  public void green() {
    g2.setPaint(Color.green);
  }
 
  public void blue() {
    g2.setPaint(Color.blue);
  }
 
 public void save() throws IOException{
     /**Container c = getContentPane();
BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
c.paint(im.getGraphics());
ImageIO.write(im, "PNG", new File("shot.png"));
 }**/JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(imageLabel);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                ImageIO.write((RenderedImage) image, "jpeg", f);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
 }
}

   /** BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
    panel.paint(img.getGraphics());
    try {
        ImageIO.write(img, "png", new File("E://Screen.png"));
        System.out.println("panel saved as image");

    } catch (IOException e) {
        System.out.println("panel not saved" + e.getMessage());
    }
}
 }**/
