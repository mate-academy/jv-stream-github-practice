package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getPeriodsInUkr().length() != 9
                || candidate.getPeriodsInUkr().indexOf('-') != 4) {
            throw new NumberFormatException("something wrong with data input");
        }
        String[] periodInUkrArray = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(periodInUkrArray[1])
                - Integer.parseInt(periodInUkrArray[0])) >= 10;
    }
}
