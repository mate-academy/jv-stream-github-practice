package practice;

import model.Candidate;
import java.time.LocalDate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public  boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= 35
                && Integer.parseInt(candidate.getPeriodsInUkr().substring(candidate.getPeriodsInUkr().indexOf("-") + 1))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0,candidate.getPeriodsInUkr().indexOf("-")))
                >= 10;
                        //equals(LocalDate.now().getYear() - 10 >=  + LocalDate.now().getYear());
    }
    //write your code here
}
