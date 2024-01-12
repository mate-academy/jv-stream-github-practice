package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDAT = 35;
    private static final int MIN_PERIOD_LIVED = 10;
    private static final int START_YEAR = 0;
    private static final int AND_YEAR = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDAT
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && hasLivedInUkraine(candidate);
    }

    private boolean hasLivedInUkraine(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startYear = Integer.parseInt(periods[START_YEAR]);
        int endYear = Integer.parseInt(periods[AND_YEAR]);
        return endYear - startYear >= MIN_PERIOD_LIVED;
    }
}

