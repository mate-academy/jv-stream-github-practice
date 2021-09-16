package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int END_YEAR_IN_UKRAINE = 1;
    private static final int START_YEAR_IN_UKRAINE = 0;
    private static final int LIVED_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(years[END_YEAR_IN_UKRAINE])
                - Integer.parseInt(years[START_YEAR_IN_UKRAINE]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= LIVED_IN_UKRAINE;
    }
}
