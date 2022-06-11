import practice.StreamPractice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        StreamPractice streamPractice = new StreamPractice();
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7);

//        List<Integer> numbers = IntStream.range(0, values.size())
//                .filter(i -> i % 2 == 0)
//                .mapToObj(values::get)
//                .collect(Collectors.toList());
//
//        List<Integer> oddNumbers = IntStream.range(0, values.size())
//                .filter(i -> i % 2 != 0)
//                .mapToObj(i -> values.get(i) - 1)
//                .collect(Collectors.toList());

        System.out.println(streamPractice.getOddNumsAverage(values));
    }
}