package cn.pluto.medicinal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.pluto.medicinal.dao")
@SpringBootApplication
public class MedicinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicinalApplication.class, args);
	}

}
