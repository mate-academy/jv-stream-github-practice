package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String COUNTRY = "Ukrainian";
    public static final int MIN_YEARS_LIVE = 10;
    public static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(COUNTRY)
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_LIVE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(SEPARATOR);
        return Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
    }
}
