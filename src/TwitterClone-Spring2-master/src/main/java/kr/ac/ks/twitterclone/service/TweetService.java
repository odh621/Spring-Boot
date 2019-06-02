package kr.ac.ks.twitterclone.service;

import kr.ac.ks.twitterclone.model.Tweet;
import kr.ac.ks.twitterclone.model.User;
import kr.ac.ks.twitterclone.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    public List<Tweet> findAllDesc() {
        List<Tweet> res = tweetRepository.findAllByOrderByPostTimeDesc();
        if (res == null) {
            res = new ArrayList<>();
        }
        return res;
    }

    public List<Tweet> getTimeLineforLoginUser(User loginuser) {
        List<User> following = loginuser.getFollowing();
        following.add(loginuser);
        List<String> ids = following.stream().map(User::getUserId).collect(Collectors.toList());
        return tweetRepository.findTop100ByTweetUser_UserIdInOrderByPostTimeDesc(ids);
    }

    public Tweet save(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public void delete(Integer id) {
        tweetRepository.deleteById(id);
    }

    public Tweet find(Integer id) {
        return tweetRepository.findById(id).get();
    }
}
