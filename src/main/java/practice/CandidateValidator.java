package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int MIN_NEEDED_AGE = 35;
    static final String VALID_NATIONALITY = "Ukrainian";
    static final int MIN_NEEDED_LIVING_TIME = 10;
    static final int START_YEAR = 0;
    static final int STOP_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] livingFromTo = candidate.getPeriodsInUkr().split("-");
        int livingTime = Integer.parseInt(livingFromTo[STOP_YEAR])
                - Integer.parseInt(livingFromTo[START_YEAR]);
        return candidate.getAge() >= MIN_NEEDED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && livingTime > MIN_NEEDED_LIVING_TIME;
    }
}
