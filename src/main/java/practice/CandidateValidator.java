package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIODS = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr()) >= MIN_PERIODS;
    }

    public int hasLivedInUkraineFor10Years(String periodsInUkr) {
        String[] newPeriods = periodsInUkr.split("-");
        int startYear = Integer.parseInt(newPeriods[START_YEAR].trim());
        int endYear = Integer.parseInt(newPeriods[END_YEAR].trim());
        return endYear - startYear;
    }
}
