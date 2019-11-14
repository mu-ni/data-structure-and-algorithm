package algorithm.ArrayAndString;

import java.util.Arrays;

public class MaxAliveYear {
    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person(1912, 1915),
                new Person(1920, 1990),
                new Person(1910, 1998),
                new Person(1901, 1972),
                new Person(1910, 1998),
                new Person(1923, 1982),
                new Person(1913, 1998),
                new Person(1990, 1998),
                new Person(1983, 1999),
                new Person(1975, 1994),
        };
        System.out.println(new MaxAliveYear().maxAliveYear(people, 1900, 2000));
        System.out.println(new MaxAliveYear().maxAliveYear2(people, 1900, 2000));
    }

    public static class Person {
        public int birth;
        public int death;

        public Person(int birthYear, int deathYear) {
            birth = birthYear;
            death = deathYear;
        }
    }

    public int maxAliveYear(Person[] people, int min, int max) {
        int[] arr = new int[max - min + 1];
        for (Person person : people) {
            for (int i = person.birth; i <= person.death; i++) {
                arr[i-min]++;
            }
        }
        int index = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        return min + index;
    }

    public int maxAliveYear2(Person[] people, int min, int max) {
        int[] birth = new int[people.length];
        int[] death = new int[people.length];
        for (int i=0; i<people.length; i++) {
            birth[i] = people[i].birth;
            death[i] = people[i].death;
        }
        Arrays.sort(birth);
        Arrays.sort(death);

        int alive = 0;
        int maxAlive = 0;
        int rst = min;
        int bIndex = 0;
        int dIndex = 0;

        while (bIndex < people.length) {
            if (birth[bIndex] <= death[dIndex]) {
                alive++;
                if (alive > maxAlive) {
                    maxAlive = alive;
                    rst = birth[bIndex];
                }
                bIndex++;
            } else {
                alive--;
                dIndex++;
            }
        }
        return rst;
    }
}
