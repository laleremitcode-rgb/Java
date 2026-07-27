class Cube {
    int length;
    int breadth;
    int height;

    Cube() {
        length = 10;
        breadth = 12;
        height = 13;
    }

    Cube(int l, int b, int h) {
        length = l;
        breadth = b;
        height = h;
    }

    Cube(Cube c) {
        length = c.length;
        breadth = c.breadth;
        height = c.height;
    }

    void displayVolume() {
        int v = length * breadth * height;
        System.out.println("Length = " + length);
        System.out.println("Breadth = " + breadth);
        System.out.println("Height = " + height);
        System.out.println("Volume = " + v);
    }
}

public class Main {
    public static void main(String[] args) {
        Cube c1 = new Cube();
        Cube c2 = new Cube(6, 4, 3);
        Cube c3 = new Cube(c1);

        System.out.println("Cube 1:");
        c1.displayVolume();

        System.out.println("Cube 2:");
        c2.displayVolume();

        System.out.println("Cube 3:");
        c3.displayVolume();
    }
}
