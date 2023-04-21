package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= AGE
                && candidate.getNationality().equals(NATIONALITY) && getPeriod(candidate) >= 10;
    }

    private int getPeriod(Candidate candidate) {
        String[] periodOfYear = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodOfYear[1]) - Integer.parseInt(periodOfYear[0]);
    }
}
