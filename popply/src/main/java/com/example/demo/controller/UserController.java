package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Users;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService us;
	
	/**
	 * 관리자 ID 등록용 - 페이지에서는 보여지지 않을 영역
	 * @param u: 관리자 계정의 정보를 담은 Users 객체
	 * @return 204: 관리자 등록 성공 / 409: 관리자 ID 중복
	 */
	@PostMapping("/admin")
	public ResponseEntity<Void> enrollTest(@RequestBody Users u) {
		String uid = us.getUserId(u.getUserId());
		
		if(uid != null && !uid.equals("")) {
			us.enrollUserData(u);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	/**
	 * 사용자 ID 중복 체크용 api
	 * @param userId: PathVariable로 받은 사용자 ID
	 * @return true: 등록된 사용자 ID 있음 / false: 등록된 사용자 ID 없음
	 */
	@GetMapping("/check/id/{id}")
	public @ResponseBody boolean getUserId(@PathVariable(name="id") String userId) {
		String uid = us.getUserId(userId);
		return uid != null && !uid.equals("");
	}
	
	/**
	 * 사용자 전화번호 중복 체크용 api
	 * @param phone: PathVariable로 받은 사용자 ID
	 * @return true: 등록된 사용자 ID 있음 / false: 등록된 사용자 ID 없음
	 */
	@GetMapping("/check/phone/{phone}")
	public @ResponseBody boolean getUserPhone(@PathVariable(name="phone") String phone) {
		String p = us.getUserPhone(phone);
		return p != null && !p.equals("");
	}
	
	/**
	 * 사용자 회원가입 시 호출되는 api
	 * @param u: axios로 받은 사용자 계정의 정보를 담은 Users 객체
	 * @return 204: 성공 시 / 500: 서버 에러
	 */
	@PostMapping
	public ResponseEntity<Void> doEnroll(@RequestBody Users u) {
		
		if(us.enrollUserData(u)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	/**
	 * 사용자 로그인 api
	 * @param u: axios로 받은 사용자 계정 정보(userId /userPwd)
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<Users> doLogin(@RequestBody Users u) {
		return ResponseEntity.badRequest().header("msg", "wrong_account").build();
	}
	
}
