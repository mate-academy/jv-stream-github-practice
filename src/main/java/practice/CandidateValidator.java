package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_TO_VOTE = "Ukrainian";
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final int MIN_YEARS_LIVE_TO_VOTE = 10;
    private static final int FIRST_YEAR_COLUMN = 0;
    private static final int LAST_YEAR_COLUMN = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE_TO_VOTE
            && candidate.getNationality().equals(NATIONALITY_TO_VOTE)
            && candidate.isAllowedToVote()
            && Integer.parseInt(years[LAST_YEAR_COLUMN])
             - Integer.parseInt(years[FIRST_YEAR_COLUMN]) > MIN_YEARS_LIVE_TO_VOTE;
    }
}
