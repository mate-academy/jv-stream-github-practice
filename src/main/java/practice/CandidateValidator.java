package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_OF_RESIDENCE_UKRAINE = 10;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && liveInUkraineForYears(candidate) >= MIN_PERIOD_OF_RESIDENCE_UKRAINE;
    }

    private int liveInUkraineForYears(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split("-");
        int yearFrom = Integer.parseInt(years[0]);
        int yearTo = Integer.parseInt(years[1]);
        return yearTo - yearFrom;
    }
}
