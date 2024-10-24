package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] arr = candidate.getPeriodsInUkr().split("-");
        if (arr.length == 1) {
            throw new RuntimeException("The format of period living in Ukraine is invalid"
                    + "expected startYear-endYear, but you provide only one year");
        }
        if (arr.length == 0) {
            throw new RuntimeException("The format of period living in Ukraine is invalid"
                    + "expected startYear-endYear, but you provide empty string");
        }
        int periodOfLivingInCountry = Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]);
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodOfLivingInCountry >= 10) {
            return true;
        }
        return false;
    }
}
