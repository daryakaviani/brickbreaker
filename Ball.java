class Ball{
    private double x, y, v, a;
    Ball (double x, double y, double v, double a){
        this.x = x;
        this.y = y;
        this.v = v;
        this.a = a;
    }
    public int getX(){
        return(int) x;
    }
    public int getY(){
        return(int) y;
    }
    public double getV(){
        return v;
    }
    public double getA(){
        return a;
    }
    public double changeA(){
        a = -a;
        return a;
    }
    public void move(){
        x = x + v*Math.cos(a);
        y = y + v*Math.sin(a);
        if(x>=200 - 25){
            a = Math.PI - a;
        }
        if(x<=0){
            a = Math.PI - a;
        }
        if(y<=0){
            a = -a;
        }
        if(y>=400 - 25){
            a = -a;
        }
    }
}