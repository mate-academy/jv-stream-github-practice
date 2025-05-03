package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && livedInUkraineForAtLeast(candidate.getPeriodsInUkr(), MIN_YEARS_IN_UKRAINE);
    }

    private boolean livedInUkraineForAtLeast(String periodsInUkr, int years) {
        String[] periods = periodsInUkr.split("-");
        if (periods.length != 2) {
            return false;
        }
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        return (endYear - startYear) >= years;
    }
}
