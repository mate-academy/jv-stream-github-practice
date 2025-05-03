package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && isValidByResidenceInUkraine(candidate);
    }

    private boolean isValidByResidenceInUkraine(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(dates[END_YEAR_INDEX])
                - Integer.parseInt(dates[START_YEAR_INDEX]) >= MIN_PERIOD_IN_UKRAINE;
    }
}
