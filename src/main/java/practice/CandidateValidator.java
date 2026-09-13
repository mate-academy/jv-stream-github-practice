package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final int LIVE_IN_UKR = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] years = period.split("-");
        int startYear = Integer.parseInt(years[START_YEAR]);
        int endYear = Integer.parseInt(years[END_YEAR]);
        int yearsInUkr = endYear - startYear;
        if (candidate.getAge() >= CANDIDATE_AGE
                    && candidate.isAllowedToVote()
                    && candidate.getNationality().equals(NATIONALITY)
                    && yearsInUkr >= LIVE_IN_UKR) {
            return true;
        }
        return false;
    }
}
