package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String SEPARATOR = "-";
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIOD_OF_LIVING_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatsPeriods = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startLivingYear = Integer.parseInt(candidatsPeriods[FIRST_INDEX]);
        int endLivingYear = Integer.parseInt(candidatsPeriods[LAST_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && endLivingYear - startLivingYear >= MINIMUM_PERIOD_OF_LIVING_IN_COUNTRY;
    }
}
