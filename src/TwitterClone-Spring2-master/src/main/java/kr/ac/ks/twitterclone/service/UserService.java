package kr.ac.ks.twitterclone.service;

import kr.ac.ks.twitterclone.controller.TwitterCloneController;
import kr.ac.ks.twitterclone.model.User;
import kr.ac.ks.twitterclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) throws UserIdAlreadyExistsException {
        Optional<User> tmp = userRepository.findById(user.getUserId());
        if (tmp.isPresent())
            throw new UserIdAlreadyExistsException(user.getUserId() + " is already exists.");
        return userRepository.save(user);
    }

    public User update(User user) {
        if (!userRepository.existsById(user.getUserId()))
            throw new UserIdNotFoundException(user.getUserId() + "is not found.");

        userRepository.save(user);
        return user;
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public User find(String id) {
        return userRepository.findById(id).get();
    }

    public List<User> getUnFollowing10Users(User loginUser, TwitterCloneController twitterCloneController) {
        TwitterCloneController.log.info("loginuser is: " + loginUser.toString());

        List<User> alluser = findAll();
        List<User> following = loginUser.getFollowing();
        List<User> unFollowing10Users = alluser.stream()
                .limit(10)
                .filter(u -> !(following.contains(u) || u.equals(loginUser)))
                .collect(Collectors.toList());
        return unFollowing10Users;
    }

}
