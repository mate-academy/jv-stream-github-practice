package practice;

public class CandidateValidator implements java.util.function.Predicate<model.Candidate> {

    @Override
    public boolean test(model.Candidate candidate) {
        String[] strings = candidate.getPeriodsInUkr().split("-");
        int from = Integer.parseInt(strings[0]);
        int to = Integer.parseInt(strings[1]);
        if ((to - from < 10)) {
            return false;
        }
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        return true;
    }
}
