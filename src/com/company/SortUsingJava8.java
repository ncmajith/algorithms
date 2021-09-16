package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortUsingJava8 {
    static  List<Employee> listOfEmployee=new ArrayList<> ();
    static {
        try {
            listOfEmployee.addAll (
                    Arrays.asList (
                            new Employee ("Ajith", 26, new SimpleDateFormat ("dd/MM/yyyy").parse ("05/20/2020")),
                            new Employee ("Jane", 28, new SimpleDateFormat ("dd/MM/yyyy").parse ("01/20/2020")),
                            new Employee ("John", 50, new SimpleDateFormat ("dd/MM/yyyy").parse ("03/20/2020"))));
        }catch (Exception e){
            e.printStackTrace ();
        }
    }
    public static void main(String []args){
        listOfEmployee.forEach (System.out::println);
        Stream<Employee> sorted = listOfEmployee.stream ()
                .filter (employee -> employee.getAge ()<30)
                .sorted (Comparator.comparing (Employee::getDateOfJoining).reversed ());
        System.out.println ("\n---------------------------");
        sorted.forEach (System.out::println);
        System.out.println ("\n---------------------------");
        listOfEmployee.forEach (System.out::println);
    }
    public static void main(){
        System.out.println ("here");
    }
}
