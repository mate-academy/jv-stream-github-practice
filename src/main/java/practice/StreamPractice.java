package practice;

import java.util.List;

import model.Candidate;
import model.Cat;
import model.Person;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> List.of(s.split(",")).stream()) // Розбиваємо кожен рядок на числа
                .map(Integer::parseInt) // Перетворюємо рядки на цілі числа
                .filter(num -> num % 2 == 0) // Фільтруємо тільки парні числа
                .min(Integer::compare) // Знаходимо мінімальне значення
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> modifiedNumbers = IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .toList();  // Модифікація елементів на непарних позиціях

        return modifiedNumbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException(
                        "No odd numbers in the list after modification"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN)  // Фільтруємо лише чоловіків
                .filter(person -> person.getAge() >= fromAge
                        && person.getAge() <= toAge)  // Фільтруємо за віком у вказаному діапазоні
                .collect(Collectors.toList());  // Збираємо результати в список
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    if (person.getSex() == Person.Sex.MAN) {
                        return person.getAge() >= fromAge
                                && person.getAge() <= maleToAge;
                    } else if (person.getSex() == Person.Sex.WOMAN) {
                        return person.getAge() >= fromAge
                                && person.getAge() <= femaleToAge;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge) // Фільтруємо власників котів-жінок відповідного віку
                .flatMap(person -> person.getCats().stream()) // Витягуємо їхніх котів
                .map(Cat::getName) // Отримуємо імена котів
                .collect(Collectors.toList()); // Збираємо в список
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();

        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
