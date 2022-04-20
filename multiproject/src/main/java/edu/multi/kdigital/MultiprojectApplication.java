package edu.multi.kdigital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import hotel.HotelDAO;
import hotel.hotelController;
import upload.UploadController;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackageClasses = mainController.class)
@ComponentScan(basePackageClasses = hotelController.class)
@ComponentScan(basePackageClasses = UploadController.class)
@MapperScan(basePackageClasses = HotelDAO.class)
public class MultiprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultiprojectApplication.class, args);
	}

}
