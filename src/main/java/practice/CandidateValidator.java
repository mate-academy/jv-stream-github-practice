package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= 35
                && candidate.getNationality().matches("Ukrainian")
                && getPeriodsInUkraineSupplier(candidate);
    }

    private boolean getPeriodsInUkraineSupplier(Candidate candidate) {
        String[] array = candidate.getPeriodsInUkr().split("-");
        return (Integer.parseInt(array[1]) - Integer.parseInt(array[0])) > 10;
    }
}
    //write your code here

