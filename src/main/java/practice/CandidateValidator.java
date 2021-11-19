package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && getYearsFromPeriod(candidate.getPeriodsInUkr()) > 10;
    }

    private int getYearsFromPeriod(String period) {
        String[] stringsArray = period.split("-");
        int fromYear = Integer.parseInt(stringsArray[0]);
        int toYear = Integer.parseInt(stringsArray[1]);
        return toYear - fromYear;

    }
    //write your code here
}
