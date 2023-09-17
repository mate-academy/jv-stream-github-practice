package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int LIVED_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(SEPARATOR);
        int yearFrom = Integer.parseInt(periodInUkr[FROM_YEAR_INDEX]);
        int yearTo = Integer.parseInt(periodInUkr[TO_YEAR_INDEX]);
        int yearsLivedInUkr = yearTo - yearFrom;

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsLivedInUkr >= LIVED_IN_UKRAINE;
    }
}
