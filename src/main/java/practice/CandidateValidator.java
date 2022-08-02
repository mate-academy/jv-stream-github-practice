package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int YEAR_TO_INDEX = 1;
    private static final int YEAR_FROM_INDEX = 0;
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final String SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(SPLIT_REGEX);
        int duration = Integer.parseInt(periodsInUkraine[YEAR_TO_INDEX])
                - Integer.parseInt(periodsInUkraine[YEAR_FROM_INDEX]);
        return candidate.getAge() >= MINIMAL_REQUIRED_AGE
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && duration >= REQUIRED_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
