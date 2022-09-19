/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaushik.boardapp;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author kaushik kumar
 */
public class SwingFill {
    JButton eraseBtn,clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn,saveBtn;
  contentArea drawArea;
  ActionListener actionListener = new ActionListener() {
 JPanel jp=new JPanel();
  @Override
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == clearBtn) {
        drawArea.clear();
      }
      else if(e.getSource()==saveBtn){
          try {
              drawArea.save();
          } catch (IOException ex) {
              Logger.getLogger(SwingFill.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      else if (e.getSource() == blackBtn) {
        drawArea.black();
      } else if (e.getSource() == blueBtn) {
        drawArea.blue();
      } else if (e.getSource() == greenBtn) {
        drawArea.green();
      } else if (e.getSource() == redBtn) {
        drawArea.red();
      } else if (e.getSource() == magentaBtn) {
        drawArea.magenta();
      }
      
      
    }
  };
 
  public static void main(String[] args) {
    new SwingFill().show();
  }
 
  public void show() {
    // create main frame
    JFrame frame = new JFrame(" WhiteBoardApp");
    Container content = frame.getContentPane();
    // set layout on content pane
    content.setLayout(new BorderLayout());
    // create draw area
    drawArea = new contentArea();
 
    // add to content pane
    content.add(drawArea, BorderLayout.CENTER);
 
    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();
 
    clearBtn = new JButton("Clear");
    clearBtn.addActionListener(actionListener);
    blackBtn = new JButton("Black");
    blackBtn.addActionListener(actionListener);
    blueBtn = new JButton("Blue");
    blueBtn.addActionListener(actionListener);
    greenBtn = new JButton("Green");
    greenBtn.addActionListener(actionListener);
    redBtn = new JButton("Red");
    redBtn.addActionListener(actionListener);
    magentaBtn = new JButton("Magenta");
    magentaBtn.addActionListener(actionListener);
    saveBtn = new JButton("Save");
    saveBtn.addActionListener(actionListener);
    // this comment adds to the panel
    controls.add(greenBtn);
    controls.add(blueBtn);
    controls.add(blackBtn);
    controls.add(redBtn);
    controls.add(magentaBtn);
    controls.add(clearBtn);
    controls.add(saveBtn);
    
 
    // to add all the controls to the pane
    content.add(controls, BorderLayout.NORTH);
 
    frame.setSize(1580, 1020);
    // to close the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // to show the whiteboard result
    frame.setVisible(true);

  }
}
