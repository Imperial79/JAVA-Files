/*2. Create a general class ThreeDObject and derive the classes Box, Cube, Cylinder and Cone from it. The class ThreeDObject has methods wholeSurfaceArea ( ) and volume ( ). Override these two methods in each of the derived classes to calculate the volume and whole surface area of each type of three-dimensional objects. The dimensions of the objects are to be taken from the users and passed through the respective constructors of each derived class. Write a main method to test these classes.  */

class ThreeDObject {

    public float wholeSurfaceArea() {
        return 0;
    }

    public float volume() {
        return 0;
    }
}

class Box extends ThreeDObject {
    int a, h, w, l;

    Box(int a, int height, int width, int length) {
        this.a = a;
        this.h = height;
        this.l = length;
        this.w = width;
    }

    @Override
    public float wholeSurfaceArea() {
        return (2 * l * w) + (2 * l * h) + (2 * w * h);
    }

    @Override
    public float volume() {
        return a * a * a;
    }
}

class Cone extends ThreeDObject {
    int r, h;

    Cone(int r, int h) {
        this.r = r;
        this.h = h;

    }

    @Override
    public float volume() {
        return (float) (0.33 * Math.PI * r * r * h);
    }

    @Override
    public float wholeSurfaceArea() {
        return (float) (Math.PI * r * (r + Math.sqrt((h * h) + (r * r))));
    }
}

class Cube extends ThreeDObject {
    int a;

    Cube(int a) {
        this.a = a;
    }

    @Override
    public float volume() {
        return a * a * a;
    }

    @Override
    public float wholeSurfaceArea() {
        return 6 * (a * a);
    }
}

class Cylinder extends ThreeDObject {
    int r, h;

    Cylinder(int r, int h) {
        this.r = r;
        this.h = h;
    }

    @Override
    public float wholeSurfaceArea() {
        return (float) (2 * Math.PI * r * (r + h));
    }

    @Override
    public float volume() {
        return (float) (Math.PI * r * r * h);
    }
}

class TestThreeDObject {
    public static void main(String[] args) {
        Box bx = new Box(5, 5, 3, 4);
        System.out.printf("\nBox - Volume = %.2f & Surface Area = %.2f", bx.volume(), bx.wholeSurfaceArea());

        Cone cn = new Cone(5, 4);
        System.out.printf("\nCone - Volume = %.2f & Surface Area = %.2f", cn.volume(), cn.wholeSurfaceArea());

        Cube cb = new Cube(5);
        System.out.printf("\nCube - Volume = %.2f & Surface Area = %.2f", cb.volume(), cb.wholeSurfaceArea());

        Cylinder cy = new Cylinder(5, 4);
        System.out.printf("\nCylinder - Volume = %.2f & Surface Area = %.2f", cy.volume(), cy.wholeSurfaceArea());
    }
}
