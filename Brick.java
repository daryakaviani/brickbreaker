class Brick {
   private int x, y, length, width;
   Brick(int x, int y, int length, int width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
   }
   public int getX() {
        return x;
   }
   public int getY() {
        return y;
   }
   public int getLength() {
        return length;
   }
   public int getWidth() {
        return width;
   }
 /*  public Color randomColor(){
       Random random = new Random();
       int red = random.nextInt(256);
       int green = random.nextInt(256);
       int blue = random.nextInt(256);
       return new Color(red,green,blue);
   }*/
}