package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN = "Ukrainian";
    public static final String REGEX_PERIODS = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(REGEX_PERIODS);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals(UKRAINIAN)
                && Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]) >= 10;
    }
}
