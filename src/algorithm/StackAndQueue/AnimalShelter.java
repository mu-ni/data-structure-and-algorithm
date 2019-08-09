package algorithm.StackAndQueue;

import java.util.LinkedList;

public class AnimalShelter {
    public class Animal {
        private String name; //id
        private int order = 0; //timestamp
        public Animal(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }
    public class Dog extends Animal {
        private String name;
        public Dog(String name) {
            super(name);
        }
    }
    public class Cat extends Animal {
        private String name;
        public Cat(String name) {
            super(name);
        }
    }

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;

    public void enqueue(Animal animal) {
        order++;
        animal.setOrder(order);
        if (animal instanceof Dog) {
            dogs.offer((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.offer((Cat) animal);
        } else {}
    }

    public Animal dequeue() {
        if (dogs.isEmpty()) return cats.poll();
        if (cats.isEmpty()) return dogs.poll();

        if (dogs.peek().getOrder() < cats.peek().getOrder()) {
            return dogs.poll();
        }
        return cats.poll();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}
