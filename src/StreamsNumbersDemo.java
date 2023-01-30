import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsNumbersDemo {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,4,5,6,9,10,13);

        //Sorted List
        List<Integer> sorted = nums.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

        //Sorted reverse list
        List<Integer> sortedRev = nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedRev);

        //Filter out even numbers and sort
        List<Integer> evenSorted = nums.stream().filter(n -> n%2==0).sorted().collect(Collectors.toList());
        System.out.println(evenSorted);

        //Filter out odd numbers and sort in reverse order
        List<Integer> oddRevSorted = nums.stream().filter(n -> n%2!=0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(oddRevSorted);

        //count even Numbers
        Long evenCount = nums.stream().filter(n -> n%2==0).count();
        System.out.println(evenCount);
        //odd numbers count
        Long oddCount = nums.stream().filter(n -> n%2!=0).count();
        System.out.println(oddCount);

        //sum all numbers
        Integer sumAll = nums.stream().reduce(0, (a,b)-> a+b);
        System.out.println(sumAll);
        Integer sumAll1 = nums.stream().reduce(0,Integer::sum);
        System.out.println(sumAll1);
        Integer sumAll2 = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sumAll2);

        //sum all even numbers
        Integer sumEven = nums.stream().filter(n -> n%2==0).reduce(0,Integer::sum);
        Integer sumEven1 = nums.stream().filter(n -> n%2==0).mapToInt(Integer::intValue).sum();
        System.out.println(sumEven);
        System.out.println(sumEven1);
        //sum all odd numbers
        Integer sumOdd = nums.stream().filter(n->n%2!=0).reduce(0,Integer::sum);
        Integer sumOdd1 = nums.stream().filter(n -> n%2==0).mapToInt(Integer::intValue).sum();
        System.out.println(sumOdd);
        System.out.println(sumOdd1);

        //Get biggest number from a list
        Integer biggest = nums.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("biggest:: " + biggest);
        Integer biggest1 = nums.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("biggest1:: " + biggest1);
        //Get lowest number from a list
        Integer lowest = nums.stream().sorted().findFirst().get();
        System.out.println("lowest:: " + lowest);
        Integer lowest1 = nums.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("lowest1:: " + lowest);

        //find the average
        Double avg = nums.stream().mapToDouble(Integer::intValue).average().getAsDouble();
        System.out.println("Average::"+avg);

        //multiply the numbers
        List<Integer> mulnums = nums.stream().map(n -> n*2).collect(Collectors.toList());
        System.out.println("Multiplied List::"+mulnums);

        int firstEven = nums.stream().filter(n -> n % 2 == 0).findFirst().orElse(0);
        System.out.println("First even number: " + firstEven);

        int sumOfSquares = nums.stream().mapToInt(n -> n * n).sum();
        System.out.println("Sum of squares: " + sumOfSquares);

        List<Integer> numbers = Arrays.asList(1,1,3,5,6,7,7,3,1);

        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);

        int sumOfGreaterThanFive = numbers.stream().filter(n -> n > 5).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers greater than 5: " + sumOfGreaterThanFive);

        List<Integer> evenSquares = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println("Squares of even numbers: " + evenSquares);

        int firstDivisibleByThree = numbers.stream().filter(n -> n % 3 == 0).findFirst().orElse(0);
        System.out.println("First number divisible by 3: " + firstDivisibleByThree);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product of all numbers: " + product);

        int sumOfCubes = numbers.stream().mapToInt(n -> n * n * n).sum();
        System.out.println("Sum of cubes: " + sumOfCubes);

        List<Integer> numbersWithDigitThree = numbers.stream().filter(n -> String.valueOf(n).contains("3")).collect(Collectors.toList());
        System.out.println("Numbers with digit 3: " + numbersWithDigitThree);
        
        //Count the occurance of each number
        Map<Integer, Long> countMap = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
        System.out.println(countMap);
    }
}
