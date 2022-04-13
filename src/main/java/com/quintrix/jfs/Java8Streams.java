package com.quintrix.jfs;

import java.util.List;
import java.util.stream.Collectors;

public class Java8Streams {
  public static void main(String[] args) {
    List<Integer> list = List.of(5, 22, 3, 44, 25, 66, 17);

    System.out.println("Original list:");
    for (int i : list) {
      System.out.print(i + " ");
    }
    System.out.println("\n");

    // intermediate operations
    System.out.println("Intermediate Operations:");
    // stream.filter()
    System.out.print("- stream.filter() to print out odd numbers from list: ");
    list.stream().filter(element -> (!(element % 2 == 0)))
        .forEach(element -> System.out.print(element + " "));
    // stream.map()
    System.out.print("\n- stream.map() to change each value in the list by multiplying by 10: ");
    list.stream().map(element -> element * 10).forEach(element -> System.out.print(element + " "));
    // stream.sorted()
    System.out.print("\n- stream.sorted() returns a sorted list: ");
    list.stream().sorted().forEach(element -> System.out.print(element + " "));



    System.out.println("\n");
    // terminal operations
    System.out.println("Terminal Operations:");
    // stream.collect()
    List<Integer> squared =
        list.stream().map(element -> (element * element)).collect(Collectors.toList());
    System.out
        .println("- stream.collect() of the original list's elements squared values: " + squared);
    // stream.count()
    long totalEvens = list.stream().filter(element -> (element % 2 == 0)).count();
    System.out.println("- stream.count() to count number of even numbers in list: " + totalEvens);
  }

}
