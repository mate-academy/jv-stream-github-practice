package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONAL = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final String SPLIT_SIMBOL = "-";
    private static final int START_YEARS_INDEX = 0;
    private static final int FINISH_YEARS_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !NATIONAL.equals(candidate.getNationality())) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().split(SPLIT_SIMBOL);
        int startYears = Integer.parseInt(years[START_YEARS_INDEX]);
        int finishYears = Integer.parseInt(years[FINISH_YEARS_INDEX]);

        if ((finishYears - startYears) < 10) {
            return false;
        }

        return true;
    }
}
