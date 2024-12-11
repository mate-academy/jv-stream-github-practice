package practice;

import java.util.function.Function;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_YEARS_LIVED_IN = 10;
    private static final int MINIMUM_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String YEARS_SEPARATOR = "-";
    private static final Function<Candidate, String[]> PeriodsInUkr = candidate
            -> candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);

    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(PeriodsInUkr.apply(candidate)[1])
                - Integer.parseInt(PeriodsInUkr.apply(candidate)[0])
                >= REQUIRED_YEARS_LIVED_IN;
    }
}
