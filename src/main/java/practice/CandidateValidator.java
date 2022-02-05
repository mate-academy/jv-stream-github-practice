package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearFromToYearInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(yearFromToYearInUkraine[0]);
        int yearTo = Integer.parseInt(yearFromToYearInUkraine[1]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && yearTo - yearFrom >= MIN_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
