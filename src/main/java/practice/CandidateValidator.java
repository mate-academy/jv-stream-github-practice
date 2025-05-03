package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int END_PERIOD = 1;
    private static final int START_PERIOD = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && requirementYearsOfLiving(candidate) >= MIN_PERIODS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int requirementYearsOfLiving(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(years[END_PERIOD])
                - Integer.parseInt(years[START_PERIOD]);
    }
}
