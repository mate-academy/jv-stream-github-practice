package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0,22,7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: < Here is our input 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(n -> n.split(","))
                .flatMap(n -> Arrays.stream(n))
                .mapToInt(n -> Integer.parseInt(n))
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    /**
     * Дан список целых чисел; нужно вычесть 1 из каждого элемента,
     * находящегося на нечетной позиции (имеющего нечетный индекс). Затем следует
     * вернуть среднее арифметическое всех нечетных чисел или выбросить
     * исключение `NoSuchElementException`.
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0,numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
        //.orElseThrow(() -> new NoSuchElementException()); //
    }

    /**
     * Given a List of `Person` instances (having `name`, `age` and `sex` fields),
     * for example, `Arrays.asList( new Person(«Victor», 16, Sex.MAN),
     * new Person(«Helen», 42, Sex.WOMAN))`,
     * select from the List only men whose age is from `fromAge` to `toAge` inclusively.
     * <p>
     * Example: select men who can be recruited to army (from 18 to 27 years old inclusively).
     *
     * Имея список экземпляров класса `Person` (с полями `name`, `age` и `sex`),
     * * например, `Arrays.asList( new Person("Victor", 16, Sex.MAN),
     * * new Person("Helen", 42, Sex.WOMAN))`,
     * * выберите из списка только мужчин в возрасте от `fromAge` до `toAge` включительно.
     * * <p>
     * * Пример: выбор мужчин, подлежащих призыву в армию (от 18 до 27 лет включительно)
     */
    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> (p.getSex().equals(Person.Sex.MAN)
                && p.getAge() >= fromAge
                && p.getAge() <= toAge))
                .collect(Collectors.toList());
    }

    /**
     * Дан список объектов класса `People`
     * (с полями `name`, `age` и `sex`; например:
     *  `Arrays.asList(new People("Victor", 16, Sex.MAN), new People("Helen", 42, Sex.WOMEN))`);
     *   нужно выбрать из списка только мужчин, возраст которых находится
     *  в диапазоне от `fromAge` до `toAge` включительно. Пример: выбор мужчин,
     *   подлежащих призыву в армию (от 18 до 27 лет включительно).
     */
    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> (p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge
                && p.getAge() <= maleToAge)
                || (p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= femaleToAge))
                        .collect(Collectors.toList());
    }

    /**
     * Given a List of `Person` instances (having `name`, `age`, `sex` and `cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     *
     * На основе списка объектов `Person` (с полями `name`, `age`, `sex` и `cats`,
     * * где каждый объект `Cat` имеет поля `name` и `age`)
     * * верните имена всех кошек, чьи владельцы — женщины
     * в возрасте от `femaleAge` лет (включительно).
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(w -> (w.getSex().equals(Person.Sex.WOMAN)
                && w.getAge() >= femaleAge))
                .flatMap(w -> w.getCats().stream())
                .map(Cat::getName)
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
     *
     * Требуется помощь в проведении выборов. Дан список кандидатов (объектов класса `Candidate`).
     * * Необходимо определить, кто из них соответствует требованиям для выдвижения
     * на пост президента,
     * * и вернуть список их имен, отсортированный в алфавитном порядке.
     * * Требования: возраст старше 35 лет, наличие избирательного права,
     * * гражданство — «Ukrainian» (украинское),
     * * а также проживание в Украине в течение 10 лет. Для проверки последнего условия
     * используйте поле `periodsInUkr`,
     * * имеющее формат строки, например: "2002-2015".
     * * Поскольку мы хотим использовать эту проверку повторно в будущем, давайте
     * реализуем собственный
     * * вариант интерфейса `Predicate` (параметризованный типом `Candidate`) в
     * классе `CandidateValidator`.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
