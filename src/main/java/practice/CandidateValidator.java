package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String HYPHEN = "-";
    private static final String UKR_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean isLegalToVote = candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote();
        boolean isUkrainian = candidate.getNationality().equals(UKR_NATIONALITY);
        boolean correctPeriodInUkr = getPeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD;

        return isLegalToVote && isUkrainian && correctPeriodInUkr;
    }

    private int getPeriodInUkr(String stringPeriod) {
        String[] arrPeriod = stringPeriod.split(HYPHEN);
        int from = Integer.parseInt(arrPeriod[0]);
        int to = Integer.parseInt(arrPeriod[1]);

        return to - from;
    }
}
