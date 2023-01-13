package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final int MIN_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int START_LIVING = 0;
    private static final int FINISH_LIVING = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return getPeriodsInUkr(candidate.getPeriodsInUkr()) > MIN_YEARS_IN_UKR
                && candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY);
    }

    private int getPeriodsInUkr(String getPeriodsInUkr) {
        String[] period = getPeriodsInUkr.split(SEPARATOR);
        return Integer.parseInt(period[FINISH_LIVING]) - Integer.parseInt(period[START_LIVING]);
    }
}
