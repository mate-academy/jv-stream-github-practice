package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_DATE = 0;
    private static final int END_DATE = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraineToInt(candidate.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;
    }

    private int periodInUkraineToInt(String years) {
        String[] period = years.split("-");
        return Integer.parseInt(period[END_DATE]) - Integer.parseInt(period[START_DATE]);
    }
}
