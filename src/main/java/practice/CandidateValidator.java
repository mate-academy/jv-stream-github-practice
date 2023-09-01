package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && livedInUkraineForTenYears(candidate);
    }

    private boolean livedInUkraineForTenYears(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(years[YEAR_TO_INDEX])
                - Integer.parseInt(years[YEAR_FROM_INDEX]) >= 10;
    }
}
