package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");

        try {
            int from = Integer.parseInt(years[0].trim());
            int to = Integer.parseInt(years[1].trim());

            return (to - from) >= MIN_YEARS;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
