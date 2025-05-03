package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String SPLITTER = "-";
    private static final int FROM_INDEX = 1;
    private static final int TO_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && timeLivedInUkraine(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private static int timeLivedInUkraine(Candidate candidate) {
        String[] periodDate = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(periodDate[FROM_INDEX]) - Integer.parseInt(periodDate[TO_INDEX]);
    }

}
