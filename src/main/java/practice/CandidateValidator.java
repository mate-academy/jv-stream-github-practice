package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int START_YEAR_LIVING_IN_UKRAIN = 0;
    private static final int END_YEAR_LIVING_IN_UKRAIN = 1;
    private static final int MIN_TERM = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MIN_AGE) && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && calculatioTermOfLivingInUkraine(candidate) >= MIN_TERM;
    }

    private int calculatioTermOfLivingInUkraine(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startOfPeriod = Integer.parseInt(periods[START_YEAR_LIVING_IN_UKRAIN]);
        int endOfPeriod = Integer.parseInt(periods[END_YEAR_LIVING_IN_UKRAIN]);
        return endOfPeriod - startOfPeriod;
    }
}
