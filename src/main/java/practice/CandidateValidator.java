package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null && candidate.getAge() >= MIN_AGE
                && NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote() && checkPeriod(candidate.getPeriodsInUkr());
    }

    public boolean checkPeriod(String period) {
        if (period == null) {
            return false;
        }
        String[] data = period.split("-");
        return Math.abs(Integer.parseInt(data[0]) - Integer.parseInt(data[1])) >= YEARS_IN_COUNTRY;
    }
}
