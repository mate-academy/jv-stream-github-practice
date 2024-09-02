package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_OF_CANDIDATE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int PARSED_FROM = 0;
    private static final int PARSED_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_OF_CANDIDATE
                && candidate.isAllowedToVote() == true
                && candidate.getNationality().equals(NATIONALITY)
                && getCandidatesPeriodInUkr(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getCandidatesPeriodInUkr(Candidate candidate) {
        String[] periodsFromTo = candidate.getPeriodsInUkr().split("-");
        int periodTo = Integer.parseInt(periodsFromTo[PARSED_TO]);
        int periodFrom = Integer.parseInt(periodsFromTo[PARSED_FROM]);
        return periodTo - periodFrom;
    }
}
