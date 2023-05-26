package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_TIME_LIVING_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getLivingInUkrTime(candidate) > MIN_TIME_LIVING_IN_UKR;
    }

    private int getLivingInUkrTime(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(years[TO_YEAR]) - Integer.parseInt(years[FROM_YEAR]);
    }
}
