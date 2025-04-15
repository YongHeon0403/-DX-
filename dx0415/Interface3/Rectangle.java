package dx0415.Interface3;

class Shape {
    protected int x, y;
}

interface Drawable {
    void draw();
};

public class Rectangle extends Shape implements Drawable{
    int width, heigt;
    public void draw() {
        System.out.println("Rectangle Draw");
    }
};
