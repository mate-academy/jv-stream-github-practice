package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static String NATIONALITY = "Ukrainian";
    private static final int PERIOD = 10;
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return checkAge(candidate)
                && checkNationality(candidate)
                && checkPeriod(candidate)
                && candidate.isAllowedToVote();
    }

    public boolean checkAge(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE;
    }

    public boolean checkNationality(Candidate candidate) {
        return candidate.getNationality().equals(NATIONALITY);
    }

    public boolean checkPeriod(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int diff = Integer.parseInt(split[END_PERIOD_INDEX])
                - Integer.parseInt(split[START_PERIOD_INDEX]);
        return diff >= PERIOD;
    }
}

