package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVING_IN_UKRAINE = 10;
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TO = 1;
    private static final String YEAR_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && isLivingUkrainePeriod(candidate.getPeriodsInUkr());
    }

    private boolean isLivingUkrainePeriod(String periodsInUkraine) {
        String[] periods = periodsInUkraine.split(YEAR_SEPARATOR);
        return Integer.parseInt(periods[INDEX_YEAR_TO])
                - Integer.parseInt(periods[INDEX_YEAR_FROM]) > MIN_LIVING_IN_UKRAINE;
    }
}
