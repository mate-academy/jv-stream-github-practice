package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final int FIRSTPIECEOFDATE = 0;
    private static final int SECONDPIECEOFDATE = 1;

    private boolean isResidentBeenInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");

        int startYear = Integer.parseInt(years[FIRSTPIECEOFDATE]);
        int endYear = Integer.parseInt(years[SECONDPIECEOFDATE]);

        return endYear - startYear >= MIN_PERIOD_IN_UKRAINE;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && isResidentBeenInUkraine(candidate.getPeriodsInUkr());
    }
}
