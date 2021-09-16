package dev.java8;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE),
                new Person("Antonio", 20, Gender.MALE)
        );
    }
    public static void main(String... args){
        List<Person> listOfPerson=getPeople ();
        System.out.println ("\nSorted on the basis of name\n###\n");
        /**
         * stream().sorted()
         *  accept Comparator
         *  used for sorting
         *  pipe line using then comparing
         */
        List<Person> sortedPerson=listOfPerson.stream ()
                .sorted (Comparator.comparing (Person::getName)
                                 .thenComparing (Comparator.comparing (Person::getAge).reversed ()))
                .collect (Collectors.toList ());
        printList(sortedPerson);
        System.out.println ("\nFilter on the basis of name\n###\n");
        /**
         * stream().filter()
         *  accept Predicate
         *  used for filtering on the basis of certain condition
         */
        List<Person> filtered=listOfPerson.stream ()
                .filter (person -> person.getName ().toUpperCase().startsWith ("A"))
                .collect (Collectors.toList ());
        printList(filtered);

        /**
         * stream().allMatch()
         *  accept Predicate
         *  used for getting all the result matches certain condition
         */
        boolean allMatch = listOfPerson.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println (allMatch);

        /**
         * stream().anyMatch()
         *  accept Predicate
         *  used for getting any result matches certain condition
         */
        boolean anyMatch = listOfPerson.stream()
                .anyMatch(person -> person.getAge() > 121);
        System.out.println (anyMatch);

        /**
         * stream().noneMatch()
         *  accept Predicate
         *  used for getting all result not matching certain condition
         */
        boolean noneMatch = listOfPerson.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println (noneMatch);

        /**
         * stream().max()
         *  accept Predicate
         *  used for getting max value on the basis of one condition
         */
        Optional<Person> max= listOfPerson.stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println (max);

        /**
         * stream().min()
         *  accept Predicate
         *  used for getting min value on the basis of one condition
         */
        Optional<Person> min=listOfPerson.stream()
                .min(Comparator.comparing(Person::getAge));
        System.out.println (min);

        /**
         * for making map out of stream
         */
        Map<Gender, List<Person>> groupByGender = listOfPerson.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println (groupByGender);
        process (getPeople (),wrapper((person)-> System.out.println (person.getAge ()/0)));
        process (()->new Person ("Ajith",10,Gender.FEMALE));
        Predicate<Person> predicate=(person)->person.getAge ()>20;
        process (getPeople (),predicate);
        Function<Person,Integer> personFunction=(Person people)->people.getAge ();
        process (getPeople (),personFunction);
    }
    public static Consumer<Person> wrapper(Consumer<Person> consumer){
        return person -> {
            try {
                consumer.accept (person);
            }catch (ArithmeticException ex){
                System.out.println ("Arithmetic exception captured");
            }
        };
    }
    public static void  process( List<Person> listOfPerson, Consumer<Person> consumer ){
        listOfPerson.forEach (person -> consumer.accept (person));
    }
    public static void  process(Supplier<Person> supplier ){
        System.out.println (supplier.get ());
    }
    public static void  process( List<Person> list, Function<Person,Integer> function ){
        list.forEach (person -> {
            System.out.println (function.apply (person));
        });
    }
    public static void  process( List<Person> list,Predicate<Person> predicate ){
        list.forEach (person -> {
            System.out.println (predicate.test (person));
        });
    }
    public static void printList(List<Person> list){
        list.forEach (System.out::println);
    }
}
