package PollPoint.controllers;

import PollPoint.data.UserRepository;
import PollPoint.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "userSession";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null){
            return null;
        }

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            return null;
        }

        return user.get();
    }

    public static void setUserInSession(HttpSession session, User user){
        session.setAttribute(userSessionKey, user.getId());
    }
}

