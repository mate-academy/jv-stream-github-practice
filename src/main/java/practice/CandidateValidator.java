package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_YEAR = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEAR_OF_RESIDENCE = 10;
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TILL = 1;
    private static final String SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ALLOWED_YEAR
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodOfResidence(candidate) >= MIN_YEAR_OF_RESIDENCE;
    }

    private int periodOfResidence(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split(SPLIT);
        int since = Integer.parseInt(year[YEAR_FROM]);
        int till = Integer.parseInt(year[YEAR_TILL]);
        return till - since;
    }
}

