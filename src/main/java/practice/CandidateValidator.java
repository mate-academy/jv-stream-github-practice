package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final int END_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livedInUkraine(candidate) >= MIN_YEARS_IN_UKRAINE;
    }

    private int livedInUkraine(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(data[END_INDEX]) - Integer.parseInt(data[START_INDEX]);
    }
}
