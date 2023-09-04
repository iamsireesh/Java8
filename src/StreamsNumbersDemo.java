import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsNumbersDemo {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,4,5,6,9,10,13);

        //Sorted List
        List<Integer> sorted = nums.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted); //[1, 4, 5, 6, 9, 10, 13]

        //Sorted reverse list
        List<Integer> sortedRev = nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedRev); //[13, 10, 9, 6, 5, 4, 1]

        //Filter out even numbers and sort
        List<Integer> evenSorted = nums.stream().filter(n -> n%2==0).sorted().collect(Collectors.toList());
        System.out.println(evenSorted); //[4, 6, 10]

        //Filter out odd numbers and sort in reverse order
        List<Integer> oddRevSorted = nums.stream().filter(n -> n%2!=0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(oddRevSorted); //[13, 9, 5, 1]

        //count even Numbers
        Long evenCount = nums.stream().filter(n -> n%2==0).count();
        System.out.println(evenCount); //3
        //odd numbers count
        Long oddCount = nums.stream().filter(n -> n%2!=0).count();
        System.out.println(oddCount); //4

        //sum all numbers
        Integer sumAll = nums.stream().reduce(0, (a,b)-> a+b);
        System.out.println(sumAll); //48
        Integer sumAll1 = nums.stream().reduce(0,Integer::sum);
        System.out.println(sumAll1); //48
        Integer sumAll2 = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sumAll2); //48

        //sum all even numbers
        Integer sumEven = nums.stream().filter(n -> n%2==0).reduce(0,Integer::sum);
        Integer sumEven1 = nums.stream().filter(n -> n%2==0).mapToInt(Integer::intValue).sum();
        System.out.println(sumEven); //20
        System.out.println(sumEven1); //20
        //sum all odd numbers
        Integer sumOdd = nums.stream().filter(n->n%2!=0).reduce(0,Integer::sum);
        Integer sumOdd1 = nums.stream().filter(n -> n%2!=0).mapToInt(Integer::intValue).sum();
        System.out.println(sumOdd); //28
        System.out.println(sumOdd1); //28

        //Get biggest number from a list
        Integer biggest = nums.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("biggest:: " + biggest); //13
        Integer biggest1 = nums.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("biggest1:: " + biggest1); //13
        //Get lowest number from a list
        Integer lowest = nums.stream().sorted().findFirst().get();
        System.out.println("lowest:: " + lowest); //1
        Integer lowest1 = nums.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("lowest1:: " + lowest); //1

        //find the average
        Double avg = nums.stream().mapToDouble(Integer::intValue).average().getAsDouble();
        System.out.println("Average::"+avg); //6.8

        //multiply the numbers
        List<Integer> mulnums = nums.stream().map(n -> n*2).collect(Collectors.toList());
        System.out.println("Multiplied List::"+mulnums); //[2, 8, 10, 12, 18, 20, 26]

        int firstEven = nums.stream().filter(n -> n % 2 == 0).findFirst().orElse(0);
        System.out.println("First even number: " + firstEven); //4

        int sumOfSquares = nums.stream().mapToInt(n -> n * n).sum();
        System.out.println("Sum of squares: " + sumOfSquares); //428

        List<Integer> numbers = Arrays.asList(1,1,3,5,6,7,7,3,1);

        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers); //[1, 3, 5, 6, 7]

        int sumOfGreaterThanFive = numbers.stream().filter(n -> n > 5).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers greater than 5: " + sumOfGreaterThanFive); //20

        List<Integer> evenSquares = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println("Squares of even numbers: " + evenSquares); //36

        int firstDivisibleByThree = numbers.stream().filter(n -> n % 3 == 0).findFirst().orElse(0);
        System.out.println("First number divisible by 3: " + firstDivisibleByThree); //3

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product of all numbers: " + product); //13230

        int sumOfCubes = numbers.stream().mapToInt(n -> n * n * n).sum();
        System.out.println("Sum of cubes: " + sumOfCubes); //1084

        List<Integer> numbersWithDigitThree = numbers.stream().filter(n -> String.valueOf(n).contains("3")).collect(Collectors.toList());
        System.out.println("Numbers with digit 3: " + numbersWithDigitThree); //[3,3]
        
        //Count the occurance of each number
        Map<Integer, Long> countMap = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
        System.out.println(countMap); //{1=3,3=2,5=1,6=1,7=2}
    }
}
