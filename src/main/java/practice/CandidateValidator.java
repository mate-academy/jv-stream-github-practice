package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY_REQUIRED.equals(candidate.getNationality())
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private int yearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split(DASH);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
