package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS = 10;
    private static final int YEATS_OLD = 35;
    private static final String SPLITPER = "-";
    private static final String COUNTRY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SPLITPER);
        int from = Integer.parseInt(period[0].trim());
        int currentYear = Integer.parseInt(period[1].trim());
        boolean validPeriod = currentYear - from >= MIN_YEARS;

        return candidate.getAge() >= YEATS_OLD
                && validPeriod
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(COUNTRY);
    }
}
