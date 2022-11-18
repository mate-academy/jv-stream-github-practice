package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEAR_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        String[] candidatePeriodsOfUA = candidate.getPeriodsInUkr().split("-");
        return (Integer.parseInt(candidatePeriodsOfUA[1])
                - Integer.parseInt(candidatePeriodsOfUA[0])) >= MIN_YEAR_IN_UA;
    }
}
