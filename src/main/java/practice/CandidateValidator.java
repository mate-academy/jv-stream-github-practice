package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_START_YEAR_RESIDENCE = 0;
    private static final int INDEX_FINISH_YEAR_RESIDENCE = 1;
    private static final int MIN_YEARS_RESIDENCE = 10;
    private static final int MIN_YEAR_OLD = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_YEAR_OLD && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && checkResidence(candidate);
    }

    private boolean checkResidence(Candidate candidate) {
        return ((Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_FINISH_YEAR_RESIDENCE])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_START_YEAR_RESIDENCE])) >= MIN_YEARS_RESIDENCE);
    }
}
