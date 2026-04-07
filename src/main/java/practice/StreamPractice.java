package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import model.Candidate;
import model.Person;

public class StreamPractice {
    /**
     * Дано список рядків, де кожен елемент містить одне або більше чисел:
     * input = {"5,30,100", "0,22,7", ...}
     * Повернути мінімальне ціле число. Ще одна умова — нас цікавлять тільки парні числа.
     * Якщо потрібних даних немає, викинути RuntimeException з повідомленням:
     * "Can't get min value from list: < Тут наш вхідний список 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(el -> Arrays.stream(el.split(",")))
                .mapToInt(el -> Integer.parseInt(el))
                .filter(num -> num % 2 == 0)
                .min()
                .orElseThrow(() ->
                new RuntimeException("Can't get min value from list: " + numbers));
    }

    /**
     * Дано список цілих чисел (List<Integer>).
     * Повернути середнє значення всіх непарних чисел зі списку
     * або викинути NoSuchElementException.
     * Але перед цим потрібно відняти 1 від кожного елемента,
     * який знаходиться на непарній позиції (має непарний індекс).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> {
                    if (i % 2 != 0) {
                        return numbers.get(i) - 1;
                    } else {
                        return numbers.get(i);
                    }
                })
                .filter(num -> num % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Дано список об'єктів `Person` (мають поля `name`, `age` і `sex`),
     * наприклад: `Arrays.asList(new Person("Victor", 16, Sex.MAN),
     * new Person("Helen", 42, Sex.WOMAN))`,
     * вибрати зі списку тільки чоловіків, вік яких знаходиться у діапазоні
     * від `fromAge` до `toAge` включно.
     *
     * Приклад: вибрати чоловіків, яких можна призвати до армії
     * (від 18 до 27 років включно).
     */
    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(el -> el.getSex().equals(Person.Sex.MAN)
                        && el.getAge() >= fromAge
                        && el.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    /**
     * Дано список об'єктів `Person` (мають поля `name`, `age` і `sex`),
     * наприклад: `Arrays.asList(new Person("Victor", 16, Sex.MAN),
     * new Person("Helen", 42, Sex.WOMAN))`,
     * вибрати зі списку тільки людей, вік яких знаходиться у діапазоні
     * від `fromAge` до `maleToAge` (для чоловіків)
     * або до `femaleToAge` (для жінок) включно.
     *
     * Приклад: вибрати людей працездатного віку
     * (від 18 років і до 60 років для чоловіків та до 55 років для жінок включно).
     */
    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
       return  peopleList.stream()
                .filter(el -> el.getSex().equals(Person.Sex.MAN)
                        && el.getAge() >= fromAge
                        && el.getAge() <= maleToAge
                        || el.getSex().equals(Person.Sex.WOMAN)
                        && el.getAge() >= fromAge
                        && el.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    /**
     * Дано список об'єктів `Person` (мають поля `name`, `age`, `sex` і `cats`,
     * а кожен `Cat` має `name` і `age`),
     * повернути імена всіх котів, власниками яких є жінки віком від `femaleAge`
     * років включно.
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN) && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(cat -> cat.getName())
                .collect(Collectors.toList());
    }

    /**
     * Your help with a election is needed. Given list of candidates, where each element
     * has Candidate.class type.
     * Check which candidates are eligible to apply for president position and return their
     * names sorted alphabetically.
     * The requirements are: person should be older than 35 years, should be allowed to vote,
     * have nationality - 'Ukrainian'
     * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
     * which has following view: "2002-2015"
     * We want to reuse our validation in future, so let's write our own impl of Predicate
     * parametrized with Candidate in CandidateValidator.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
