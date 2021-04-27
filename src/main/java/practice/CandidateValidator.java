package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int HAS_LIVING_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && liveInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean liveInUkraine(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= HAS_LIVING_IN_UKRAINE;
    }
}
