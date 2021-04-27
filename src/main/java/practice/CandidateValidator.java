
package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD = 10;
    private static final int LOWER_AGE = 35;
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInCountry = candidate.getPeriodsInUkr().split(SEPARATOR);
        int years = Integer.parseInt(yearsInCountry[1])
                - Integer.parseInt(yearsInCountry[0]);
        return candidate.getAge() >= LOWER_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && years >= MIN_PERIOD;
    }
}
