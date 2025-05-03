package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_LIVE = 10;
    public static final int SECOND_INDEX = 1;
    public static final int FIRST_INDEX = 0;
    public static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_LIVE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(SEPARATOR);
        return Integer.parseInt(periods[SECOND_INDEX]) - Integer.parseInt(periods[FIRST_INDEX]);
    }
}
