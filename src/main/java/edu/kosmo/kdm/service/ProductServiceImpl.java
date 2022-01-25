package edu.kosmo.kdm.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kosmo.kdm.mapper.BoardMapper;
import edu.kosmo.kdm.mapper.ProductMapper;
import edu.kosmo.kdm.vo.BoardVO;
import edu.kosmo.kdm.vo.ProductVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper productMapper;

	

	@Override
	public void registerProduct(ProductVO productVO) {
		log.info("(service)Product register...");
		
		productMapper.insertProduct(productVO);
	}

	
}