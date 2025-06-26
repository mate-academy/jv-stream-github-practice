package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATES_SPLIT = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_IN_UKR = 10;
    private static final String UKR = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(DATES_SPLIT);
        dates[0] = dates[0].trim();
        dates[1] = dates[1].trim();
        int inUkr = Integer.parseInt(dates[1]) - Integer.parseInt(dates[0]) + 1;
        return (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(UKR)
                && inUkr >= MIN_IN_UKR
                && candidate.isAllowedToVote());
    }
}
