package nl.wiggertloonstra.bible.service;

import nl.wiggertloonstra.bible.hibernate.UserRepository;
import nl.wiggertloonstra.bible.hibernate.domain.UserDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDo getUserWithId(int userId) {
        return userRepository.getUserWithId(userId);
    }
    
    @Override
    public UserDo userExistingOrNewWithEmail(String email) {
        UserDo user = userRepository.getUserWithEmail(email);
        if (user != null) {
            return user;
        } else {
            UserDo newUser = new UserDo();
            newUser.setEmail(email);
            String name = getNameFrom(email);
            newUser.setUsername(name);
            return userRepository.store(newUser);
        }
    }

    private String getNameFrom(String email) {
        String[] tokens = email.split("@");
        if (tokens.length > 1) {
            return tokens[0];
        } else {
            return "geen naam opgegeven";
        }
    }

}
