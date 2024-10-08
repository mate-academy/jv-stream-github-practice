package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] time = candidate.getPeriodsInUkr().split(DELIMITER);
        int startPeriod = Integer.parseInt(time[0]);
        int finishPeriod = Integer.parseInt(time[1]);

        return (finishPeriod - startPeriod) >= MIN_PERIODS_IN_UKRAINE;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }
}
