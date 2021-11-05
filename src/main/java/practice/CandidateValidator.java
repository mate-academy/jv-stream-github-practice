package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int age = 35;
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= age
                && candidate.getNationality() == "Ukrainian"
                && yearsInUkr >= 10;
    }
    //write your code here
}
