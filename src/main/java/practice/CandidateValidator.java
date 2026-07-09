package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private int getNumberByParsedYearsDates(Candidate candidate) {
        String[] array = candidate.getPeriodsInUkr().split("-");
        int num = Integer.parseInt(array[1]) - Integer.parseInt(array[0]);
        return num;
    }

    @Override
    public boolean test(Candidate candidates) {
        return candidates.getAge() >= 35
                && candidates.isAllowedToVote() == true
                && candidates.getNationality().equals("Ukrainian")
                && getNumberByParsedYearsDates(candidates) >= 10;
    }

}
