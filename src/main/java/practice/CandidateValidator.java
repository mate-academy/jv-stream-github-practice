package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String nationality = "Ukrainian";
    private static final int partOne = 0;
    private static final int partTwo = 1;
    private static final int toAge = 35;
    private static final int durationInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split("-");
        int inted = Integer.parseInt(splitted[partTwo]) - Integer.parseInt(splitted[partOne]);
        if (candidate.isAllowedToVote() && candidate.getAge() >= toAge
                && candidate.getNationality().equals(nationality)
                && inted >= durationInUkr) {
            return true;
        }
        return false;
    }
}
