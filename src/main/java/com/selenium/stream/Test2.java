package com.selenium.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String... argc) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 12, 20);
        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5, 6, 12, 20);

        Predicate<Integer> pred= new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };
        integerStream.sorted()
                .filter(pred)
                .forEach(i -> System.out.println(i));
        // Predicate<String> K;

        IsEvenPredicate<Integer> myNePredicate = new IsEvenPredicate<Integer>() {
            @Override
            public boolean checkEvenOrNot(Integer integer) {
                return integer % 2 == 0;
            }
        };
        integerStream2.filter(k->myNePredicate.checkEvenOrNot(k)).forEach(i-> System.out.println(i));
    }
}

@FunctionalInterface
interface IsEvenPredicate<T> {
    boolean checkEvenOrNot(T t);
}




