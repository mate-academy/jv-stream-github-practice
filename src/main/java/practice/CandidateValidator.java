package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATION = "Ukrainian";
    private static final int YEARS_IN_UKR = 10;
    private static final int PERIOD_FROM_DATE_INDEX = 0;
    private static final int PERIOD_TO_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int comeTo = Integer.parseInt(years[PERIOD_FROM_DATE_INDEX]);
        int comeOut = Integer.parseInt(years[PERIOD_TO_DATE_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATION)
                && comeOut - comeTo >= YEARS_IN_UKR;
    }
}
