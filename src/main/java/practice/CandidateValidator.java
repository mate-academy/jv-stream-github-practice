package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int MINIMAL_CANDIDATE_PERIOD_IN_COUNTRY = 10;
    private static final String CANDIDATE_PERIOD_FORMAT_SPLITTER = "-";
    private static final int CANDIDATE_PERIOD_FORMAT_LAST_YEAR = 1;
    private static final int CANDIDATE_PERIOD_FORMAT_FIRST_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMAL_CANDIDATE_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && checkPeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriodInUkraine(String period) {
        String[] years = period.split(CANDIDATE_PERIOD_FORMAT_SPLITTER);
        int yearsInUkraine = Integer.parseInt(years[CANDIDATE_PERIOD_FORMAT_LAST_YEAR])
                - Integer.parseInt(years[CANDIDATE_PERIOD_FORMAT_FIRST_YEAR]);
        return yearsInUkraine >= MINIMAL_CANDIDATE_PERIOD_IN_COUNTRY;
    }
}
