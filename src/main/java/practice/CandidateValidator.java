package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        int yearsInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return yearsInUkraine >= PERIODS_IN_UKRAINE
                && candidate.getAge() >= AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
