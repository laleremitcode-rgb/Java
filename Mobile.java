class Mobile {
    String companyName;
    double screenSize;
    Mobile() {
        companyName = "Samsung";
        screenSize = 6.5;
    }
    Mobile(String company, double s) {
        companyName = company;
        screenSize = s;
    }
    Mobile(Mobile m) {
        companyName = m.companyName;
        screenSize = m.screenSize;
    }
    void display() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Screen Size: " + screenSize);
    }
    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("Apple", 6.1);
        Mobile m3 = new Mobile(m1);
        System.out.println("Mobile 1:");
        m1.display();
        System.out.println("Mobile 2:");
        m2.display();
        System.out.println("Mobile 3:");
        m3.display();
    }
}
