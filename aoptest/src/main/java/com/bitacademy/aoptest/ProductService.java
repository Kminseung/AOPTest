package com.bitacademy.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVo findProduct(String keyword) {
		System.out.println("finding [" + keyword + "]");
		
		try {
			Thread.sleep(1000);		// 1초 대기
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return new ProductVo(keyword);
	}
}
