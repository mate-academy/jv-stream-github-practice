package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
    private static final int REQUIRED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY
                && liveInUkraineForTenYears(candidate);

    }

    private boolean liveInUkraineForTenYears(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[START_YEAR]);
        int endYear = Integer.parseInt(periods[END_YEAR]);
        return endYear - startYear >= REQUIRED_PERIOD;
    }

}
