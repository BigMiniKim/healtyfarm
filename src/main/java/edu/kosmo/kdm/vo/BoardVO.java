package edu.kosmo.kdm.vo;

import java.sql.Timestamp;

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
public class BoardVO {
	private int id;    
	private String title; 
	private String content;
	private Timestamp bdate;
	private int hit ;      
	private String member_id;
	private int boardtype_id;
	
 
	
}