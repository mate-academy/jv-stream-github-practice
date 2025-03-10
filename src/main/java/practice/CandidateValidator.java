package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_RESIDENCE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getUkrainianResidence(candidate.getPeriodsInUkr()) >= MIN_RESIDENCE;
    }

    private int getUkrainianResidence(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
