package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String PERIODS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] periodSeparated = periodsInUkr.split(PERIODS_SEPARATOR);
        return Integer.parseInt(
                periodSeparated[1]) - Integer.parseInt(periodSeparated[0]);
    }
}
