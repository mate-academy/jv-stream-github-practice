package practice.converter;

import java.util.List;
import java.util.function.UnaryOperator;

public class IntegerConverter implements UnaryOperator<Integer> {
    private List<Integer> numbers;

    public IntegerConverter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer apply(Integer number) {
        int index = numbers.indexOf(number);
        int num = index % 2 != 0 ? --number : number;
        numbers.set(index, null);
        return num;
    }
}
