package edu.dmacc.dsmcode.coma510.review.quiz;

public class Polymorphism {
    // 7. What will be printed to System.out?
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.speak();

        Cat cat = new Cat();
        cat.speak();
    }

    public static class Animal { // todo: remove static before quiz
        public void speak() {
            System.out.println("I can't speak!");
        }
    }

    public static class Cat extends Animal { // todo: remove static before quiz
        @Override
        public void speak() {
            System.out.println("Meow");
        }
    }
}
