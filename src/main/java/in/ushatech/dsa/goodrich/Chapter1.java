package in.ushatech.dsa.goodrich;

import java.util.Arrays;
import java.util.*;


public class Chapter1 {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
            new Employee(1,"manish"),//y
            new Employee(2,"vineet"),//y
            new Employee(2,"diffName"),
            new Employee(3,"psc"),//y
            new Employee(3,"psc"),
            new Employee(4,"usha")//y
            );

            java.util.Set<Employee> result = new java.util.HashSet<>();
            java.util.Set<Integer> idSet = new HashSet<>();
            for(Employee e : list)
            {
                boolean added = idSet.add(e.id());
                if(added)
                {
                    result.add(e);
                }
            }

            System.out.println(result);
            
            
    }
    record Employee(int id,String name ){}

}

