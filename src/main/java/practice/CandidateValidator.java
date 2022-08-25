package practice;

import java.util.Comparator;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] yearLiveInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodsInUkr = Integer.parseInt(yearLiveInUkraine[1])
                - Integer.parseInt(yearLiveInUkraine[0]);
        if (candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && periodsInUkr > 10) {
            return true;
        } else {
            return false;
        }
    }

    static class CandidateComparator implements Comparator<Candidate> {
        @Override
        public int compare(Candidate candidate1, Candidate candidate2) {
            return candidate1.getName().toUpperCase().compareTo(candidate2.getName().toUpperCase());
        }
    }
}
