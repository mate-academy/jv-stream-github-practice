package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PRESIDENT_MIN_AGE = 35;
    private static final int PRESIDENT_MIN_YEARS_LIVED_IN_UKRAINE = 10;
    private static final int INCLUSIVE_YEAR = 1;
    private static final int START_YEAR_POSITION = 0;
    private static final int END_YEAR_POSITION = 1;
    private static final String PRESIDENT_REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidateDataIsNull(candidate)) {
            return false;
        }
        return candidate.getAge() >= PRESIDENT_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(PRESIDENT_REQUIRED_NATIONALITY)
                && livedInUkraineEnoughTime(candidate.getPeriodsInUkr());
    }

    private boolean candidateDataIsNull(Candidate candidate) {
        return candidate.getNationality() == null
                || candidate.getPeriodsInUkr() == null
                || candidate.getName() == null;
    }

    private boolean livedInUkraineEnoughTime(String period) {
        String[] splitPeriods = period.split("-");
        int yearsLivedInUkraine = Integer.parseInt(splitPeriods[END_YEAR_POSITION])
                - Integer.parseInt(splitPeriods[START_YEAR_POSITION]) + INCLUSIVE_YEAR;
        return yearsLivedInUkraine >= PRESIDENT_MIN_YEARS_LIVED_IN_UKRAINE;
    }
}
