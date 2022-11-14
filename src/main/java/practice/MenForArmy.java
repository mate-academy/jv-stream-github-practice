package practice;

import model.Person;

class MenForArmy {
    public boolean check(Person person, int fromAge, int toAge) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }
}
