package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int REQUIERED_AGE = 35;
    private static final int TIME_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearToCompare = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= REQUIERED_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(yearToCompare[1]) - Integer.parseInt(yearToCompare[0])
                >= TIME_IN_UKRAINE;
    }
}
