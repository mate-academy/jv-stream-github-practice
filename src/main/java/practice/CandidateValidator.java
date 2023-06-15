package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int MIN_AGE = 35;
    static final String NATIONALITY = "Ukrainian";
    static final int MIN_PERIOD_IN_UKR = 10;
    static final int DATE_FROM = 0;
    static final int DATE_TO = 1;
    static final String SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitDate = candidate.getPeriodsInUkr().split(SPLIT);
        int periodInUkr = Integer.parseInt(splitDate[DATE_TO])
                - Integer.parseInt(splitDate[DATE_FROM]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodInUkr >= MIN_PERIOD_IN_UKR;
    }
}
