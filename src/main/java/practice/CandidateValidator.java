package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_CANDIDATE_PERIOD_IN_UKRAINE = 10;
    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split("-");
        int firstYear = Integer.parseInt(years[0]);
        int lastYear = Integer.parseInt(years[1]);
        int peroid = lastYear - firstYear;
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && peroid >= MIN_CANDIDATE_PERIOD_IN_UKRAINE;
    }
}

