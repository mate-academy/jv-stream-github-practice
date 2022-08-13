package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVE_IN_UKRAINE_YEARS = 10;
    private static final int START_INDEX = 0;
    private static final int STOP_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int liveInUkraineYears = Integer.parseInt(years[STOP_INDEX])
                - Integer.parseInt(years[START_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && liveInUkraineYears >= MIN_LIVE_IN_UKRAINE_YEARS
                && candidate.isAllowedToVote();
    }
}
