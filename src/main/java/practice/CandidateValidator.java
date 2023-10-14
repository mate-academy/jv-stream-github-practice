package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int POSITION_YEAR_TO = 1;
    private static final int POSITION_YEAR_FROM = 0;
    private static final String DIVIDER = "-";
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && periodInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE);
    }

    private int periodInUkr(String period) {
        String[] years = period.split(DIVIDER);
        return Integer.parseInt(years[POSITION_YEAR_TO])
                - Integer.parseInt(years[POSITION_YEAR_FROM]);
    }
}
