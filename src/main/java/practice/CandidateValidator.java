package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_LIVE = 10;
    private static final String NEEDED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && yearLiveInCountry(candidate.getPeriodsInUkr()) >= MIN_YEARS_LIVE;
    }

    private int yearLiveInCountry(String periodsInCountry) {
        String[] years = periodsInCountry.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }

}
