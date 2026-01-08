package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE = 35;
    private static final String SPLITTER = "-";
    private static final int MIN_IN_UKR = 10;

    private static boolean isAllowedToVote(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(SPLITTER);
        int totalInUkr = Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]);

        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE
                && NATIONALITY.equals(candidate.getNationality())
                && totalInUkr >= MIN_IN_UKR;
    }

    @Override
    public boolean test(Candidate o) {
        return isAllowedToVote(o);
    }
}
