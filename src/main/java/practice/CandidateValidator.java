package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_POSITION = 0;
    private static final int SECOND_POSITION = 1;
    private static final int MINIMAL_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final String REGEX_PATTERN = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriod(candidate.getPeriodsInUkr()) >= LIVING_PERIOD;
    }

    private int calculatePeriod(String period) {
        String[] years = period.split(REGEX_PATTERN);
        return Integer.parseInt(years[SECOND_POSITION]) - Integer.parseInt(years[FIRST_POSITION]);
    }
}
