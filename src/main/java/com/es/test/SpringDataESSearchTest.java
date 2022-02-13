package com.es.test;

import com.es.DO.Person;
import com.es.dao.PersonDao;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author a-cper-cpu
 * @date 2022-02-01-17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESSearchTest {

    @Autowired
    private PersonDao personDao;
    /**
     * term 查询
     * search(termQueryBuilder) 调用搜索方法，参数查询构建器对象
     */
    @Test
    public void termQuery(){
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "[8]张三");
        Iterable<Person> persons = personDao.search(termQueryBuilder);
        for (Person person : persons) {
            System.out.println(person);
        }
    }
    /**
     * term 查询加分页
     */
    @Test
    public void termQueryByPage(){
        int currentPage= 0 ;
        int pageSize = 5;
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "[8]张三");
        Iterable<Person> persons =
                personDao.search(termQueryBuilder,pageRequest);
        for (Person person : persons) {
            System.out.println(person);
        }
    }

}
