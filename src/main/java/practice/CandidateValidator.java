package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int VALID_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int PERIOD_OF_LIVING = 10;
    public static final String SEPARATOR = "-";
    public static final int INDEX_OF_LIVING_START = 0;
    public static final int INDEX_OF_LIVING_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= PERIOD_OF_LIVING;
    }

    private int yearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(SEPARATOR);
        int startYear = Integer.parseInt(periods[INDEX_OF_LIVING_START]);
        int endYear = Integer.parseInt(periods[INDEX_OF_LIVING_END]);
        return endYear - startYear + 1;
    }
}
