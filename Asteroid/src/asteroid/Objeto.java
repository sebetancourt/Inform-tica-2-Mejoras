/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroid;

/**
 *
 * @author Sebastian
 */
public class Objeto {
    // estado (atributos)
    private double drawLocationX, drawLocationY;
    private int angulo;
    private double accX, accY;
    
//aceleracion
    
    //comportamiento (métodos)
    public Objeto(double drawX, double drawY, int angle, double accX, double accY) //constructor
    {
        drawLocationX= drawX;
        drawLocationY= drawY;
        angulo=angle;
        this.accX=accX;
        this.accY=accY;
                
    }
    public void setDrawLocationX(double drawX)
    {
        drawLocationX= drawX;
    }
    public void setDrawLocationY(double drawY)
    {
        drawLocationY= drawY;
    }
    public void setAngulo(int angle)
    {
        angulo=angle;
    }
    public void setAccX(double acX)
    {
        accX= acX;
    }
    public void setAccY(double acY)
    {
        accY= acY;
    }
    // métodos get
    
    public double getDrawLocationX()
    {
       return drawLocationX;
    }
    public double getDrawLocationY()
    {
       return drawLocationY;
    }
    public int getAngulo()
    {
        return angulo;
    }
    public double getAccX()
    {
        return accX;
    }
    public double getAccY()
    {
        return accY;
    }
   
}
