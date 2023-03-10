package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String DElIMiTER = "-";
    private static final String DESIRED_NATIONALITY = "Ukrainian";
    private static final int YEAR_INDEX_FROM = 0;
    private static final int YEAR_INDEX_TO = 1;
    private static final int MIN_STAYING_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(DElIMiTER);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(DESIRED_NATIONALITY)
                && Integer.parseInt(periods[YEAR_INDEX_TO])
                - Integer.parseInt(periods[YEAR_INDEX_FROM]) >= MIN_STAYING_YEARS;
    }
}
