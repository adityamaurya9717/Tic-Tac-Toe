import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
public class App extends JFrame{
  private JButton bt[][]=new JButton[3][3];
  private JButton reset=new JButton("Reset");
  
  JPanel panel2;
   JPanel panel3;
   int user=1;
   JLabel label;
   boolean winner=false;
	public App() {
		 
       super("Tic-Tac-Toe");
       Border blackline = BorderFactory.createLineBorder(Color.black);
       ResetListener rl=new ResetListener();
       reset.addActionListener(rl);
    //panel1
    JPanel panel=new JPanel();  
    panel.setBounds(0,10,700,50);
    panel.setBackground(Color.green);
    panel.setBorder(blackline);
  
    add(panel);
    
      label=new JLabel("First User turn");
     label.setBounds(350,30,100,100);
     panel.add(label);
     
     
     //panel2
     Border orangeline = BorderFactory.createLineBorder(Color.orange,3);
     panel2=new JPanel();
     panel2.setBounds(200, 150, 300, 300);
     panel2.setBorder(orangeline);
     panel2.setLayout(new GridLayout(3,3));
     add(panel2);
     
     
   //panel3
    panel3=new JPanel();
    panel3.setBounds(0, 600, 700, 50);
    panel3.setBackground(Color.green);
    panel3.add(reset);
    add(panel3);
		
	addButton();	
	setSize(700,700);
	setResizable(false);
	setDefaultCloseOperation(3);
	setLayout(null);
	setLocationRelativeTo(null);
	setVisible(true);
	}
	public void addButton() {
		ButtonListener bl=new ButtonListener();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				 Border orangeline = BorderFactory.createLineBorder(Color.orange,5);
				 
				   bt[i][j]=new JButton();
				  bt[i][j].setBackground(Color.white);
				  bt[i][j].setBorder(orangeline);
				  bt[i][j].addActionListener(bl);
			      panel2.add(bt[i][j]); 
			}
			 
		}
		System.out.println(getClass().getResource(""));
	}
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn=(JButton)e.getSource();
			if(btn.getText()!="" || winner==true)return;
			if(user==1) {
				btn.setText("X");
				label.setText("Second User Turn");
				user=2;
				winner("X");
			}
			else {
				btn.setText("0");
				label.setText("first User Turn");
				user=1;
				winner("0");
			}
			if(winner==true) {
				String s=(user==1)?"Second":"first";
				label.setText("Winner found "+s);
			}
			
			
		}
		
	}
	class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			user=1;
			winner=false;
			label.setText("first User turn");
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					bt[i][j].setText("");
					bt[i][j].setBackground(Color.white);
				}
			}
			
		}
		
	}
	public void winner(String u) {
		//horizontal
		if(bt[0][0].getText()==u && bt[0][1].getText()==u && bt[0][2].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{0,0,0,1,0,2});
			return;
		   }
		if(bt[1][0].getText()==u && bt[1][1].getText()==u && bt[1][2].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{1,0,1,1,1,2});
			return;
		   }
		if(bt[2][0].getText()==u && bt[2][1].getText()==u && bt[2][2].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{2,0,2,1,2,2});
			return;
		   }
		//vertical
		if(bt[0][0].getText()==u && bt[1][0].getText()==u && bt[2][0].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{0,0,1,0,2,0});
			return;
		   }
		if(bt[0][1].getText()==u && bt[1][1].getText()==u && bt[2][1].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{0,1,1,1,2,1});
			return;
		   }
		if(bt[0][2].getText()==u && bt[1][2].getText()==u && bt[2][2].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{0,2,1,2,2,2});
			return;
		   }
		//diagonal
		if(bt[0][0].getText()==u && bt[1][1].getText()==u && bt[2][2].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{0,0,1,1,2,2});
			return;
		   }
		if(bt[0][2].getText()==u && bt[1][1].getText()==u && bt[2][0].getText()==u) {
			System.out.println("winner");
			winner=true;
			changeColor(new int[]{0,2,1,1,2,0});
			return;
		   }
		
	}
	public void changeColor(int arr[]) {
		for(int i=0;i<arr.length;i+=2) {
			bt[arr[i]][arr[i+1]].setBackground(Color.green);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App();
		

	}

}
