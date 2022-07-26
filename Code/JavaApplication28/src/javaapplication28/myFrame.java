package javaapplication28;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class myFrame extends JFrame implements ActionListener {

    JButton btn;
    JFileChooser fileChooser;
    File file;
    JLabel lbl0, lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,shortest,longest,count;

    myFrame(int numberOfFiles, ArrayList<String> str, String Longest, String Shortest,long wordCount) {
        
        
        btn = new JButton();
        btn.setBounds(50, 200, 200, 20);
        btn.addActionListener(this);
        btn.setText("Browse Folder");
        btn.setFocusable(false);
        
        lbl0=new JLabel("File Name");
        lbl1=new JLabel("Word Count");
        lbl2=new JLabel("Is Count");
        lbl3=new JLabel("Are Count");
        lbl4=new JLabel("You Count");
        lbl5=new JLabel("Longest Word");
        lbl6=new JLabel("Shortest Word");
        
        JPanel upperpanel=new JPanel();
        upperpanel.setBackground(Color.gray);
        upperpanel.add(btn);
        
        JPanel middlepanel=new JPanel();
        middlepanel.setBackground(Color.white);
        middlepanel.setPreferredSize(new Dimension(100,100));
        
        JPanel Titles= new JPanel(new GridLayout(numberOfFiles+1,7));
        Titles.add(lbl0);
        Titles.add(lbl1);
        Titles.add(lbl2);
        Titles.add(lbl3);
        Titles.add(lbl4);
        Titles.add(lbl5);
        Titles.add(lbl6);
       
        for(int i=0;i<str.size();i++)
        {
            
            Titles.add(new JLabel(str.get(i)));
        }
        middlepanel.add(Titles, BorderLayout.NORTH);
        
        JPanel lowerpanel= new JPanel(new GridLayout(2,1));
        lowerpanel.setBackground(Color.darkGray);
        lowerpanel.setPreferredSize(new Dimension(100,100));
        shortest=new JLabel("   Shortest Word in ALL Files: "+Shortest);
        longest=new JLabel("   Longest Word in ALL Files: "+Longest);
        count=new JLabel("   Number Of Words In in ALL Files: "+wordCount);
        shortest.setVerticalAlignment(JLabel.BOTTOM);
        longest.setHorizontalTextPosition(JLabel.LEFT);
        longest.setVerticalAlignment(JLabel.BOTTOM);
        shortest.setForeground(Color.white);
        longest.setForeground(Color.white);
        count.setForeground(Color.white);
        shortest.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        longest.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        count.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lowerpanel.add(longest);
        lowerpanel.add(shortest);
        lowerpanel.add(count);
        

        this.setTitle("Word Statistics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(1000, 700);
      //  this.setResizable(false);
        this.setVisible(true);
        this.add(upperpanel,BorderLayout.NORTH);
        this.add(middlepanel,BorderLayout.CENTER);
        this.add(lowerpanel,BorderLayout.SOUTH);
        


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == btn) {
            fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("E:\\University\\3-Third Year\\Operating Systems II\\Project")); //sets current directory
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int response = fileChooser.showOpenDialog(null); //select file to open

            if (response == JFileChooser.APPROVE_OPTION) {
                
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                JavaApplication28.directoryPath=file;
                JavaApplication28.frame.setVisible(false);
                JavaApplication28.main(null);
                //System.out.println(file);
            }

        }

    }
}
