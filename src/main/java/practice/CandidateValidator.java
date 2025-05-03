package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final int MIN_ELIGIBLE_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String DIVIDER = "-";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(DIVIDER);
        int startYear = Integer.parseInt(periods[FIRST_ELEMENT]);
        int endYear = Integer.parseInt(periods[SECOND_ELEMENT]);

        return candidate.getNationality().equals(UKRAINIAN)
                && (endYear - startYear) >= MIN_YEARS_IN_UKRAINE
                && candidate.getAge() >= MIN_ELIGIBLE_AGE
                && candidate.isAllowedToVote();
    }
}
