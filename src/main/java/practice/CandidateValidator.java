package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (calculatePeriodInUkraine(candidate.getPeriodsInUkr())) > MIN_PERIOD;
    }

    private int calculatePeriodInUkraine(String period) {
        String[] years = period.split(PERIOD_SEPARATOR);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
