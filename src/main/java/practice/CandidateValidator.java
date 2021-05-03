package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT);

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(years[TO_YEAR]) - Integer.parseInt(years[FROM_YEAR]))
                >= LIVE_IN_UKR;
    }
}
