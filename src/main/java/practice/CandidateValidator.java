package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REGEX_DASH = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN = "Ukrainian";
    private static final int MIN_TOTAL_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(REGEX_DASH);
        int totalYears = Integer.parseInt(periods[TO_YEAR_INDEX])
                - Integer.parseInt(periods[FROM_YEAR_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && totalYears >= MIN_TOTAL_YEARS;
    }
}
