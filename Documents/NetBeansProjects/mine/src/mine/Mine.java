
package mine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Kadir
 */
public class Mine extends JPanel implements ActionListener{

    public static JButton[][] btn = new JButton[10][10];
    public int array[][] = new int [11][11];    
    private ImageIcon img;
    public Mine(){
    img=new ImageIcon(getClass().getResource("m.png"));
    
    setLayout(new GridLayout(10,10,0,0));
     for(int i=0;i<10;i++){
     for(int j=0;j<10;j++){
     btn[i][j]=new JButton();
     btn[i][j].addActionListener(this);
     add(btn[i][j]);
     
     }
     }  
     
        for(int i=0;i<10;i++){
    for(int j=0;j<10;j++){
    int randomnumbers = (int) (Math.random()*100+1);
    if(randomnumbers<50){
        int mine=100;
    array[i][j]=mine;
    }
    }
    }
        
    for(int i=1;i<11;i++){
    for(int j=1;j<11;j++){
    if(array[i][j]==100){
        array[i-1][j-1]=array[i-1][j-1]+1;
        array[i-1][j]=array[i-1][j]+1;
        array[i-1][j+1]=array[i-1][j+1]+1;
        array[i][j-1]=array[i][j-1]+1;
        array[i][j+1]=array[i][j+1]+1;
        array[i+1][j-1]=array[i+1][j-1]+1;
        array[i+1][j]=array[i+1][j]+1;
        array[i+1][j+1]=array[i+1][j+1]+1;
    }
    }
    }
    }
 
    
    
    public static void main(String[] args) {
        JFrame m = new JFrame();
        m.setDefaultCloseOperation(EXIT_ON_CLOSE);
        m.setSize(500,500);
        m.setVisible(true);
        m.setTitle("MineSweeper");
       Mine m1=new Mine();
       m.add(m1);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     for(int i=0;i<10;i++){
     for(int j=0;j<10;j++){
     if(ae.getSource()==btn[i][j]){
         if(array[i][j]==100){
         btn[i][j].setIcon(img);
         for( i=0;i<10;i++){
     for( j=0;j<10;j++){
         if(array[i][j]==100){
        btn[i][j].setIcon(img);
         }
     }
     }
         }
         else {
             
             if(array[i][j]>100){
                 array[i][j]=array[i][j]-100;
             }
             btn[i][j].setText(""+array[i][j]);
         }
         }/// ae.getSource
     
     }
     }  
    }
    
}
