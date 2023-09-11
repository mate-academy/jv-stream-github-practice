package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final String SPLITERATOR = "-";
    public static final int FROM_YEAR_INDEX = 0;
    public static final int TO_YEAR_INDEX = 1;
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_LIVING_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int fromYear = Integer.parseInt(years[FROM_YEAR_INDEX]);
        int toYear = Integer.parseInt(years[TO_YEAR_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && toYear - fromYear >= MIN_LIVING_IN_UKRAINE;
    }
}
