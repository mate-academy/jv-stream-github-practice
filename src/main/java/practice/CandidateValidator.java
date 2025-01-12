package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] split1 = candidate.getPeriodsInUkr().split("-");
        int period = Math.abs(Integer.parseInt(split1[0]) - Integer.parseInt(split1[1]));
        if (candidate.isAllowedToVote() && candidate.getAge() > 35
                && candidate.getNationality().equals("Ukrainian")
                && period > 10) {
            return true;
        }
        return false;
    }
    //write your code here

}
