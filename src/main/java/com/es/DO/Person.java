package com.es.DO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * type : 字段数据类型
 * analyzer : 分词器类型
 * index : 是否索引(默认:true)
 * Keyword : 短语,不进行分词
 * @author a-cper-cpu
 * @date 2022-02-01-15:34
 */
@Data
@Document(indexName = "contact", shards = 3, replicas = 1)
public class Person {

    /**
     * 主键 id
     */
    @Id
    public Long id;

    /**
     * 姓名 name
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    public String name;

    /**
     * 年龄 age
     */
    @Field(type = FieldType.Integer)
    public int age;

    /**
     * 地址 address
     */
    @Field(type = FieldType.Keyword, index = false)
    public String address;
}
