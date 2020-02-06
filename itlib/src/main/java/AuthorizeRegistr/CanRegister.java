package AuthorizeRegistr;

import models.User;

public interface CanRegister {
    boolean register(User user);
}
