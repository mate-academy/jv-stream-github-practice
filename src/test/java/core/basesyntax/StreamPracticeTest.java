package core.basesyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import model.Candidate;
import model.Cat;
import model.Person;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import practice.CandidateValidator;
import practice.StreamPractice;

public class StreamPracticeTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private static StreamPractice solution;
    private static List<Person> peopleListWithoutCat;
    private static List<Candidate> candidates;
    private static List<Candidate> invalidCandidates;
    private static List<Person> peopleList;

    @BeforeClass
    public static void setUp() {
        solution = new StreamPractice();
        peopleList = new ArrayList<>();
        peopleList.add(new Person("Victor", 16, Person.Sex.MAN));
        peopleList.add(new Person("Peter", 23, Person.Sex.MAN));
        peopleList.add(new Person("Helen", 42, Person.Sex.WOMAN, new ArrayList<>()));
        peopleList.get(2).getCats().add(new Cat("Tom", 2));
        peopleList.get(2).getCats().add(new Cat("Leo", 3));
        peopleList.add(new Person("Jack Johnson", 69, Person.Sex.MAN));
        peopleList.add(new Person("Rick", 37, Person.Sex.MAN, new ArrayList<>()));
        peopleList.get(4).getCats().add(new Cat("Chloe", 1));
        peopleList.add(new Person("Mary", 25, Person.Sex.WOMAN, new ArrayList<>()));
        peopleList.get(5).getCats().add(new Cat("Sunny", 1));
        peopleList.add(new Person("Emma Stuart", 55, Person.Sex.WOMAN, new ArrayList<>()));
        peopleList.add(new Person("Alice Stone", 57, Person.Sex.WOMAN, new ArrayList<>()));
        peopleList.get(6).getCats().add(new Cat("Kitty", 3));
        peopleList.get(6).getCats().add(new Cat("Fluffy", 4));
        peopleList.add(new Person("Janice Dean", 18, Person.Sex.WOMAN, new ArrayList<>()));
        peopleList.get(7).getCats().add(new Cat("Jackie", 2));
        peopleList.add(new Person("Roman", 25, Person.Sex.MAN));
        peopleList.add(new Person("Carlos", 60, Person.Sex.MAN));
        peopleList.add(new Person("Kate", 10, Person.Sex.WOMAN));
        peopleListWithoutCat = new ArrayList<>();
        peopleListWithoutCat.add(new Person("Helen", 16, Person.Sex.WOMAN));
        peopleListWithoutCat.add(new Person("Mary", 25, Person.Sex.WOMAN));
        peopleListWithoutCat.add(new Person("Emma Stuart", 20, Person.Sex.WOMAN));
        peopleListWithoutCat.add(new Person("Victor", 23, Person.Sex.MAN));
        candidates = initCandidateList();
        invalidCandidates = initInvalidCandidateList();
    }

    @Test
    public void findMinEvenNumber_basicData() {
        List<String> basicInput = List.of("12,11,5", "1,22,757", "71", "39,31,55,148",
                "3,2,2,5", "27,44,89", "12,11,5", "64,22,757");
        int expected = 2;
        Assert.assertEquals(String.format("Incorrect min value for the input - %s\n",
                basicInput), expected, solution.findMinEvenNumber(basicInput));
    }

    @Test
    public void findMinEvenNumber_negativeData() {
        List<String> basicInput = List.of("8,14,5", "3,-22,800", "-71", "20,98,45,98",
                "1,49,2,5", "27,12,89", "56,3,5", "12,-22,320");
        int expected = -22;
        Assert.assertEquals(String.format("Incorrect min value for the input - %s\n",
                basicInput), expected, solution.findMinEvenNumber(basicInput));
    }

    @Test
    public void findMinEvenNumber_emptyData() {
        List<String> basicInput = Collections.EMPTY_LIST;
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Can't get min value from list");
        solution.findMinEvenNumber(basicInput);
    }

    @Test
    public void getOddNumbersAverage_basicData() {
        Double expected = 2.0;
        List<Integer> digits = Arrays.asList(6, 2, 3, 7, 2, 5);
        // 6 1 3 6 2 4
        // 1 3
        Double result = solution.getOddNumbersAverage(digits);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getOddNumbersAverage_twoEven() {
        Double expected = 4.0;
        List<Integer> digits = Arrays.asList(7, 2, 3, 4, 5, 6);
        Double result = solution.getOddNumbersAverage(digits);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getOddNumsAverage_twoOdd() {
        Double expected = 3.0;
        List<Integer> digits = Arrays.asList(6, 4, 8, 7, 2, 5);
        Double result = solution.getOddNumbersAverage(digits);
        Assert.assertEquals(expected, result);
    }

    @Test(expected = NoSuchElementException.class)
    public void getOddNumbersAverage_empty() {
        Double expected = 2.0;
        List<Integer> digits = Arrays.asList(6, 1, 2, 7, 2, 5);
        Double result = solution.getOddNumbersAverage(digits);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getOddNumbersAverage_repeatedNumbers() {
        Double expected = 4.0;
        List<Integer> digits = Arrays.asList(6, 5, 7, 7, 1, 9, 10, 11);
        Double result = solution.getOddNumbersAverage(digits);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void selectMenByAge_basicData() {
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Peter", 23, Person.Sex.MAN));
        expected.add(new Person("Rick", 37, Person.Sex.MAN));
        expected.get(1).getCats().add(new Cat("Chloe", 1));
        expected.add(new Person("Roman", 25, Person.Sex.MAN));
        List<Person> result = solution.selectMenByAge(peopleList, 18, 37);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void selectMenByAge_absent() {
        List<Person> expected = new ArrayList<>();
        List<Person> result = solution.selectMenByAge(peopleList, 14, 15);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getWorkablePeople_basicData() {
        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Peter", 23, Person.Sex.MAN));
        expected.add(new Person("Helen", 42, Person.Sex.WOMAN, new ArrayList<>()));
        expected.get(1).getCats().add(new Cat("Tom", 2));
        expected.get(1).getCats().add(new Cat("Leo", 3));
        expected.add(new Person("Rick", 37, Person.Sex.MAN, new ArrayList<>()));
        expected.get(2).getCats().add(new Cat("Chloe", 1));
        expected.add(new Person("Mary", 25, Person.Sex.WOMAN, new ArrayList<>()));
        expected.get(3).getCats().add(new Cat("Sunny", 1));
        expected.add(new Person("Emma Stuart", 55, Person.Sex.WOMAN, new ArrayList<>()));
        expected.get(4).getCats().add(new Cat("Kitty", 3));
        expected.get(4).getCats().add(new Cat("Fluffy", 4));
        expected.add(new Person("Janice Dean", 18, Person.Sex.WOMAN, new ArrayList<>()));
        expected.add(new Person("Roman", 25, Person.Sex.MAN));
        expected.add(new Person("Carlos", 60, Person.Sex.MAN));
        List<Person> result = solution.getWorkablePeople(18, 55, 60, peopleList);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getWorkablePeople_absent() {
        List<Person> expected = new ArrayList<>();
        List<Person> result = solution.getWorkablePeople(12, 14, 15, peopleList);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getCatsNames_basicDate() {
        List<String> expected = Arrays.asList("Tom", "Leo", "Sunny", "Kitty", "Fluffy", "Jackie");
        List<String> result = solution.getCatsNames(peopleList, 18);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getCatsNames_emptyList() {
        List<String> expected = new ArrayList<>();
        List<String> result = solution.getCatsNames(peopleListWithoutCat, 18);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getCatsNames_absent() {
        List<String> expected = new ArrayList<>();
        List<String> result = solution.getCatsNames(peopleList, 60);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void validateCandidates_validatePredicate() {
        CandidateValidator validator = new CandidateValidator();
        Assert.assertTrue("Your CandidateValidator should "
                        + "implement functional interface Predicate, "
                        + "so it can be easily reused in the code",
                validator instanceof Predicate);
    }

    @Test
    public void validateCandidates_basicData() {
        List<String> expected = List.of("Casey", "Morty", "Philip");
        Assert.assertEquals(String.format("Incorrect result list of names for the input - %s\n",
                candidates), expected, solution.validateCandidates(candidates));
    }

    @Test
    public void validateCandidates_invalidData() {
        List<String> expected = Collections.EMPTY_LIST;
        Assert.assertEquals(String.format("Incorrect result list of names for the input - %s\n",
                invalidCandidates), expected, solution.validateCandidates(invalidCandidates));
    }

    @Test
    public void validateCandidates_emptyData() {
        List<Candidate> emptyList = Collections.EMPTY_LIST;
        List<String> expected = Collections.EMPTY_LIST;
        Assert.assertEquals(String.format("Incorrect result list of names for the input - %s\n",
                emptyList), expected, solution.validateCandidates(emptyList));
    }

    private static List<Candidate> initInvalidCandidateList() {
        Candidate john = new Candidate(30, "Ukrainian", false, "1985-2020");
        john.setName("John");
        Candidate fred = new Candidate(39, "German", true, "2000-2019");
        fred.setName("Fred");
        Candidate casey = new Candidate(61, "Ukrainian", true, "2011-2016");
        casey.setName("Casey");
        Candidate rick = new Candidate(44, "Ukrainian", false, "1990-2007");
        rick.setName("Rick");
        Candidate morty = new Candidate(35, "Frenchman", true, "2009-2020");
        morty.setName("Morty");
        Candidate ron = new Candidate(70, "Ukrainian", true, "2015-2020");
        ron.setName("Ron");
        Candidate phil = new Candidate(52, "Ukrainian", false, "1980-2013");
        phil.setName("Philip");
        return List.of(john, fred, rick, morty, casey, ron, phil);
    }

    private static List<Candidate> initCandidateList() {
        Candidate john = new Candidate(30, "Ukrainian", false, "1985-2020");
        john.setName("John");
        Candidate fred = new Candidate(39, "German", true, "2000-2019");
        fred.setName("Fred");
        Candidate casey = new Candidate(61, "Ukrainian", true, "1988-2000");
        casey.setName("Casey");
        Candidate rick = new Candidate(44, "Ukrainian", false, "1990-2007");
        rick.setName("Rick");
        Candidate morty = new Candidate(35, "Ukrainian", true, "2009-2020");
        morty.setName("Morty");
        Candidate ron = new Candidate(70, "Ukrainian", true, "2015-2020");
        ron.setName("Ron");
        Candidate phil = new Candidate(52, "Ukrainian", true, "1980-2013");
        phil.setName("Philip");
        return List.of(john, fred, rick, morty, casey, ron, phil);
    }
}
