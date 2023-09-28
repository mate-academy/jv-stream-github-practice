package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MIN_AGE = 35;
    public static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && Integer.parseInt(period[1]) - Integer.parseInt(period[0]) >= MIN_PERIOD;
    }
}
