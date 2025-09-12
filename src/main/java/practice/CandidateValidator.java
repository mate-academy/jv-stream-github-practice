package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKR = 10;
    private static final String PERIOD_SEPARATOR = ",";
    private static final String YEAR_SEPARATOR = "-";
    private static final int END_INDEX = 1;
    private static final int BEGIN_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_THRESHOLD
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        int sumOfYears = 0;
        String[] dates = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        for (String data : dates) {
            String[] years = data.split(YEAR_SEPARATOR);
            sumOfYears += Integer.parseInt(years[END_INDEX]) - Integer.parseInt(years[BEGIN_INDEX]);
        }
        return sumOfYears >= PERIOD_IN_UKR;
    }

}
