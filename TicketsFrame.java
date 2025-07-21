/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author user
 */
public class TicketsFrame extends JFrame implements ChangeListener
{
    JPanel headingPnl;
    JPanel namePnl;
    JPanel surnamePnl;
    JPanel customerPnl;
    JPanel homePnl;
    JPanel awayPnl;
    JPanel costPnl;
    JPanel numTicketsPnl;
    JPanel totAmtPnl;
    JPanel ticketPnl;
    JPanel customerAndTicketPnl;
    JPanel buttonPnl;
    
    JLabel headingLbl;
    JLabel nameLbl;
    JLabel surnameLbl;
    JLabel homeLbl;
    JLabel awayLbl;
    JLabel costLbl;
    JLabel numTicketsLbl;
    JLabel totAmtLbl;
    
    JTextField nameTxtFld;
    JTextField surnameTxtFld;
    JTextField homeTxtFld;
    JTextField awayTxtFld;
    JTextField costTxtFld;
    JTextField amtDueTxtFld;
    
    JButton buyBtn;
    JButton clearBtn;
    JButton exitBtn;
    
    JSlider slider;

    public TicketsFrame() 
    {
        setLayout(new BorderLayout());
        
        //creating slider
        slider = new JSlider(0, 20, 10);
        slider.addChangeListener(this);
        
        //creaing panels
        
        headingPnl = new JPanel(new FlowLayout());
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerPnl =  new JPanel(new GridLayout(3, 1));
        customerPnl.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "Customer details"));
        homePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        awayPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        costPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        numTicketsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totAmtPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ticketPnl = new JPanel(new GridLayout(5, 1));
        ticketPnl.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "Tickets details"));
        customerAndTicketPnl = new JPanel(new BorderLayout());
        buttonPnl = new JPanel(new FlowLayout());
        
        //creating labels
        headingLbl = new JLabel("Soccer Match Tickets");
        headingLbl.setFont(new Font(Font.SERIF, Font.ITALIC + Font.BOLD, 40));
        headingLbl.setForeground(Color.CYAN);
        nameLbl = new JLabel("Name:       ");
        surnameLbl = new JLabel("Surname: ");
        homeLbl = new JLabel("Home team: ");
        awayLbl = new JLabel("Away team:   ");
        costLbl= new JLabel("Cost price:R");
        numTicketsLbl = new JLabel();
        numTicketsLbl.setText("Number of tickets required: " + slider.getValue());
        totAmtLbl = new JLabel("Total amount due: R");
        
        //creating textfields
        nameTxtFld = new JTextField(10);
        surnameTxtFld= new JTextField(10);
        homeTxtFld= new JTextField(10);
        awayTxtFld = new JTextField(10);
        costTxtFld= new JTextField(10);
        amtDueTxtFld = new JTextField(20);
        amtDueTxtFld.setText("To be calculated later.");
        amtDueTxtFld.setEditable(false);
        
        //creating buttons
        buyBtn = new JButton("Buy");
        buyBtn.addActionListener(new Buy());
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new Clear());
        exitBtn= new JButton("Exit");
        exitBtn.addActionListener(new ExitFrame());
        
        
        
        //addind to panels
        headingPnl.add(headingLbl);
        
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        
        customerPnl.add(namePnl);
        customerPnl.add(surnamePnl);
        
        homePnl.add(homeLbl);
        homePnl.add(homeTxtFld);
        awayPnl.add(awayLbl);
        awayPnl.add(awayTxtFld);
        costPnl.add(costLbl);
        costPnl.add(costTxtFld);
        numTicketsPnl.add(numTicketsLbl);
        numTicketsPnl.add(slider);
        totAmtPnl.add(totAmtLbl);
        totAmtPnl.add(amtDueTxtFld);
        
        ticketPnl.add(homePnl);
        ticketPnl.add(awayPnl);
        ticketPnl.add(costPnl);
        ticketPnl.add(numTicketsPnl);
        ticketPnl.add(totAmtPnl);
        
        buttonPnl.add(buyBtn);
        buttonPnl.add(clearBtn);
        buttonPnl.add(exitBtn);
        
        customerAndTicketPnl.add(customerPnl, BorderLayout.NORTH);
        customerAndTicketPnl.add(ticketPnl,BorderLayout.CENTER);
        
        //adding to the frame
        add(headingPnl, BorderLayout.NORTH);
        add(customerAndTicketPnl, BorderLayout.CENTER);
        add(buttonPnl, BorderLayout.SOUTH);
        
        setTitle("Ticket sales");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
       
    }
    
    @Override
    public void stateChanged(ChangeEvent ce)
    {
        numTicketsLbl.setText("Number of tickets required: " + slider.getValue());
    }
    
    public class Buy implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            double price = Double.parseDouble(costTxtFld.getText());
            double amtDue = price * slider.getValue();
            
            amtDueTxtFld.setEditable(true);
            
            String amt = "";
            amt += amtDue;
            amtDueTxtFld.setText(amt);
            
        }
    }
    
    public class Clear implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            nameTxtFld.setText(null);
            surnameTxtFld.setText(null);
            homeTxtFld.setText(null);
            awayTxtFld.setText(null);
            costTxtFld.setText(null);
            
            if(amtDueTxtFld.isEditable())
            {
                amtDueTxtFld.setText("To be calculated later.");
                amtDueTxtFld.setEditable(false);
            }
        }
    }
   
    public class ExitFrame implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            System.exit(0);
        }
    }
}


