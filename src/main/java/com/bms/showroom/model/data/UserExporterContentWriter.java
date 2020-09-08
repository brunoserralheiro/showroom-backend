package com.bms.showroom.model.data;

import java.io.Writer;
import java.util.List;
import org.jooq.lambda.Unchecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bms.showroom.model.entity.User;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserExporterContentWriter {
	@Autowired
	public UserRepository userRepository;


//	Stream<User> s = users.stream();


	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@SneakyThrows
	public void writeContent(Writer writer) {
		List<User> users =userRepository.findAll();
		if(!users.isEmpty()) {
			for(User u : users)
			{
				System.out.println("**************"+u.get_id()+"**************");
			}
		}else {
			System.out.println("**************"+"Sifu!");
			throw new RuntimeException("No one found");
		}
		try {
			writer.write("ID;Roles \n");
			
			
			users.stream().map(o -> o.get_id() + ";" + o.getRoles().get(0))
					.forEach(Unchecked.consumer(writer::write));
		} catch (RuntimeException e) {
			log.warn("***************Panic!", e);
			
		}
	}
}
