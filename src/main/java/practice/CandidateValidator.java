package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VOTING_AGE = 35;
    private static final int MIN_LIVE_YEARS = 10;
    private static final int LIVES_FROM = 0;
    private static final int LIVES_TO = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[LIVES_TO]) - Integer.parseInt(years[LIVES_FROM]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_VOTING_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && period >= MIN_LIVE_YEARS;
    }
}