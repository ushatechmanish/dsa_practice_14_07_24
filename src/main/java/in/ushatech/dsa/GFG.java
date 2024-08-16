package in.ushatech.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import in.ushatech.dsa.Dish.Type;

public class GFG {
    public static void main(String[] args) 
    {
        List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)) ;
    // How would you use streams to filter the first two meat dishes?
    // menu.stream().filter((d)-> d.type().equals(Dish.Type.MEAT))
                // .limit(2)
                // .collect(Collectors.toList()).forEach(System.out::println);;;;;;

                //     Quiz 5.2: Mapping
//  1. Given a list of numbers, how would you return a list of the square of each number? For
// example, given [1, 2, 3, 4, 5] you should return [1, 4,9,16,25]
            List<Integer> numbers = Arrays.asList(3,5,7,4);

            // List<Integer> result = numbers.stream()
            //         .map(Function.identity())
            //         .filter((i)-> true)
            //         .collect(Collectors.toList());
            
            //         result.forEach(System.out::println);

                //   numbers.stream()
                //     .map((num)-> num*num)
                //     .filter((i)-> true)
                //     .forEach(System.out::println);


                // How would you count the number of dishes in a stream using the map and reduce
                // int count = menu.stream()
                //     .map(dish-> 1)
                //     . filter(a->true)
                //     .reduce(0, (num1,num2)-> num1+num2);    
                //     System.out.println(count);           

            // The series of Fibonacci tuples is similar; you have a sequence of a number and its successor in
            // the series: (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)....
            // Your task is to generate the first 20 elements of the series of Fibonacci tuples using the iterate
            // method
           Stream.iterate(new int[]{0,1}, seed -> new int[]{seed[1], seed[0]+seed[1]})
                 .limit(20) 
                 .forEach(i-> System.out.print(i[1]+" "));

            // print all dish names using , as separator
            // String dishNames = menu.stream().map(Dish::name)
            //             .collect(Collectors.joining(",", "DishNames:"   , ""));

            // String dishNames =menu.stream().map(dish-> dish.name())
            //             . reduce("DishNames:", (i,j)->i+","+j);

            //  String dishNames =menu.stream().map(dish-> dish.name())
            //             . reduce( (i,j)->i+","+j).get();

           
            String dishNames =menu.stream().map(dish-> dish.name())
            .collect(Collectors.reducing( (i,j)-> i+","+j )).get();

                        System.out.println(dishNames);
                  
           
            
             menu.stream().count();


             menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::calories))).orElse(null);
             menu.stream().map(Dish::calories).collect(Collectors.reducing(0, Integer::sum));
     
             
             Stream.iterate(0, num-> num+2).limit(10).forEach(System.out::print);

          Map<Type, List<Dish>> var = menu.stream().collect(Collectors.groupingBy(Dish::type));

          Map<Type, Long> dishTypeCount = menu.stream().collect(Collectors.groupingBy(Dish::type,Collectors.counting()));

          Map<Type, Map<Integer, List<Dish>>> dishByTypeAndThenCalories = menu.stream().collect(Collectors.groupingBy(Dish::type,Collectors.groupingBy(Dish::calories)));
          

    }




}
record  Dish(String name, boolean vegetarian, int calories, Type type){
    enum Type { MEAT, FISH, OTHER};
}

