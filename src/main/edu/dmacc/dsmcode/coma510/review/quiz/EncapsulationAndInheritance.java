package edu.dmacc.dsmcode.coma510.review.quiz;

public class EncapsulationAndInheritance {

    public static class Vehicle { //todo: remove static before quiz
        // 1. To encapsulate numberOfWheels, what should the access modifier be?
        // a. public, b. private, c. protected, d. b or c, e. Any of the above will work
        private int numberOfWheels;

        public Vehicle(int numberOfWheels) {
            // 2. To assign the parameter numberOfWheels to the instance variable numberOfWheels, use:
            // a. super.numberOfWheels = numberOfWheels;
            // b. super.numberOfWheels = this.numberOfWheels;
            // c. this.numberOfWheels = numberOfWheels;
            // d. instance.numberOfWheels = parameter.numberOfWheels;
            // e. Any of the above will work
            this.numberOfWheels = numberOfWheels;
        }

        public int getNumberOfWheels() {
            return numberOfWheels;
        }
    }

    public static class Motorcycle extends Vehicle { //todo: remove static before quiz
        private String paintColor;

        public Motorcycle() {
            // 3. To call the Vehicle constructor and give is 2, use:
            // a. Vehicle(2);
            // b. super(2);
            // c. this(2);
            // d. Motorcycle(2);
            super(2);
        }

        public void setPaintColor(String paintColor) {
            // 4. To assign the parameter paintColor to the instance variable paintColor, use:
            // a. super.paintColor = paintColor;
            // b. super.paintColor = this.paintColor;
            // c. this.paintColor = paintColor;
            // d. instance.paintColor = parameter.paintColor;
            // e. Any of the above will work
            this.paintColor = paintColor;
        }

        public String getPaintColor() {
            // 5. To return the paint color instance variable, use:
            // a. return paintColor;
            // b. return super.paintColor;
            // c. return this.paintColor;
            // d. a or c
            // e. Any of the above will work
            return this.paintColor;
        }
    }

    public static void main(String[] args) {
        // 6. Write code to do all of the following:
        // create an instance of Motorcycle,
        // print to System.out the number of wheels,
        // set the paint color to "blue",
        // and print to System.out the paint color.
        Motorcycle motorcycle = new Motorcycle();
        System.out.println(motorcycle.getNumberOfWheels());
        motorcycle.setPaintColor("blue");
        System.out.println(motorcycle.getPaintColor());
    }
}
