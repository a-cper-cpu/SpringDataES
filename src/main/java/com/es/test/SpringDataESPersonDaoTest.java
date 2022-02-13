package com.es.test;

import com.es.DO.Person;
import com.es.dao.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

/**
 * @author a-cper-cpu
 * @date 2022-02-01-16:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESPersonDaoTest {
    @Autowired
    private PersonDao personDao;
    /**
     * 新增
     */
    @Test
    public void save(){
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setAge(21);
        person.setAddress("北京市海淀区");
        personDao.save(person);
    }
    //POSTMAN, GET http://IP地址:9200/contact/_doc/1

    //修改
    @Test
    public void update(){
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setAge(21);
        person.setAddress("北京市朝阳区");
        personDao.save(person);
    }
    //POSTMAN, GET http://IP地址:9200/contact/_doc/1


    //根据 id 查询
    @Test
    public void findById(){
        Person person = personDao.findById(1L).get();
        System.out.println(person);
    }

    @Test
    public void findAll(){
        Iterable<Person> persons = personDao.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    //删除
    @Test
    public void delete(){
        Person person = new Person();
        person.setId(1L);
        personDao.delete(person);
    }
    //POSTMAN, GET http://IP地址:9200/contact/_doc/1

    //批量新增
    @Test
    public void saveAll(){
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(Long.valueOf(i));
            person.setName("["+i+"]张三");
            person.setAge(21+i);
            person.setAddress("北京市海淀区");
            personList.add(person);
        }
        personDao.saveAll(personList);
    }

    //分页查询
    @Test
    public void findByPageable(){
        //设置排序(排序方式，正序还是倒序，排序的 id)
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        int currentPage=0;//当前页，第一页从 0 开始， 1 表示第二页
        int pageSize = 5;//每页显示多少条
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize,sort);
        //分页查询
        Page<Person> personPage = personDao.findAll(pageRequest);
        for (Person person : personPage.getContent()) {
            System.out.println(person);
        }
    }
}
