package com.donghun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.donghun.modles.*;
import com.donghun.repository.*;

@RunWith(SpringRunner.class)

public class MemoRepositoryTest {
	
	@Autowired
	MemoRepository repo;
	
	@Test
	public void insert() {
		Memo memo = new Memo();
		memo.setContent("내용");
		memo.setUser("user00");
		repo.save(memo);
	}
	
	@Test
	public void read() {
		repo.findById(1).ifPresent((memo) -> {System.out.println(memo);});
	}
	
	@Test
	public void update() {
		Memo memo = repo.findById(1).get();
		memo.setContent("수정한다..");
		repo.save(memo);	
	}

}
