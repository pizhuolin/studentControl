package com.studentctrl.auth;

import org.junit.After;
import org.junit.Before;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Test implements ClassSuper {
    private Student student;
    private static int number = 0;

    public Test(Student student) {
        super();
        this.student = student;
    }

    @Override
    public void getStudent() {
        this.student.getStudent();
    }

    @Override
    public void getName() {
        System.out.println("拿到了学生的名字");
    }

    @org.junit.Test
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, InterruptedException {
//       Student student = new Student();
//        Test test = new Test(student);
//        test.getStudent();
//        before();
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(5);
//        list.add(3);
//        list.add(7);
//        list.add(8);
//        list.add(2);
//        System.out.println(Arrays.toString(list.toArray()));
//        Collections.sort(list);
//        list.set(1, 9);
//        Collections.sort(list);
//        System.out.println(Arrays.toString(list.toArray()));
//        SortedList<Integer> sortedList = new SortedList<>();
//        sortedList.add(1);
//        sortedList.add(3);
//        sortedList.add(7);
//        sortedList.add(4);
//        sortedList.add(null);
//        sortedList.Add(6);
//        System.out.println(sortedList.size());
//        after();

//        char[] test = {63, 32, 82};
//        System.out.println(new String(test));
//        System.out.println(asciiToString("82"));
//        Map map = new HashMap();
//        map.put("test", 3);
//        map.put("test", 2);
//        map.put("2", "4");
//        System.out.println(map.put(2, 4));
//        List<Integer> list1 = new ArrayList();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(9);
//        list1.add(4);
//        list1.sort((a, b) -> a - b);
//        System.out.println(Arrays.toString(list1.toArray()));
//        Class classs = Class.forName("com.studentctrl.auth.entity.User");
//        Method m = classs.getMethod("getUserid");
//        Field f = classs.getDeclaredField("userid");
//        Object test = classs.newInstance();
//        f.setAccessible(true);
//        f.set(test, "test1");
//        m.setAccessible(true);
//        m.invoke("test");
//        System.out.println(m.invoke(test));
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        List<Integer> list2 = list1;
//        list2.sort((a, b) -> b - a);
//        System.out.println(Arrays.toString(list1.toArray()));
//        System.out.println(Arrays.toString(list2.toArray()));

        Thread a = new Thread() {
            public void run() {
                while (number < 20 && !isInterrupted()) {
                    number++;
                    System.out.println("a打印了" + number);
                }
            }
        };

        Thread b = new Thread() {
            public void run() {
                while (number < 20) {
                    number++;
                    System.out.println("b打印了" + number);
                }
            }
        };

        a.start();
        a.interrupt();
        a.join();
        b.start();
    }

    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    public static long concurrentTime1, concurrentTime2, concurrentMemory1, concurrentMemory2;

    @Before
    public static void before() {
        //得到程序开始时的系统时间（纳秒级，最终转化毫秒，保留小数点后两位）
        concurrentTime1 = System.nanoTime();
        //得到虚拟机运行、程序开始执行时jvm所占用的内存。
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory1 = runtime.totalMemory() - runtime.freeMemory();
    }

    @After
    public static void after() {
        //得到程序执行完毕时的系统时间（毫秒级）
        concurrentTime2 = System.nanoTime();
        //得到虚拟机运行、所要测试的执行代码执行完毕时jvm所占用的内存（byte）。
        Runtime runtime = Runtime.getRuntime();
        concurrentMemory2 = runtime.totalMemory() - runtime.freeMemory();

        //计算start和end之间的代码执行期间所耗时间(ms)与内存(M)。
        // 1毫秒(ms) = 1000微秒(us) = 1000 000纳秒(ns)
        // 1M = 1*2^20 byte = 1024 * 1024 byte;
        String time = String.valueOf((double) (concurrentTime2 - concurrentTime1) / 1000000);
        String memory = String.valueOf((double) (concurrentMemory2 - concurrentMemory1) / 1024 / 1024);
        System.out.println("---------------您的代码执行时间为：" + time.substring(0, time.equals("0.0") ? 1 : (time.indexOf(".") + 3)) + " ms, 消耗内存：" + memory.substring(0, memory.equals("0.0") ? 1 : (memory.indexOf(".") + 3)) + " M + !---------------");
    }
}

