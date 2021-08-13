package practice;

import java.time.Year;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int YEARS_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return Year.parse(candidate.getPeriodsInUkr().substring(5, 9)).getValue()
                - Year.parse(candidate.getPeriodsInUkr().substring(0, 4)).getValue()
                >= YEARS_IN_UKRAINE
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY);
    }
}
