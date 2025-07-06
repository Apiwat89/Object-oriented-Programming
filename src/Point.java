class Point {
    private int x = 200;
    private int y = 300;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {this.x = x;}
    public int getX() {return this.x;}

    public void setY(int y) {this.y = y;}
    public int getY() {return this.y;}  
}