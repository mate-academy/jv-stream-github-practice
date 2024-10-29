package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_LIVING_IN_COUNTRY = 10;
    private static final int INDEX_AGE_FROM = 0;
    private static final int INDEX_AGE_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int actualPeriod = 0;
        try {
            actualPeriod = Integer.parseInt(periodsInUkr[INDEX_AGE_TO])
                    - Integer.parseInt(periodsInUkr[INDEX_AGE_FROM]);
        } catch (NumberFormatException e) {
            System.out.println("wrong format periodsInUkr " + candidate.getPeriodsInUkr()
                    + "format periodsInUkr mus be:2002-2015");
        }
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && actualPeriod >= YEARS_LIVING_IN_COUNTRY
                && candidate.isAllowedToVote();
    }
}
