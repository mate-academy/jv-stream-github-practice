package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static int REQUIRED_AGE = 35;
    private static String REQUIRED_NATIONALITY = "Ukrainian";
    private static int requiredResidencyYears = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .filter(s -> Character.isDigit(s.charAt(0)))
                .mapToInt(Integer::valueOf)
                .reduce((x, y) -> y - x)
                .orElse(0) >= requiredResidencyYears;
    }
}
