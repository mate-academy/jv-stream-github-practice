package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    public static final int MIN_ELIGIBLE_AGE = 35;
    public static final int MIN_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && candidate.getAge() >= MIN_ELIGIBLE_AGE
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                    - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                    >= MIN_PERIOD_IN_COUNTRY;
    }
}
