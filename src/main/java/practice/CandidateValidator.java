package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int MIN_YEARS = 10;
    private static int MIN_AGE = 35;
    private static String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote()
                && calculateInterval(candidate.getPeriodsInUkr()) >= MIN_YEARS);
    }

    private static int calculateInterval(String period) {
        String[] periodInUkr = period.split("-");
        return Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]);

    }

}
