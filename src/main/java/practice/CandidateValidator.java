package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_REQUIRED_AGE
                && c.isAllowedToVote()
                && c.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkraine(c.getPeriodsInUkr()) >= REQUIRED_YEARS_IN_UKRAINE;
    }

    private int yearsInUkraine(String years) {
        String[] dates = years.split("-");
        return Integer.parseInt(dates[1]) - Integer.parseInt(dates[0]);
    }
}
