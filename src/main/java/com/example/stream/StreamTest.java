package com.example.stream;

/**
 * @ClassName StreamTest
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/12/7
 * @Version V1.0
 **/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.*;

/**
 * stream将要处理的元素看作是一个流，在流的过程中，借助stream API对流中的元素进行操作，比如：筛选、排序、聚合等
 * stream可以由数组或者集合创建，操作有两种
 * 1.中间操作，每次返回一个新的流，可以返回多个
 * 2.终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或者值。
 * 特性：
 * 1.stream不存储数据，而是按照特定的规则对数据进行计算，一般会输出结果。
 * 2.stream不会改变数据源，通常情况下会产生一个新的集合和值
 * 3.stream具有延迟执行特性，只有调用终端操作时，中间操作才执行。
 */
public class StreamTest {
    /**
     * 创建流
     */
    public static void testAdd() {
        //通过java.util.Collection.stream() 方法用集合创建流
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        /**
         * 顺序流和并行流的简单区分：stream是顺序流，由主线程按顺序对流进行操作，而parallelSream是并行流，内部以多线程并行的方式
         * 对流进行操作，但前提是流中的数据没有顺序的要求。
         * 如果流中的数据特别大，并行流可以加快处理速度。
         *
         */
        //创建一个顺序流
        Stream<String> stream = list.stream();
        //创建一个并行流
        Stream<String> parallelStream = list.parallelStream();
        //通过parallel()把顺序流转为并行流
        Stream<String> toStream = stream.parallel();


        //使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] array = {1, 3, 4, 2, 5};
        IntStream intStream = Arrays.stream(array);

        //使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> stream1 = Stream.of(1, 3, 2, 1, 13);
        stream1.forEach(out::print);
        out.println();
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream2.forEach(out::print);
        out.println();
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(out::println);
    }

    /**
     * 遍历集合 forEach ,find,match
     */
    public static void find() {
        List<Integer> list = Arrays.asList(5, 6, 7, 1, 14, 12);
        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(out::println);
        //匹配第一个
        Optional<Integer> firstOne = list.stream().filter(x -> x > 6).findFirst();
        out.println(firstOne.get());
        //匹配任意(也适用于并行流)
        Optional<Integer> findAny = list.stream().filter(x -> x > 6).findAny();
        Optional<Integer> findAny1 = list.parallelStream().filter(x -> x > 6).findAny();
        out.println("stream=" + findAny.get() + ",parallelStream=" + findAny1.get());
        //是否存在任意一个包含条件的元素
        boolean testOne = list.stream().anyMatch(x -> x > 6);
        //是否所有都是包含条件的元素
        boolean testAll = list.stream().allMatch(x -> x > 6);
        out.println("anyMatch=" + testOne + ",allMatch=" + testAll);
    }

    /**
     * 筛选，是按照一定的规则校验流中的元素，将符合条件的元素提取到新的流中的操作
     */
    public static void filter() {
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x > 7).forEach(out::println);//8 9

        //筛选出结果之后形成新的collertion
        List<Person> personList = getPerson();
        List<String> nameList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        //List<Person> perList = personList.stream().filter(x -> x.getSalary()>8000).map((Person name) -> new Person()).collect(Collectors.toList());
        out.print("高于8000的员工姓名：" + nameList);
        //System.out.print("高于8000的员工姓名：" + perList.toString());

    }

    /**
     * 测试聚合
     */
    public static void testPolymerization() {
        //获取String集合中最长的元素。
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
       Optional<String> optionalS =  list.stream().max(Comparator.comparing(String::length));
       out.println(optionalS.get());

       //获取Integer集合中的最大值。
        List<Integer> list1 =Arrays.asList(1,4,2,6,7,1,7,5);
        //自然排序
        Optional<Integer>  optionalInteger =  list1.stream().max(Integer::compareTo);
        //自定义排序
        Optional<Integer> optionalInteger1=   list1.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        out.println("自然排序最大值="+optionalInteger.get());
        out.println("自定义排序最大值="+optionalInteger1.get());

        //获取员工工资最高的人
        List<Person> personList = getPerson();
        //若有多个人则返回第一个人
       Optional<Person>  optionalPerson =  personList.stream().max(Comparator.comparingInt(Person::getSalary));
        out.println("员工工资最大值：" + optionalPerson.get().toString());

        //计算Integer集合中大于6的元素的个数。
        List<Integer> list3 = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count =  list3.stream().filter(x->x>6).count();
        out.println("大于6的数量="+count);

    }

    /**
     * 映射：可以将流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap
     * map:接收一个函数作为参数，该函数会被应用到每一个元素上，并将其映射成一个新的元素
     * flatMap:接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接城一个流
     */
    public static void getMap(){
        //转为大写
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strings= Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        //值加3
        List<Integer> list =Arrays.asList(1,2,3,4,5);
        List<Integer> list1 = list.stream().map(x ->x+3).collect(Collectors.toList());
        out.println("每个元素大写：" + strings);
        out.println("每个元素+3：" + list1);

        /**
         * 员工工资加100
         */
        List<Person> personList = getPerson();
        //1不改变原来员工集合的方式
       List<Person> personListNew=  personList.stream().map(person -> {
            Person person1 =new Person(person.getName(),0,0,null,null);
            person1.setSalary(person.getSalary()+1000);
            return person1;
        }).collect(Collectors.toList());
        out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        //改变原来员工集合的方式
        List<Person> personListNew2 =personList.stream().map(person -> {
            person.setSalary(person.getSalary()+1);
            return person;
        }).collect(Collectors.toList());
        out.println("二次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        out.println("二次改动后：" + personListNew2.get(0).getName() + "-->" + personListNew2.get(0).getSalary());

        //将两个字符数组合并成一个新的字符数组。
        List<String> listStr = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listStrNew = (List<String>) listStr.stream().flatMap(s -> {
            String []s2=s.split(",");
            //将每一个元素转为stream
           Stream stream= Arrays.stream(s2);
           return stream;
        }).collect(Collectors.toList());
        out.println("处理前的集合：" + listStr+",原来长度="+listStr.size());
        out.println("处理后的集合：" + listStrNew+",处理后长度="+listStrNew.size());
    }

    /**
     * 归约：也称缩减，是把一个流缩减成一个流，能实现对集合求和、求乘机和求最大值
     */
    public static  void  reduce(){
        //求integer集合的元素之和、乘积和最大值
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        //求和方式
        Optional<Integer>sum1 = list.stream().reduce((x,y)->x+y);
        Optional<Integer>sum2 = list.stream().reduce(Integer::sum);
        Integer sum3 = list.stream().reduce(0,Integer::sum);
        out.println("list求和：1:" + sum1.get() + ",2:" + sum2.get() + ",3:" + sum3);

        //求乘方式
        Optional<Integer>product1 = list.stream().reduce((x,y)->x*y);
        Integer product3 = list.stream().reduce(1,(x,y)->x*y);
        out.println("list求乘：1:" + product1.get()+",2:" + product3);

        // 求最大值方式
       Optional<Integer> max1 = list.stream().reduce((x,y)->x>y?x:y);
       Optional<Integer> max2 = list.stream().reduce(Integer::max);
       Integer max3 = list.stream().reduce(0,Integer::max);
        out.println("list求最大：1:" + max1.get() + ",2:" + max2.get() + ",3:" + max3);


        //求所有员工的工资之和和最高工资
        List<Person> personList = getPerson();
        // 求工资之和方式
        Optional<Integer> sumSalary1 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                Integer::sum);
        out.println("工资之和：" + sumSalary1.get() + "," + sumSalary2 );
        //求最高工资
        Optional<Integer> maxSalary1 = personList.stream().map(Person::getSalary).reduce(Integer::max);
        Integer maxSalary2 = personList.stream().reduce(0,(max,p)->max>p.getSalary()? max :p.getSalary() ,Integer::max);
        out.println("最高工资：" + maxSalary1.get() + "," + maxSalary2);

    }

    /**
     * collert:收集，内容最多，功能最丰富。把流收集起来，最终可以是收集成一个值也可以收集成一个新的集合。
     */
    /**
     * toList、toSet和toMap比较常用，另外还有toCollection、toConcurrentMap等复杂一些的用法。
     */
    public static void collect1(){
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew =list.stream().filter(x -> x % 2 ==0).collect(Collectors.toList());
        Set<Integer> setNew =list.stream().filter(x -> x % 2 ==0).collect(Collectors.toSet());
        out.println("toList:" + listNew);
        out.println("toSet:" + setNew);

        List<Person> personList = getPerson();
        Map<String, Person> collect = personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, p -> p));
        out.println(collect);
    }

    /**
     * Collectors提供了一系列用于数据统计的静态方法：
     * 计数：count
     * 平均值：averagingInt、averagingLong、averagingDouble
     * 最值：maxBy、minBy
     * 求和：summingInt、summingLong、summingDouble
     * 统计以上所有：summarizingInt、summarizingLong、summarizingDouble
     */
    public static void collect2(){
    //统计员工人数、平均工资、工资总额、最高工资
        List<Person> personList = getPerson();
        //求总数
        Long collect = personList.stream().collect(Collectors.counting());
        //求平均gongz
        Double collect1 = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        //求最高工资
       Optional<Integer> t = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compareTo));

        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collects = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        out.println("员工总数：" + collect);
        out.println("员工平均工资：" + collect1);
        out.println("员工工资总和：" + sum);
        out.println("员工工资所有统计：" + collects);
    }

    /**
     * 分组(partitioningBy/groupingBy)
     *
     * 分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
     * 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
     */
    public static void collect3(){
        List<Person> personList = getPerson();
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(p -> p.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> collect2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        out.println("员工按薪资是否大于8000分组情况：" + collect);
        out.println("员工按性别分组情况：" + collect1);
        out.println("员工按性别、地区：" + collect2);
    }

    /**
     * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
     */
    public static void collect4(){
        List<Person> personList = getPerson();
        String names = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        out.println("所有员工的姓名：" + names);

        List<String> list = Arrays.asList("A", "B", "C");
        String collect = list.stream().collect(Collectors.joining("-","[","]"));
        //String collect = list.stream().collect(Collectors.joining("-"));
        out.println("拼接后的字符串：" + collect);

    }

    /**
     * 归约(reducing)：Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持
     */
    public static void collect5(){
        List<Person> personList = getPerson();
      Integer sum =  personList.stream().collect(Collectors.reducing(0,Person::getSalary,(x,y)->x+y-5000));
        out.println("员工扣税薪资总和：" + sum);
        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        out.println("员工薪资总和：" + sum2.get());
    }

    /**
     * sorted，中间操作。有两种排序：
     * sorted()：自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：Comparator排序器自定义排序
     */
    public static void sorted(){
        List<Person> personList = getPerson();
        // 按工资增序排序
        List<Person> collect = personList.stream().sorted(Comparator.comparing(Person::getSalary)).collect(Collectors.toList());
     collect.forEach(person -> {
     System.out.print( "按工资自然排序：" +person.getName());
     });
      System.out.println();
     //按工资倒叙排序
        List<String> sorted1 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        System.out.println("按工资降序排序：" +sorted1);
        // 先按工资再按年龄自然排序（从小到大）
        List<String> sorted2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（从大到小）
        List<String> sorted3 = personList.stream().sorted((p1,p2)->{
            if(p1.getSalary() == p2.getSalary()){
                return p1.getAge()-p2.getAge();
            }else{
                return p1.getSalary()-p2.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println("先按工资再按年龄自然排序：" + sorted2);
        System.out.println("先按工资再按年龄自定义降序排序：" + sorted3);
    }

    /**
     * 流也可以进行合并、去重、限制、跳过等操作。
     */
    public static void combination(){
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> distinct = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());

        List<String> list1=Arrays.asList("aaa","vvv","cccc");
        List<String> list2=Arrays.asList("aaa","bbb","ddd");
        List<String> distinct1 = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());
        System.out.println("流合并去重：" + distinct);
        System.out.println("流合并去重：" + distinct1);

        // limit：限制从流中获得前n个数据
        List<Integer> limit = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> skip = Stream.iterate(1, x -> x + 2).skip(5).limit(2).collect(Collectors.toList());

        System.out.println("limit：" + limit);
        System.out.println("skip：" + skip);

    }
    /**
     * 获取persion基础值
      * @return
     */
    public static List<Person> getPerson(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        return personList;
    }
    public static void main(String[] args) {
        // testAdd();
        //find();
       // filter();
      //  testPolymerization();
       // getMap();
       // reduce();
        //collect1();
       // collect2();
       // collect3();
      //  collect4();
      //  collect5();
        //sorted();
        combination();
    }
}
