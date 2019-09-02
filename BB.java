import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class BB extends JApplet implements Runnable, KeyListener{
    Thread t;
    Ball b = new Ball(20,300,10,10);
    Paddle p = new Paddle(10,300,5);
    Brick[] bricks = new Brick[25];
    int score = 0;
    int lives = 5;
    public void init() {
        addKeyListener(this);
        setFocusable(true);
        t = new Thread(this);
        t.start();
        int length = 25;
        int width = 15;
        int x = 15;
        int y = 15;
        int s = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                bricks[s] = new Brick(x,y,length,width);
                x = x + length + 10;
                s++;
            }
            y = y + width + 10;
            x = 15;
        }
    }
    public void run(){
        try{
            while (true){
                repaint();
                t.sleep(100);
                b.move();
                p.move();
                if((b.getX() > p.getX() && b.getX() < (p.getX() + 50)) && (b.getY() > (p.getY()-20) && b.getY() < (p.getY() +20))){
                    b.changeA();
                }
                if(b.getY() >= 400 - 25){
                    lives--;
                }
                for(int i = 0; i < bricks.length; i++){
                    if(bricks[i] != null){
                        if((b.getX() > bricks[i].getX() && b.getX() < (bricks[i].getX() + 25)) && (b.getY() > bricks[i].getY() && b.getY() < (bricks[i].getY() +15))){
                            b.changeA();
                            bricks[i] = null;
                            score++;
                        }
                    }
                }
            } 
        }
        catch (InterruptedException e) {}
    }
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,200,400);
        g.setColor(Color.black);
        g.drawRect(0,0,200,400);
        g.fillOval(b.getX(),b.getY(),15,15);
        g.fillRect(p.getX(),p.getY(),50,20);
        g.setColor(Color.black);
        if(score == 25){
            g.setColor(Color.green);
            g.fillRect(0,0,200,400);
            g.setColor(Color.black);
            g.drawString("YOU WIN!", 50, 200);
        }else if(lives == 0){
            g.setColor(Color.red);
            g.fillRect(0,0,200,400);
            g.setColor(Color.black);
            g.drawString("YOU LOSE!", 50, 200);
        }else{
            g.drawString("Score: " + score, 0, 400);
            g.drawString("Lives: " + lives, 100, 400);
        }
        for(int i = 0; i < bricks.length; i++){
            if(bricks[i] != null){
                g.fillRect(bricks[i].getX(),bricks[i].getY(),25,15);
            }
        }
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            p.setVx(-10);
        }
        if(e.getKeyChar() == 'd') {
            p.setVx(10);
        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            p.setVx(0);
        }
        if(e.getKeyChar() == 'd') {
            p.setVx(0);
        }
    }
}