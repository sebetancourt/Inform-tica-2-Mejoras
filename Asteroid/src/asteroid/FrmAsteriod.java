package asteroid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class FrmAsteriod extends javax.swing.JFrame implements KeyListener {

    Objeto nave = new Objeto(400,300,0,0,0);
    double distancia,distancia1,deley,variar=0;       
    int movx1=0;
    int movx2=-800;
    int navelaterales,navefuego,cometamov,cometax,cometay,colision=0;
    int explosiones1,explosiones2=100;
    Objeto disparo[] = new Objeto[10];
    boolean disparado = false;
    
    Timer temporizador=new Timer(10, new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
            {
                
                distancia=Math.sqrt(Math.pow(nave.getDrawLocationX()-(cometax+cometamov),2)+Math.pow(nave.getDrawLocationY()-(cometay+cometamov),2));
                if(distancia<=90)
                {
                    colision=1;
                    deley+=10;
                    
                }
                else
                {
                    colision=0;
                    
                    
                }
                
                movx1+=10;
                movx2+=10;
                if(movx1==800)
                {
                    movx1=-800;
                }
                if(movx2==800)
                {
                    movx2=-800;
                }
                cometamov+=5;
                for(int i=0;i<10;i++)
                {
                    if(disparado==true)
                    {
                    disparo[i].setAccX(Math.cos(Math.toRadians(disparo[i].getAngulo()%360))*20);
                    disparo[i].setAccY(Math.sin(Math.toRadians(disparo[i].getAngulo()%360))*20);
                    disparo[i].setDrawLocationX(disparo[i].getDrawLocationX()+(int)disparo[i].getAccX());
                    disparo[i].setDrawLocationY(disparo[i].getDrawLocationY()+(int)disparo[i].getAccY());
                    }
                }  
                variar++;                
                if(variar==25)
                {
                variar=0;
                disparado=false;
                }
                repaint();
            }
        });
    public FrmAsteriod() {
        initComponents();
        for(int i=0;i<10;i++)
        {
            disparo[i]=new Objeto(0,0,0,0,0);
        }
        addKeyListener(this);
        cometax =(int)(Math.random()*800+1);
        cometay =(int)(Math.random()*1+1);
           
                
    }
    
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) 
    {
        if(e.getKeyCode()==87)
        {
           navefuego=0;
           
        }
        if(e.getKeyCode()==32)
        {
            disparado=true;
        }        
    }
    public void keyPressed(KeyEvent e)
    {
        
        if(e.getKeyCode()==32)
        {
            if(disparado==false) 
            {
                for(int i=0;i<10;i++)
                {
                    disparo[i].setAngulo(nave.getAngulo());
                    disparo[i].setDrawLocationX(nave.getDrawLocationX()+40);
                    disparo[i].setDrawLocationY(nave.getDrawLocationY()+40);       
                }
            }
            
        }
        if(e.getKeyCode()==68)
        {
           navelaterales=0;
           navelaterales+=3;
           nave.setAngulo(nave.getAngulo()+navelaterales);
        }
        if(e.getKeyCode()==65)
        {
           navelaterales=0;
           navelaterales-=3;
           nave.setAngulo(nave.getAngulo()+navelaterales);
        }
        if(e.getKeyCode()==87)
         {
            navefuego=1;          
         }
            nave.setAccX(Math.cos(Math.toRadians(nave.getAngulo()%360))*5.99);
            nave.setAccY(Math.sin(Math.toRadians(nave.getAngulo()%360))*5.99);           
            if(nave.getDrawLocationX()>=815 )
            {
                nave.setDrawLocationX(-10);
                nave.setDrawLocationY(nave.getDrawLocationY());
                nave.setAccX(3);
            }
            else if (nave.getDrawLocationX()<=-15)
            {
                nave.setDrawLocationX(805);
                nave.setDrawLocationY(nave.getDrawLocationY());
                nave.setAccX(3);
            }
            if(nave.getDrawLocationY()>=610 )
            {
                nave.setDrawLocationY(-10);
                nave.setDrawLocationX(nave.getDrawLocationX());
                nave.setAccY(3);
            }
            else if (nave.getDrawLocationY()<=-15)
            {
                nave.setDrawLocationY(605);
                nave.setDrawLocationX(nave.getDrawLocationX());
                nave.setAccY(3);
            }
   
     }
     
    public void paint(Graphics g)
    {
        BufferedImage imgNebula=null;
        BufferedImage imgDebris=null;
        BufferedImage imgAsteroid=null;
        BufferedImage imgShip=null;
        BufferedImage imgShip2=null;
        BufferedImage imgShot=null;
        BufferedImage imgExplosion=null;
        
               
        try {
            imgNebula = ImageIO.read(new File("C:\\Users\\Sebastian\\Desktop\\Archivos U\\Informática 2\\Asteroid\\build\\classes\\asteroid\\nebula_blue.png"));
            imgDebris = ImageIO.read(new File("C:\\Users\\Sebastian\\Desktop\\Archivos U\\Informática 2\\Asteroid\\build\\classes\\asteroid\\debris2_blue.png"));
            imgShip = ImageIO.read(new File("C:\\Users\\Sebastian\\Desktop\\Archivos U\\Informática 2\\Asteroid\\build\\classes\\asteroid\\nave1.png"));
            imgShip2 = ImageIO.read(new File("C:\\Users\\Sebastian\\Desktop\\Archivos U\\Informática 2\\Asteroid\\build\\classes\\asteroid\\nave2.png"));
            imgAsteroid= ImageIO.read(new File("C:\\Users\\Sebastian\\Desktop\\Archivos U\\Informática 2\\Asteroid\\build\\classes\\asteroid\\asteroid_blue.png"));
            imgExplosion= ImageIO.read(new File("C:\\Users\\Sebastian\\Desktop\\Archivos U\\Informática 2\\Asteroid\\build\\classes\\asteroid\\explosion.hasgraphics.png"));
            imgShot= ImageIO.read(new File("C:\\Users\\Sebastian\\Desktop\\Archivos U\\Informática 2\\Asteroid\\build\\classes\\asteroid\\shot2.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrmAsteriod.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //super.paint(g);
        
        g.drawImage(imgNebula, 0, 0,800,600,this);//sin llama
        g.drawImage(imgDebris, movx1, 0,800,600,this);
        g.drawImage(imgDebris, movx2, 0,800,600,this);
        nave.setDrawLocationX(nave.getDrawLocationX()+nave.getAccX());
        nave.setDrawLocationY(nave.getDrawLocationY()+nave.getAccY());
        
        if (colision==0)
        {
            explosiones1=100;
            explosiones2=100;
            g.drawImage(imgAsteroid, cometax+cometamov, cometay+cometamov,90,90,this);
            if(cometax+cometamov>=815 || cometay+cometamov>=615)
            {
                cometax =(int)(Math.random()*800+1);
                cometay =(int)(Math.random()*1+1);
                cometamov=0;
                g.drawImage(imgAsteroid, cometax+cometamov, cometay+cometamov,90,90,this);
                
            }
        }
        else
        {
            
            g.drawImage(imgExplosion, cometax+cometamov, cometay+cometamov,cometax+cometamov+90,cometay+cometamov+90,explosiones1,explosiones1,explosiones2+100,explosiones2+100,this);
            explosiones1+=100;
            explosiones2+=100; 
            if(deley==100)
            {
            cometax =(int)(Math.random()*800+1);
            cometay =(int)(Math.random()*1+1);
            cometamov=0;
            g.drawImage(imgAsteroid, cometax+cometamov, cometay+cometamov,90,90,this);
            deley=0;
            }
             
        }

 
// Rotation information

        
        if(navefuego==0)
        {   
        double rotationRequired = Math.toRadians(nave.getAngulo());
        double locationX = imgShip.getWidth() / 2;
        double locationY = imgShip.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        Graphics2D g2=(Graphics2D) g;
        // Drawing the rotated image at the required drawing locations
        g2.drawImage(op.filter(imgShip, null), (int)nave.getDrawLocationX(), (int)nave.getDrawLocationY(), null);
        }
        else if(navefuego==1)
        {
        double rotationRequired = Math.toRadians(nave.getAngulo());
        double locationX = imgShip.getWidth() / 2;
        double locationY = imgShip.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        Graphics2D g2=(Graphics2D) g;
        // Drawing the rotated image at the required drawing locations
        g2.drawImage(op.filter(imgShip2, null),(int)nave.getDrawLocationX(), (int)nave.getDrawLocationY(), null);
        }
        if(disparado)
        {
            for(int i = 0; i<10; i++)
            {

                double rotationDisparo = Math.toRadians(disparo[i].getAngulo());
                double locationXdisparo = imgShot.getWidth() / 2;
                double locationYdisparo = imgShot.getHeight() / 2;
                AffineTransform txDisparo = AffineTransform.getRotateInstance(rotationDisparo, locationXdisparo, locationYdisparo);
                AffineTransformOp opDisparo = new AffineTransformOp(txDisparo, AffineTransformOp.TYPE_BILINEAR);
                
                g.drawImage(imgShot,(int)disparo[i].getDrawLocationX(),(int)disparo[i].getDrawLocationY(),8,8,this);
            }
        }
    }
        
        
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        temporizador.start();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAsteriod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAsteriod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAsteriod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAsteriod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAsteriod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
