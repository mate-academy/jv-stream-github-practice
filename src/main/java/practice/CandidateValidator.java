package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && NATIONALITY.equals(c.getNationality())
                && yearsInUkraine(c.getPeriodsInUkr()) >= REQUIRED_YEARS;
    }

    private int yearsInUkraine(String periods) {
        String[] years = periods.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
