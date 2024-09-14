package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_YEAR_PART = 0;
    private static final int END_YEAR_PART = 1;
    private static final String SEPARATION_PLACE = "-";
    private static final int VOTING_AGE = 35;
    private static final int MUST_HAVE_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SEPARATION_PLACE);
        int startYear = Integer.parseInt(dates[START_YEAR_PART]);
        int endYear = Integer.parseInt(dates[END_YEAR_PART]);
        return candidate.getAge() >= VOTING_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && endYear - startYear >= MUST_HAVE_YEARS_IN_UKRAINE;
    }
}

