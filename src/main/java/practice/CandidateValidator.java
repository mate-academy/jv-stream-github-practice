package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int SUITABLE_AGE = 35;
    public static final int SUITABLE_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian")
            && Integer.parseInt(candidate.getPeriodsInUkr()
                .replaceAll("\\d+-", ""))
            - Integer.parseInt(candidate.getPeriodsInUkr()
                .replaceAll("-\\d+", "")) >= SUITABLE_PERIOD_IN_UKRAINE
            && candidate.getAge() >= SUITABLE_AGE && candidate.isAllowedToVote();
    }
}
