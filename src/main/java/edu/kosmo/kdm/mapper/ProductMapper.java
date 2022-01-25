package edu.kosmo.kdm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.kdm.vo.CategoryVO;
import edu.kosmo.kdm.vo.MemberVO;
import edu.kosmo.kdm.vo.ProductVO;

@Mapper
public interface ProductMapper {
	
	public ProductVO registerProeuct(String id);	
	
	@Insert("insert into product(id,name, stock, price, category_code) values(#{id},#{name}, #{stock}, #{code)")
	public int insertProduct(ProductVO productVO);

	@Insert("insert into category (code , category_name ) values( #{code}, #{category_name})")
	public void insertCategory(CategoryVO categoryVO);
	
}