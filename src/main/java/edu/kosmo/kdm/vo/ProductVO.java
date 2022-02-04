package edu.kosmo.kdm.vo;



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
public class ProductVO {
	private int id;
	private String name;
	private int stock;
	private int price;
	private String detail;
	private String category_code;
	
	



}
