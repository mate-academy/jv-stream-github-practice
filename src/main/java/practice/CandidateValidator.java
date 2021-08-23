package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int ageLimit = 35;
    private final String nationality = "Ukrainian";
    private final int livingInUkraineLimit = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ageLimit
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                >= livingInUkraineLimit);
    }
}
