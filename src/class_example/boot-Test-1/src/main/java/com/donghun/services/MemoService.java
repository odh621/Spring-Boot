package com.donghun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donghun.modles.Memo;
import com.donghun.repository.MemoRepository;

@Service
public class MemoService {
	
	@Autowired
	MemoRepository repo;
	
	public Memo save() { // create
		Memo memo = new Memo();
		memo.setContent("내용..");
		memo.setUser("사용자..00");
		Memo save = repo.save(memo);
		
		return save;
	}
	
	public List<Memo> list()  { // read
		List<Memo> memo = repo.findAll();
		return memo;
	}
	
	
	public Memo patch(Integer bno) {
		Memo memo = repo.getOne(bno);
		if(null == memo )
			return null;
		memo.setContent("새로운 내용");
		Memo patch = repo.save(memo);
		return patch;
	}
	
	
	public List<Memo> getFindContent(String content) {
		return repo.findByContent(content);
	}
	
	public List<Memo> getFindUserContaining(String user) {
		return repo.findByUserContaining(user);
	}

}
