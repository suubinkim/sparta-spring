package com.example.home;

import com.example.home.homework.Person;
import com.example.home.homework.PersonRepository;
import com.example.home.homework.PersonRequestDto;
import com.example.home.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class HomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(PersonRepository personrepository, PersonService personService) {
        return (args) -> {
            // 데이터 저장하기
            personrepository.save(new Person("김수빈",25,"천안","무직"));

// 데이터 전부 조회하기
            List<Person> personList = personrepository.findAll();
            for (int i=0; i<personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());
            }

            PersonRequestDto requestDto = new PersonRequestDto("김수빈",25,"서울","개발자");
            personService.update(1L,requestDto);
            personList = personrepository.findAll();
            for(int i=0;i<personList.size();i++){
                Person person = personList.get(i);
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());
            }

        };
    }

}
