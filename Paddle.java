class Paddle{
    private double x, y, vx;
    Paddle(double x, double y, double vx){
        this.x = x;
        this.y = y;
        this.vx = vx;
    }
    public int getX(){
        return (int)x;
    }
    public int getY(){
        return (int)y;
    }
    public double getVx(){
        return vx;
    }
    public double setVx(int i){
        vx = i;
        return vx;
    } 
    public void move(){
        x = x + vx;
        if(x>=150){
            vx = - vx;
        }
        if(x<=0){
            vx = - vx;
        }
    }
}