package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int YEARS_TO_LIVE_IN_UKRAINE = 10;
    private static final int PRESIDENT_MIN_AGE = 35;
    private static final String YEARS_SPLITTER = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearInUkr = candidate.getPeriodsInUkr().split(YEARS_SPLITTER);
        int fromYear = Integer.parseInt(yearInUkr[FROM_YEAR_INDEX]);
        int toYear = Integer.parseInt(yearInUkr[TO_YEAR_INDEX]);
        return (toYear - fromYear) >= YEARS_TO_LIVE_IN_UKRAINE
                && candidate.getAge() >= PRESIDENT_MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
