class Area {
    int ar;
    int breadth;

    Area() {
        int length = 2;
        breadth = 3;
        ar = length * breadth;
        System.out.println("Area of Rectangle: " + ar);
    }

    Area(double radius) {
        double ar = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + ar);
    }

    Area(Area s) {
        ar = s.breadth * s.breadth;
        System.out.println("Area of Square: " + ar);
    }

    public static void main(String[] args) {
        Area a1 = new Area();
        Area a2 = new Area(3.0);
        Area a3 = new Area(a1);
    }
}
