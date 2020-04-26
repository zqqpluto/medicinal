package cn.pluto.medicinal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("cn.pluto.medicinal.dao")
@SpringBootApplication
@EnableTransactionManagement //开启事务回滚
public class MedicinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicinalApplication.class, args);
	}

}
