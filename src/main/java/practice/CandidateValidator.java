package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_TIME_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_FROM = 0;
    private static final int INDEX_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodSplit = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(periodSplit[INDEX_TO])
                - Integer.parseInt(periodSplit[INDEX_FROM]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkr >= MIN_TIME_IN_UKR;
    }
}
