package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    private static final String DELIMETR = ","; 

    public int findMinEvenNumber(List<String> numbers) {   
        return numbers.stream()
                .flatMap(line -> Arrays.stream(line.split(DELIMETR)))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> 
                    new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(index -> changeNumberAtOddIndex(index, numbers.get(index)))
                .filter(number -> number % 2 != 0)
                .average()
                .getAsDouble();
    }
    
    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                    .filter(people -> people.getAge() >= fromAge 
                            && people.getAge() <= toAge 
                            && people.getSex() == Person.Sex.MAN)
                    .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                    .filter(person -> sortedMaleOrFamale(fromAge, femaleToAge, maleToAge, person))
                    .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                    .filter(person -> person.getSex() == Person.Sex.WOMAN 
                                          && person.getAge() >= femaleAge)
                    .flatMap(person -> person.getCats().stream())
                    .map(cat -> cat.getName())
                    .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                    .filter(candidate -> candidateValidator.test(candidate))
                    .map(candidate -> candidate.getName())
                    .sorted()
                    .collect(Collectors.toList());
    }
    
    private int changeNumberAtOddIndex(int index, int number) {
        return index % 2 != 0 ? number - 1 : number;
    }
    
    private boolean sortedMaleOrFamale(int fromAge, int femaleToAge, int maleToAge, Person person) {
        return person.getSex() == Person.Sex.MAN 
                ? person.getAge() >= fromAge && person.getAge() <= maleToAge 
                : person.getAge() >= fromAge && person.getAge() <= femaleToAge;
    }
}
