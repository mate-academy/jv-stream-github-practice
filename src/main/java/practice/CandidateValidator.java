package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONAL = "Ukrainian";
    private static final int PERIOD_LIFE = 10;
    private static final int MIN_YEARS = 35;
    private static final int DATE_FROM = 0;
    private static final int DATE_TO = 1;
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && getYearsInUkraine(candidate)
                && candidate.getAge() >= MIN_YEARS
                && candidate.getNationality().equals(NATIONAL);
    }

    private boolean getYearsInUkraine(Candidate candidate) {
        String[] temp = candidate.getPeriodsInUkr().split(REGEX);
        int yearFrom = Integer.parseInt(temp[DATE_FROM]);
        int yearTo = Integer.parseInt(temp[DATE_TO]);
        return (yearTo - yearFrom) >= PERIOD_LIFE;
    }
}
