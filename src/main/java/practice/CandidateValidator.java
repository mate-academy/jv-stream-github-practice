package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && numberOfYearsInUkr(candidate.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;
    }

    private int numberOfYearsInUkr(String periodsInUkr) {
        String[] yearsString = periodsInUkr.split("-");
        return Integer.parseInt(yearsString[1]) - Integer.parseInt(yearsString[0]);
    }
}
