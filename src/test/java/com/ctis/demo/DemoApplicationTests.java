package com.ctis.demo;

import com.ctis.demo.mapper.CarInfoMapper;
import com.ctis.demo.pojo.CarInfo;
import com.ctis.demo.utils.MybatisUtils;
import com.ctis.demo.utils.TreeNode;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws IOException {
        String accout = "sixu";
        String password = "123456";
        System.out.println(DigestUtils.md5DigestAsHex((accout+password).getBytes()));
//
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }

    @Test
    void testTree() {
//        TreeNode t0 = new TreeNode("0", "t0");
//        TreeNode t1 = new TreeNode("1", "t1");
//        TreeNode t2 = new TreeNode("2", "t2");
//        TreeNode t3 = new TreeNode("3", "t3");
//        TreeNode t4 = new TreeNode("10", "t4");
//        TreeNode t5 = new TreeNode("5", "t5");

//        t0.addTreeNode(t1);
//        t0.addTreeNode(t2);
//        t1.addTreeNode(t3);
//        t2.addTreeNode(t4);
//        t2.addTreeNode(t5);
//        System.out.println(t0.getTreeNodeByID(t0, "0"));
    }

    @Test
    void test02() {
//        TreeNode treeNode = new TreeNode("1", "0");
//        System.out.println(treeNode.getFatherID());
//        HashMap<String, String> origin = new HashMap<>();
//        origin.put("a", "b");
//        origin.put("b", "0");
//        origin.put("c", "a");
//        origin.put("d", "e");
//        origin.put("e", "b");
//        origin.put("f", "b");
//        origin.put("g", "b");
//        origin.put("h", "e");
//        origin.put("i", "c");
//        origin.put("j", "e");
//        origin.put("k", "f");
//
//
//        TreeNode.outputNode(TreeNode.buildTree(origin));
    }

    @Test
    void test03() {
        HashMap<String, List> hm = new HashMap<>();
        ArrayList<String> s = new ArrayList<>();
        s.add("10");
        s.add("11");
        hm.put("0", s);
        System.out.println(hm.get("0").get(1));
    }
}
