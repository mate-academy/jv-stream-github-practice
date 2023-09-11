package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_REQUIRED_AGE = 35;
    private static final String CANDIDATE_REQUIRED_NATIONALITY = "Ukrainian";
    private static final int CANDIDATE_REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final String SPLITERATOR = "-";

    private int getCandidateYearsInUkraine(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(SPLITERATOR);
        return Integer.parseInt(periodInUkraine[1]) - Integer.parseInt(periodInUkraine[0]);
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_REQUIRED_AGE
                && candidate.getNationality().equals(CANDIDATE_REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && getCandidateYearsInUkraine(candidate) >= CANDIDATE_REQUIRED_YEARS_IN_UKRAINE;
    }
}
