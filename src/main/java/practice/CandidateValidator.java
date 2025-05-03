package practice;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        periodsInUkrValidator(candidate);
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]) > 10;
    }

    private void periodsInUkrValidator(Candidate candidate) {
        if (Stream.of(candidate.getPeriodsInUkr())
                .map(String::chars)
                .flatMap(IntStream::boxed)
                .mapToInt(i -> i)
                .mapToObj(i -> (char) i)
                .anyMatch(Character::isLetter)) {
            throw new RuntimeException("Wrong Data format");
        }
    }
    //write your code here
}
