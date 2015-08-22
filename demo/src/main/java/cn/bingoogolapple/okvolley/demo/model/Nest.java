package cn.bingoogolapple.okvolley.demo.model;

import java.util.List;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/7/2 12:04
 * 描述:
 */
public class Nest {
    public String property1;
    public int property2;
    public String property3;
    public Child1 child1;
    public List<Child> childs;

    public class Child1 {
        public String attribute1;
        public int attribut2;
        public String attribute3;
    }

    public class Child {
        public String attr1;
        public String attr2;
    }
}
