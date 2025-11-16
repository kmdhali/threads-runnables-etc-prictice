package com.selenium.stream;

import javax.swing.plaf.PanelUI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Exercise from Medium
 * https://medium.com/@mehar.chand.cloud/java-stream-coding-interview-questions-part-1-dc39e3575727
 */

public class streamExcercise1 {

    //Q. Find the longest string in a list of strings using Java streams:

    /**
     * old school style
     */
    void longestStringLength() {

        List<String> stringList = Arrays.asList("apple", "Jackfroot123", "banana", "litchi", "Cucumber", "it");
        Optional<String> longestString = stringList.stream().min(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        longestString.ifPresent((s) -> System.out.println(s));

    }

    /**
     * old school style
     */
    private void longestStringLength_lambda() {
        List<String> list = List.of("1", "12", "123", "1234", "12345");
        Optional<String> maxStr = list.stream().min((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        maxStr.ifPresent(System.out::println);
    }


    /**
     * Q. Calculate the average age of a list of Person objects using Java streams:
     */

    void calculateAverageAge() {

        List<Person> list = List.of(new Person("Sanjay", 50), new Person("Tarun", 48), new Person("Kiron", 53));

        double averageAge = list.stream().mapToDouble(p -> p.age).average().orElse(0.0);
        System.out.println("Average Age : " + averageAge);

    }

    /**
     * Find the intersection of two lists
     */

    public void intersectionOfList() {
        List<String> list1 = List.of("1", "12", "123", "1234", "12345");
        List<String> list2 = List.of("11", "121", "123", "1234999", "12345111");

        List<String> resultList = list1.stream().filter(s -> list2.contains(s)).collect(Collectors.toList());

        resultList.forEach(System.out::println);


    }

    /*
    Q. Check if a list of integers contains a prime number using Java streams:
     */
    //option 1
    private boolean isPrime(int val) {
        if (val < 2) return false;
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) return false;
        }
        return true;
    }

    public void checkIfPrime() {
        IntStream insStream = IntStream.of(4, 6, 8, 9, 15);

        boolean prime = insStream.anyMatch(this::isPrime);
        System.out.println("The list  contains prime :" + prime);
    }

    /* print all the primes in the list */
    public void printAllThePrimes() {
        IntStream intStream = IntStream.of(3, 4, 7, 13, 31, 41, 42);
        intStream.filter(this::isPrime).forEach(System.out::println);

    }


    /* Q. Merge two sorted lists into a single sorted list using Java streams:*/

    public void mergeTwoSortedList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 16, 17);
        List<Integer> list2 = Arrays.asList(7, 8, 9, 10, 18, 19);
        List<Integer> finalList = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
        finalList.forEach(System.out::println);

    }


    /*
    Q. Find the intersection of two lists using Java streams:
     */

    void intersectionOfTwoList() {


        List<String> list1 = List.of("12", "123", "1234", "55");
        List<String> list2 = List.of("66", "999", "123", "1234", "77");

        List<String> intersection = list1.stream().filter(list2::contains).collect(Collectors.toList());
        intersection.stream().forEach(System.out::println);
    }

    /**
     * Q. Remove duplicates from a list while preserving the order using Java streams:
     */

    public void removeDuplicate() {
        List<Integer> list2 = Arrays.asList(1, 2, 3, 3, 2, 4, 1, 5, 6, 5);

        List<Integer> distinctList = list2.stream().distinct().collect(Collectors.toList());

        System.out.println("Old List");
        list2.forEach(s -> System.out.print(s + " "));

        System.out.println("New Unique List");
        distinctList.forEach(s -> System.out.print(s + " "));

    }

    /**
     * Q. Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
     */

    record Transaction(double value, String date) {
    }

    void groupBySumFunction() {
        List<Transaction> list = List.of(new Transaction(100, "2025-11-01"), new Transaction(100, "2025-11-01"), new Transaction(200, "2025-11-02"), new Transaction(200, "2025-11-02"), new Transaction(150, "2025-11-03"), new Transaction(160, "2025-11-04"));

        Map<String, Double> collected = list.stream().collect(Collectors.groupingBy(Transaction::date, Collectors.summingDouble(Transaction::value)));
        System.out.println(collected);
    }


    /**
     * Q. Find the kth smallest element in an array using Java streams:
     */

    public void kthSmallElement() {

        int[] intArray = {5, 1, 4, 2, 99, 1, 4, 6};
        int k = 5;
        int kthSmallElement = Arrays.stream(intArray).sorted().skip(k - 1).findFirst().orElse(-1);
        System.out.println("Smallest k th Element " + kthSmallElement);

    }

    /**
     * Q. Given a list of strings, find the frequency of each word using Java streams:
     */

    //TBD

    /*    Q. Implement a method to partition a list into two groups based on a predicate using Java streams:
     */

    void partitionByExample(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numbers
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }


    public static void main(String... argc) {

        streamExcercise1 exercise = new streamExcercise1();

        //exercise.longestStringLength();
        //exercise.longestStringLength_lambda();
        //exercise.calculateAverageAge();
        //exercise.intersectionOfList();
        //exercise.checkIfPrime();
        //exercise.printAllThePrimes();
        //exercise.mergeTwoSortedList();
        //exercise.intersectionOfTwoList();
        //exercise.removeDuplicate();
        //exercise.groupBySumFunction();
        exercise.partitionByExample();

    }
}

class Person {
    public String name;
    public double age;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }
}