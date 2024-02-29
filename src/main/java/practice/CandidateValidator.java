package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY
                && hasLivedInUkraineForTenYears(candidate);
    }

    private boolean hasLivedInUkraineForTenYears(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        if (Integer.parseInt(split[1]) - Integer.parseInt(split[0]) >= 10) {
            return true;
        }
        return false;
    }
}

