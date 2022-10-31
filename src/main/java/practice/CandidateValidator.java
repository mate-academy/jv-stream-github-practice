package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VOTING_AGE = 35;
    private static final int NEEDED_PERIOD_IN_UKR = 10;
    private static final String UKR_NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VOTING_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && periodInUkr(candidate) >= NEEDED_PERIOD_IN_UKR;
    }

    private int periodInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DELIMITER);
        return Integer.parseInt(years[TO_YEAR_INDEX]) - Integer.parseInt(years[FROM_YEAR_INDEX]);
    }
}
