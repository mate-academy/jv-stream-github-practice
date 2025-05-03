package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int PERIOD_OF_RESIDENCE = 10;
    public static final int START_INDEX_OF_RESIDENCE = 0;
    public static final int END_INDEX_OF_RESIDENCE = 1;
    public static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= PERIOD_OF_RESIDENCE;
    }

    private int yearsInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(SEPARATOR);
        int startYear = Integer.parseInt(periods[START_INDEX_OF_RESIDENCE]);
        int endYear = Integer.parseInt(periods[END_INDEX_OF_RESIDENCE]);
        return endYear - startYear;
    }
}
