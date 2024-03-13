package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN = "Ukrainian";
    public static final int MIN_ELIGIBLE_AGE = 35;
    public static final int MIN_YEARS_IN_UKRAINE = 10;
    public static final String DIVIDER = "-";
    public static final int FIRST_ELEMENT = 0;
    public static final int SECOND_ELEMENT = 1;

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
