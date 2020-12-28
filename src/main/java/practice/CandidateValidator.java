package practice;

import model.Candidate;

import java.util.function.Predicate;

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

    private boolean checkPeriod(String period){
        if (period == null || period.length() != 9
                    || period.replaceAll("[0-9]", "").length() != 1) {
                return false;
            }
            int start = Integer.parseInt(period.substring(0, 4));
            int over = Integer.parseInt(period.substring(5));
            return over - start >= YEARS_IN_COUNTRY;
        }
}
