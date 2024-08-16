package in.ushatech.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.util.comparator.Comparators;

public class TransactionsStreamQuestions 
{
    public static void main(String[] args) 
    {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
        );

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
       // pratibha transactions.stream().map(t->t).filter(t->t.year()==2011).sorted();
            // transactions.stream() 
            //                     .filter(t->t.year()==2011)
            //                     .sorted(    (t1,t2)   ->  t1.value()-t2.value())
            //                     .forEach(System.out::print);


        // 2. What are all the unique cities where the traders work?

        // List<String> uniqueCities = transactions.stream()
        //             .map(t-> t.trader().city())
        //             .distinct()
        //             .collect(Collectors.toList());

                    // Set<String> uniqueCities = transactions.stream()
                    // .map(t-> t.trader().city())
                    // .collect(Collectors.toSet());
                    // uniqueCities.forEach(System.out::println);
                    

        // 3. Find all traders from Cambridge and sort them by name.

        //   List<Trader> cambridgeCityTraders = transactions.stream()
        //             .map(t-> t.trader())
        //             .filter(t-> t.city().equals("Cambridge"))
        //             .sorted(Comparator.comparing(Trader::name))
        //             .collect(Collectors.toList());
        //             cambridgeCityTraders.forEach(System.out::println);


        // 4. Return a string of all traders’ names sorted alphabetically.
        String sortedNames= transactions.stream()
                                        .map(t->t.trader().name())
                                        .distinct()
                                        .sorted()
                                        .collect(Collectors.joining(","));
        System.out.println(sortedNames);
        // 5. Are any traders based in Milan?

        boolean ifMilanTrader= transactions.stream()
                                            .map(t->t.trader().city())
                                            .anyMatch(t -> t.equals("Milan"));



                                            


        // 6. Print all transactions’ values from the traders living in Cambridge.
          String valuesJoined = transactions.stream()
                    .filter(t-> t.trader().city().equalsIgnoreCase("Cambridge"))
                    .map(Transaction::value)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));


        // 7. What’s the highest value of all the transactions?

        OptionalInt maxOptional = transactions.stream().map(t-> t.value())
                            .mapToInt(t-> t)
                            .max();
        int result = Integer.MIN_VALUE ;
        if(  maxOptional.isPresent() )
        {
                result=maxOptional.getAsInt();
        }        
        System.out.println(result);
        // 8. Find the transaction with the smallest value
        int minValue = transactions.stream()
                    .map(t-> t.value())
                    .reduce(Integer::min).orElse(Integer.MAX_VALUE);

        //  Map<String, List<Transaction>> mapByCurrency = transactions.stream()
        //             .collect(Collectors.groupingBy(Transaction::currency));

                   Map<Boolean, List<Transaction>> partition = transactions.stream().
                                collect(Collectors.partitioningBy(t->t.value()>500));
                                

;

    }
}


record Trader(String name, String city){}
record Transaction(Trader trader, int year, int value){}
