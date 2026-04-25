package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import core.basesyntax.service.RegistrationException;
import core.basesyntax.service.RegistrationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationServiceImplTest {
    private RegistrationServiceImpl service;

    @BeforeEach
    void setUp() {
        Storage.people.clear();
        service = new RegistrationServiceImpl();
    }

    @Test
    void register_validUser_ok() {
        User user = createUser("validUser", "password", 20);

        User result = service.register(user);

        assertEquals(1, Storage.people.size());
        assertEquals(user, result);
        assertEquals(user, Storage.people.get(0));
    }

    @Test
    void register_nullUser_notOk() {
        assertThrows(RegistrationException.class,
                () -> service.register(null));
    }

    @Test
    void register_nullLogin_notOk() {
        User user = createUser(null, "password", 20);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_shortLogin_notOk() {
        User user = createUser("123", "password", 20);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_loginLengthFive_notOk() {
        User user = createUser("12345", "password", 20);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_loginLengthSix_ok() {
        User user = createUser("123456", "password", 20);

        service.register(user);

        assertEquals(1, Storage.people.size());
    }

    @Test
    void register_nullPassword_notOk() {
        User user = createUser("validUser", null, 20);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_emptyPassword_notOk() {
        User user = createUser("validUser", "", 20);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_shortPassword_notOk() {
        User user = createUser("validUser", "123", 20);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_passwordLengthFive_notOk() {
        User user = createUser("validUser", "12345", 20);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_passwordLengthSix_ok() {
        User user = createUser("validUser", "123456", 20);

        service.register(user);

        assertEquals(1, Storage.people.size());
    }

    @Test
    void register_passwordLengthEight_ok() {
        User user = createUser("validUser", "12345678", 20);

        service.register(user);

        assertEquals(1, Storage.people.size());
        assertEquals(user, Storage.people.get(0));
    }

    @Test
    void register_nullAge_notOk() {
        User user = createUser("validUser", "password", null);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_negativeAge_notOk() {
        User user = createUser("validUser", "password", -1);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_ageSeventeen_notOk() {
        User user = createUser("validUser", "password", 17);

        assertThrows(RegistrationException.class,
                () -> service.register(user));
    }

    @Test
    void register_ageEighteen_ok() {
        User user = createUser("validUser", "password", 18);

        service.register(user);

        assertEquals(1, Storage.people.size());
    }

    @Test
    void register_ageNineteen_ok() {
        User user = createUser("validUser", "password", 19);

        service.register(user);

        assertEquals(1, Storage.people.size());
    }

    @Test
    void register_duplicateLogin_notOk() {
        User existingUser = createUser("validUser", "password", 20);
        Storage.people.add(existingUser);

        User newUser = createUser("validUser", "newPassword", 22);

        assertThrows(RegistrationException.class,
                () -> service.register(newUser));
    }

    private User createUser(String login, String password, Integer age) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setAge(age);
        return user;
    }
}
