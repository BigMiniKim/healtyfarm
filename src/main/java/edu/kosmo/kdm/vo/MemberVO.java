package edu.kosmo.kdm.vo;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberVO {
	
	private String id;
	private String password;
	private int resident_registration_number;
	private String name;
	private String email;
	private int phone_number;
	private String address;
	private int enabled;
	
	private List<AuthVO> authList;
}
