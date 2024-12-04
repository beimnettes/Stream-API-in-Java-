import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        // Task 2: Initialize a list of integers from 1 to 10
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Task 3: Intermediate Operations
        System.out.println("Even Numbers:");
        numbers.stream()
               .filter(num -> num % 2 == 0) // Filter even numbers
               .forEach(System.out::println);

        System.out.println("\nSquares of Numbers:");
        numbers.stream()
               .map(num -> num * num) // Map to squares
               .forEach(System.out::println);

        System.out.println("\nCubes of Odd Numbers:");
        numbers.stream()
               .filter(num -> num % 2 != 0) // Filter odd numbers
               .map(num -> num * num * num) // Map to cubes
               .forEach(System.out::println);

        // Task 4: Terminal Operations
        System.out.println("\nSum of All Numbers:");
        int sum = numbers.stream()
                         .reduce(0, Integer::sum); // Sum all numbers
        System.out.println(sum);

        System.out.println("\nEven Numbers in a New List:");
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0) // Filter even numbers
                                           .collect(Collectors.toList()); // Collect to a new list
        System.out.println(evenNumbers);

        // Task 5: Advanced Operations
        System.out.println("\nFlattened List:");
        List<List<Integer>> nestedLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedList = nestedLists.stream()
                                                 .flatMap(List::stream) // Flatten nested lists
                                                 .collect(Collectors.toList());
        System.out.println(flattenedList);

        System.out.println("\nGrouped by Even and Odd:");
        Map<String, List<Integer>> grouped = numbers.stream()
            .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd")); // Group numbers
        System.out.println(grouped);

        // Task 6: Stream with Custom Objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 20),
            new Person("Charlie", 35)
        );

        System.out.println("\nPeople Older Than 25:");
        people.stream()
              .filter(person -> person.getAge() > 25) // Filter by age > 25
              .map(Person::getName) // Map to names
              .forEach(System.out::println);

        System.out.println("\nOldest Person:");
        Person oldest = people.stream()
                              .max(Comparator.comparingInt(Person::getAge)) // Find max by age
                              .orElse(null);
        System.out.println(oldest != null ? oldest.getName() : "None");
    }
}
