package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONAL = "Ukrainian";
    private static final int MIN_YEARS_LIVE_IN_UKRAINE = 10;
    private static final int GET_YEAR_TO = 1;
    private static final int GET_YEAR_FROM = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int liveInUkr = Integer.parseInt(years[GET_YEAR_TO])
                - Integer.parseInt(years[GET_YEAR_FROM]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONAL)
                && liveInUkr >= MIN_YEARS_LIVE_IN_UKRAINE;
    }
}
