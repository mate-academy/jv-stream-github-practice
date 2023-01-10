package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_YEARS_WAS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::valueOf)
                .reduce((x,y) -> y - x)
                .getAsInt();
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MINIMAL_AGE
                && yearsInUkraine >= MINIMAL_YEARS_WAS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    //write your code here
}
