package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int ageFrom = 35;
    private static final String nationality = "Ukrainian";
    private static final String charForSplit = "-";
    private static final int periodInUkraine = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= ageFrom) {
            if (candidate.isAllowedToVote()) {
                if (candidate.getNationality().equals(nationality)) {
                    String[] splitedPeriod = candidate.getPeriodsInUkr().split(charForSplit);
                    int period = Integer.parseInt(splitedPeriod[1])
                            - Integer.parseInt(splitedPeriod[0]);
                    return period >= periodInUkraine;
                }
            }
        }
        return false;
    }
}
