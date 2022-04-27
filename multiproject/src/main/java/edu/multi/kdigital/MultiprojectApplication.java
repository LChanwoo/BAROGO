package edu.multi.kdigital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import edu.multi.kdigital.dao.PaymentMapper;
import hotel.HotelDAO;
import hotel.HotelController;
import upload.UploadController;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackageClasses = HotelController.class)
@ComponentScan(basePackageClasses = UploadController.class)
@MapperScan(basePackageClasses = HotelDAO.class)
@MapperScan(basePackageClasses = PaymentMapper.class)
public class MultiprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultiprojectApplication.class, args);
	}

}
