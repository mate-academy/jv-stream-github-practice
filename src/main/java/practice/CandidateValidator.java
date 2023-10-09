package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int yearFrom = Integer.parseInt(yearInUkraine[FROM_YEAR_INDEX]);
        int yearTo = Integer.parseInt(yearInUkraine[TO_YEAR_INDEX]);
        int yearsInUkraine = yearTo - yearFrom;

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= YEARS_IN_UKRAINE;
    }


    //write your code here
}
