package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_SPENDED_IN_UKRAINE = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
    private static final String YEARS_SPLITER = "-";
    private static final String UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        String[] years = c.getPeriodsInUkr().split(YEARS_SPLITER);
        int yearsInUkraine = Integer.parseInt(years[END_YEAR])
                - Integer.parseInt(years[START_YEAR]);
        return c.getAge() >= MIN_AGE
                && c.getNationality().equals(UKRAINIAN)
                && c.isAllowedToVote()
                && yearsInUkraine >= MIN_YEARS_SPENDED_IN_UKRAINE;
    }
}
