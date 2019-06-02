package kr.ac.ks.twitterclone.repository;

import kr.ac.ks.twitterclone.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Integer>{
    List<Tweet> findAllByOrderByPostTimeDesc();
    List<Tweet> findTop100ByTweetUser_UserIdInOrderByPostTimeDesc(List<String> tweetUserId);
}
