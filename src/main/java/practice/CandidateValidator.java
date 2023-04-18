package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {
    private Predicate<Candidate> toVote = Candidate::isAllowedToVote;
    private Predicate<Candidate> age = a -> a.getAge() >= 35;
    private Predicate<Candidate> isNationality = c -> c.getNationality().equals("Ukrainian");
    private Predicate<Candidate> period = p -> {
        String[] periodOfYear = p.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodOfYear[1]) - Integer.parseInt(periodOfYear[0]) >= 10;
    };

    public boolean validVote(Candidate candidate) {
        return toVote.test(candidate);
    }

    public boolean validAge(Candidate candidate) {
        return age.test(candidate);
    }

    public boolean validNationality(Candidate candidate) {
        return isNationality.test(candidate);
    }

    public  boolean validPeriod(Candidate candidate) {
        return period.test(candidate);
    }
}
