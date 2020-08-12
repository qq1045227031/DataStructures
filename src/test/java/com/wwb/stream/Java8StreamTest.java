package com.wwb.stream;

import org.junit.Test;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamTest {
    @Test
    public void sy(){
        //substring 不会修改原字符串
        String x = "nihaoa";
        System.out.println(x.substring(1,2));
        System.out.println(x);
    }
    @Test
    public void filter(){
        List<String> strings = Arrays.asList("abc","","bc","efd","ancd","","jkl");
        //并行Stream流
//        strings.parallelStream();
        //串行stream流  strings.stream();
        //filter 过滤集合中不符合条件项
        List<String> filter = strings.stream().filter(str-> str.contains("f")).collect(Collectors.toList());
        System.out.println(filter);
    }
    @Test
    public void distinct(){
        List<String> strings = Arrays.asList("abc","abc","bc","efd","ancd","","jkl");
        List<String> distinct = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);
        List<User> users = new ArrayList<>();
        User user1 = new User(1,"z");
        User user2 = new User(1,"z");
        System.out.println(user1.equals(user2));

        users.add(user1);
        users.add(user2);
        users.add(new User(2,"s"));
        //distinct 比较的是对象的地址，地址一样才去重
        List<User> distinctUser = users.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctUser);
    }
    @Test
    public void limit(){
        List<String> strings = Arrays.asList("abc","abc","bc","efd","ancd","","jkl");
        //limit输出前面的n个元素
        List<String> limited= strings.stream().limit(2).collect(Collectors.toList());
        System.out.println(limited);
    }
    @Test
    public void skip(){
        List<String> strings = Arrays.asList("abc","abc","bc","efd","ancd","","jkl");
        //skip删除前面的n个元素
        List<String> skip= strings.stream().skip(2).collect(Collectors.toList());
        System.out.println(skip);
    }

    /**
     * map处理
     */
    @Test
    public void map(){
        List<String> strings = Arrays.asList("abc","abc","bc","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
        List<String> mapped = strings.stream().map(str->str.concat("_nihao")).collect(Collectors.toList());
        System.out.println(mapped);
        //加前缀
        List<String> mapped2 = strings.stream().map(str->"qianzui"+str).collect(Collectors.toList());
        System.out.println(mapped2);
    }
    /**
     * sorted
     */
    @Test
    public void sorted(){
        //sort排序，字母默认a b c排序，数字从小到大 空会排在最前
        List<String> strings = Arrays.asList("abc","abc","bc","efd","ancd","","jkl");
        //排序
        List<String> mapped = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(mapped);
        List<String> string1 = Arrays.asList("123","1","323","24","123","","22");
        List<String> mapped1 = string1.stream().sorted().collect(Collectors.toList());
        System.out.println(mapped1);
        //中文排序要借助pom中的包
        // <groupId>org.apache.commons</groupId>
        //            <artifactId>commons-collections4</artifactId>
        List<String> strings2 = Arrays.asList("张三","李四","王五","张五","李三","","王二");
        List<String> mapped2 = strings2.stream().sorted(Collator.getInstance(Locale.CHINA)).collect(Collectors.toList());
        System.out.println(mapped2);
        //Collections.reverseOrder()  反转
        List<String> string3 = Arrays.asList("张三","李四","王五","张五","李三","","王二");
        List<String> mapped3 = string3.stream().sorted(Collections.reverseOrder(Collator.getInstance(Locale.CHINA))).collect(Collectors.toList());
        System.out.println(mapped3);
    }
    /**
     * anyMatch判断是否有一个符合条件,有一个满足返回ture
     */
    @Test
    public void anyMatch(){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
        boolean bc = strings.stream().anyMatch(str->str.contains("bc"));
        System.out.println(bc);
        //加前缀
    }
    /**
     * allMatch判断全部符合条件，全部符合返回ture，任意一个不满足返回false
     */
    @Test
    public void allMatch(){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
        boolean bc = strings.stream().allMatch(str->str.length()>2);
        System.out.println(bc);
        //加前缀
    }
    /**
     * noneMatch和allMatch相反，判断全部不符合条件，全部不符合返回ture，任意一个满足返回false
     */
    @Test
    public void noneMatch(){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
        boolean bc = strings.stream().noneMatch(str->str.length()>5);
        System.out.println(bc);
        //count 统计总数
        long i = strings.stream().count();
        System.out.println(i);
        //加前缀
    }
    /**
     * findAny 返回任意一个元素????
     */
    @Test
    public void findAny(){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
        Optional<String> any = strings.parallelStream().findAny();
        System.out.println(any);
        //加前缀
    }
    /**
     * findFirst 返回第一个元素????
     */
    @Test
    public void findFirst(){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
        Optional<String> first = strings.stream().findFirst();
        System.out.println(first);
        //加前缀
    }

    /**
     * forEach 循环
     */
    @Test
    public void forEach(){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
//        strings.stream().forEach(s->System.out.println(s));
        strings.stream().forEach(System.out::println);
        //加前缀
    }
    /**
     * collect 循环
     */
    @Test
    public void collect (){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //collector 转换为list
        List<String> list = strings.stream().collect(Collectors.toList());
        //转换为set  去重
        Set<String> set  = strings.stream().collect(Collectors.toSet());
        Map<String,String> map = strings.stream().
                collect(Collectors.toMap(v->v,v->v,(oldValue,newValue)->newValue));
        System.out.println(map);
    }
    /**
     * reduce功能描述：将流元素结合起来得到一个好结果
     */
    @Test
    public void reduce(){
        List<String> strings = Arrays.asList("abc","abc","bcd","efd","ancd","","jkl");
        //concat拼接    注意contain包含要用在filter中
//        strings.stream().forEach(s->System.out.println(s));
        Optional<String> reduce = strings.stream().reduce((acc,item)->{return (acc+item);});
        if (reduce.isPresent()){
            System.out.println(reduce.get());
        }
        //还可以进行操作  比如这里去掉a
        Optional<String> reduce2 = strings.stream().reduce((acc,item)->{return (acc+item).replace("a","");});
        if (reduce2.isPresent()){
            System.out.println(reduce2.get());
        }
        //
        String reduce3 = strings.stream().reduce("aaa",(acc,item)->{return (acc+item).replace("a","");});
    }
}
