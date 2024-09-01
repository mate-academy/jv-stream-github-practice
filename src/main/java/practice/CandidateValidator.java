package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int AGE_OF_CANDIDATE = 35;
    static final String NATIONALITY = "Ukrainian";
    static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_OF_CANDIDATE
                && candidate.isAllowedToVote() == true
                && candidate.getNationality().equals(NATIONALITY)
                && getCandidatesPeriodInUkr(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getCandidatesPeriodInUkr(Candidate candidate) {
        String[] periodsFromTo = candidate.getPeriodsInUkr().split("-");
        int periodTo = Integer.parseInt(periodsFromTo[1]);
        int periodFrom = Integer.parseInt(periodsFromTo[0]);
        return periodTo - periodFrom;
    }
}
