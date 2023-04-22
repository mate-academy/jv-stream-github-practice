package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {   
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(",")))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .stream()
                .filter(n -> n % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> 
                    new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(i -> changeNumberAtOddIndex(i, numbers.get(i)))
                .filter(n -> n % 2 != 0)
                .average()
                .getAsDouble();
    }
    
    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                    .filter(n -> n.getAge() >= fromAge 
                            && n.getAge() <= toAge 
                            && n.getSex() == Person.Sex.MAN)
                    .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                    .filter(p -> sortedMaleOrFamale(fromAge, femaleToAge, maleToAge, p))
                    .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                    .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge)
                    .flatMap(p -> p.getCats().stream())
                    .map(p -> p.getName())
                    .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                    .filter(c -> candidateValidator.test(c))
                    .map(c -> c.getName())
                    .sorted()
                    .collect(Collectors.toList());
    }
    
    private int changeNumberAtOddIndex(int index, int number) {
        return index % 2 != 0 ? number - 1 : number;
    }
    
    private boolean sortedMaleOrFamale(int fromAge, int femaleToAge, int maleToAge, Person p) {
        return p.getSex() == Person.Sex.MAN 
                ? p.getAge() >= fromAge && p.getAge() <= maleToAge 
                : p.getAge() >= fromAge && p.getAge() <= femaleToAge;
    }
}
