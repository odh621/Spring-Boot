package kr.ac.ks.twitterclone.repository;

import kr.ac.ks.twitterclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
}
