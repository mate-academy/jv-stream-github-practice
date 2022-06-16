package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int YEAR_WHEN_CANDIDATE_BEGIN_LIVING_IN_UKRAINE = 0;
    private static final int YEAR_WHEN_CANDIDATE_END_LIVING_IN_UKRAINE = 1;
    private static final String REQUIRED_NATIOANLITY = "Ukrainian";
    private static final String DELIMETR = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MINIMUM_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals(REQUIRED_NATIOANLITY)) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split(DELIMETR);
        int[] yearsInt = new int[years.length];
        yearsInt[YEAR_WHEN_CANDIDATE_BEGIN_LIVING_IN_UKRAINE] =
                Integer.parseInt(years[YEAR_WHEN_CANDIDATE_BEGIN_LIVING_IN_UKRAINE]);
        yearsInt[YEAR_WHEN_CANDIDATE_END_LIVING_IN_UKRAINE] =
                Integer.parseInt(years[YEAR_WHEN_CANDIDATE_END_LIVING_IN_UKRAINE]);
        return yearsInt[1] - yearsInt[0] >= 10;
    }
}
