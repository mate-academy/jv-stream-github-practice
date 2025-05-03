package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN = "Ukrainian";
    private static final int MIN_DURATION = 10;
    private static final String PERIOD_DELIMITER = "-";
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && getDurationInYears(candidate.getPeriodsInUkr()) >= MIN_DURATION;
    }

    private int getDurationInYears(String periodsInUkr) {
        String[] data = periodsInUkr.split(PERIOD_DELIMITER);
        return Integer.parseInt(data[INDEX_YEAR_TO]) - Integer.parseInt(data[INDEX_YEAR_FROM]);
    }
}
