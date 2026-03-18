package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINAGE = 35;
    private static final int REQUIREDSTAYINUK = 10;
    private static final String REQUIREDNATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {

        String[] periods = candidate.getPeriodsInUkr().split("-");

        if (candidate.getAge() >= MINAGE && candidate.isAllowedToVote() == true
                && candidate.getNationality().equals(REQUIREDNATIONALITY)
                && Integer.parseInt(periods[1]) - Integer.parseInt(periods[0])
                >= REQUIREDSTAYINUK) {
            return true;
        }
        return false;
    }
}

