package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONAL = "Ukrainian";
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !NATIONAL.equals(candidate.getNationality())) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYears = Integer.parseInt(years[0]);
        int finishYears = Integer.parseInt(years[1]);

        if ((finishYears - startYears) < 10) {
            return false;
        }

        return true;
    }
}
