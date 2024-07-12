package com.mab.test06;

import java.util.ArrayList;
import java.util.Scanner;  // 导包，类似于py

/*
【java实战项目--书城--集合版】项目功能：
1、展示书籍
2、上新书籍
3、下架书籍
4、退出应用
        ----原作者：马士兵教育
书籍编号            书籍名称            书籍作者
01                自动控制原理           章云        ---> 封装成一个类，类似于结构体，这些书的信息是类的属性
……
 */
public class Test {
    public static void main(String[] args) {
        //创建一个集合，类似于列表
        ArrayList list = new ArrayList();
        while (true){
            //打印菜单
            System.out.println("欢迎来到我的project");
            System.out.println("1、展示书籍");
            System.out.println("2、上新书籍");
            System.out.println("3、下架书籍");
            System.out.println("4、退出应用");
            //借助scanner类:
            Scanner sc = new Scanner(System.in);  // 输入类scanner
            //利用键盘录入序号
            System.out.println("请录入您想要执行的功能的序号：");
            int choice = sc.nextInt();  //输入后点击回车结束录入

            if(choice == 1){
                System.out.println("1、展示书籍");
                // System.out.println(list);  // 但是其实这里显示的效果并不好，所以换一种方式
                for (int i = 0; i < list.size(); i++){
                    Book b = (Book) (list.get(i));  // 这里使用了强制类型转换，转换的方法子和C语言是类似的
                    System.out.println(b.getbNo() + "---" + b.getbName() + "---" + b.getbAuthour());
                }
            }
            if(choice == 2){
                System.out.println("2、上新书籍");
                //从键盘录入信息
                System.out.println("请录入书籍编号：");
                int bNo = sc.nextInt();
                System.out.println("请录入书籍名称：");
                String bName = sc.next();
                System.out.println("请录入作者名称：");
                String bAuthor = sc.next();
                // 每上新一本书，就要创建一本书籍的对象
                Book b = new Book();
                b.setbNo(bNo);
                b.setbName(bName);
                b.setbAuthour(bAuthor);

                // 将书籍加入列表
                list.add(b);
            }
            if(choice == 3){
                System.out.println("3、下架书籍");
                // 以编号为标准：
                System.out.println("请录入你要下架的书籍的编号：");
                int delNo = sc.nextInt();
                //下架编号对应的书籍：
                for (int i = 0; i < list.size(); i++){
                    Book b = (Book) (list.get(i));
                    if (b.getbNo()==delNo){
                        list.remove(b);
                        System.out.println("书籍下架成功");
                        break; // 下架成功就没必要继续遍历了。
                    }
                }
            }
            if(choice == 4){
                System.out.println("期待您的再次光临！！！");
                break;  // 与其他编程语言的用法相同
            }
        }
    }
}
