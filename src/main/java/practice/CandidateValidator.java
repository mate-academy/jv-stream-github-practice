package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int FIRST_YEAR_POSITION = 0;
    private static final int LAST_YEAR_POSITION = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), NATIONALITY)
                && checkPeriodsInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private int checkPeriodsInUkr(String periodInUkr) {
        String[] yearsInString = periodInUkr.split(SPLITTER);
        int[] years = new int[] {Integer.parseInt(yearsInString[FIRST_YEAR_POSITION]),
        Integer.parseInt(yearsInString[LAST_YEAR_POSITION])};
        return years[LAST_YEAR_POSITION] - years[FIRST_YEAR_POSITION];
    }
}
