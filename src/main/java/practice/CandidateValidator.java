package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_TERM = 10;
    private static final int PERIODS_IN_UKR_TO_INDEX = 1;
    private static final int PERIODS_IN_UKR_FROM_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsLiveInCountry = Integer.parseInt(years[PERIODS_IN_UKR_TO_INDEX])
                - Integer.parseInt(years[PERIODS_IN_UKR_FROM_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsLiveInCountry >= MIN_TERM;
    }
}
