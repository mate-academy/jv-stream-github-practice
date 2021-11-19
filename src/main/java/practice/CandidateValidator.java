package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static int MIN_TIME_IN_UKRAINE = 10;
    private static final int PERIOD_START_DATE_INDEX = 0;
    private static final int PERIOD_END_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int timeInUkraine = Integer.parseInt(years[PERIOD_END_DATE_INDEX])
                          - Integer.parseInt(years[PERIOD_START_DATE_INDEX]);
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && timeInUkraine >= MIN_TIME_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
