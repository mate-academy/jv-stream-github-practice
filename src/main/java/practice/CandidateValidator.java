package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKR = 10;
    private static final int MINIMAL_AGE = 35;
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MINIMAL_AGE
                && CORRECT_NATIONALITY.equalsIgnoreCase(candidate.getNationality())
                && candidate.isAllowedToVote()
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SEPARATOR);

        try {
            return Integer.parseInt(dates[END_INDEX])
                    - Integer.parseInt(dates[BEGIN_INDEX]) >= PERIOD_IN_UKR;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
