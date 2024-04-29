package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");
		
		int count=sqlSession.insert("user.insert", userVo);
		System.out.println(userVo);
		
		return count;
	}
	
	//수정(회원정보수정)
	public int userUpdate(UserVo userVo) {
		System.out.println("UserDao.userUpdate()");
		
		int count = sqlSession.update("user.update", userVo);
		
		return count;
	}
	
	//no로 한 명 데이터 가져오기(회원정보 수정폼)
	public UserVo userSelectOneByNo(int no) {
		System.out.println("UserDao.userSelectOneByNo()");
		
		UserVo userVo = sqlSession.selectOne("user.selectOneByNo", no);
		return userVo;
	}
	
	//id, pw로 한 명 데이터 가져오기(로그인)
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");
		
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		return authUser;
	}

}