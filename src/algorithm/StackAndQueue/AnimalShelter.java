package algorithm.StackAndQueue;

import java.util.LinkedList;

public class AnimalShelter {
    public static void main(String[] args) {
        enqueue(new Dog("d1"));
        enqueue(new Cat("c1"));
        enqueue(new Cat("c2"));
        enqueue(new Dog("d2"));

        Animal animal = dequeue();
        System.out.println(animal.getName());
        Dog dog = dequeueDog();
        System.out.println(dog.getName());
        Cat cat = dequeueCat();
        System.out.println(cat.getName());
        animal = dequeue();
        System.out.println(animal.getName());
    }

    public static class Animal {
        private String name; //id
        private int order = 0; //timestamp
        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }
    public static class Dog extends Animal {
        private String name;
        public Dog(String name) {
            super(name);
        }
    }
    public static class Cat extends Animal {
        private String name;
        public Cat(String name) {
            super(name);
        }
    }

    static LinkedList<Dog> dogs = new LinkedList<>();
    static LinkedList<Cat> cats = new LinkedList<>();
    static int order;

    public static void enqueue(Animal animal) {
        order++;
        animal.setOrder(order);
        if (animal instanceof Dog) {
            dogs.offer((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.offer((Cat) animal);
        } else {}
    }

    public static Animal dequeue() {
        if (dogs.isEmpty()) return cats.poll();
        if (cats.isEmpty()) return dogs.poll();

        if (dogs.peek().getOrder() < cats.peek().getOrder()) {
            return dogs.poll();
        }
        return cats.poll();
    }

    public static Dog dequeueDog() {
        return dogs.poll();
    }

    public static Cat dequeueCat() {
        return cats.poll();
    }
}
