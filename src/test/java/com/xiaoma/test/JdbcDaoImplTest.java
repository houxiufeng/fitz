package com.xiaoma.test;

import com.dexcoder.assistant.interceptor.PageControl;
import com.dexcoder.assistant.pager.Pager;
import com.dexcoder.assistant.persistence.Criteria;
import com.dexcoder.assistant.persistence.JdbcDao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class JdbcDaoImplTest extends BaseTest {

    @Autowired
    private JdbcDao jdbcDao;
    private Test1    test1;
    
    @Before
    public void before() {
        test1 = new Test1();
        test1.setAge(30);
        test1.setName("fitz");
        test1.setUserGradeId(1);
        test1.setCreatedAt(new Date());
        test1.setUpdatedAt(new Date());
    }

    @Test
    public void testJoin() {
        List<TestVo> testvos = jdbcDao.querySql(TestVo.class, "select a.id, a.name, a.age, b.desc from test1 a left join test2 b on a.user_grade_id = b.id where a.user_grade_id = ?", new Object[]{1});
        for (TestVo vo : testvos) {
            System.out.println( vo.getId() + " " + vo.getName() + " " + vo.getAge() + " " + vo.getDesc());
        }
    }
    
    @Test
    public void insert() {
        int id = jdbcDao.insert(test1);
        System.out.println(id);
    }
    

    @Test
    public void insert2() {
        Criteria criteria = Criteria.create(Test1.class).set("name", "liyd22")
            .set("age", 22).set("createdAt", new Date());
        int id = jdbcDao.insert(criteria);
        System.out.println(id);
    }

    @Test
    public void save() {
        test1.setId(99);
        jdbcDao.save(test1);
    }

    @Test
    public void save2() {
        Criteria criteria = Criteria.create(Test1.class).set("id", -99)
            .set("name", "liyd22").set("age", 22).set("createdAt", new Date())
            .set("updatedAt", new Date());
        jdbcDao.save(criteria);
    }

    @Test
    public void update() {
        test1.setId(1);
        test1.setName("clack");
        test1.setUpdatedAt(new Date());
        jdbcDao.update(test1);
    }

    @Test
    public void update2() {
        Criteria criteria = Criteria.create(Test1.class).set("name", "liydCriteria")
            .set("age", "18").where("id", new Object[] { 34L, 33L, 32L });
        jdbcDao.update(criteria);
    }

    @Test
    public void delete() {
        Test1 u = new Test1();
        u.setName("kent");
        u.setAge(16);
        jdbcDao.delete(u);
    }

    @Test
    public void delete2() {
        Criteria criteria = Criteria.create(Test1.class).where("name", new Object[] { "liyd2" }).or("age", new Object[]{64});
        jdbcDao.delete(criteria);
    }

    @Test
    public void delete3() {
        jdbcDao.delete(Test1.class, 25);
    }

    @Test
    public void queryList() {
        Test1 u = new Test1();
        u.setName("liyd");
        List<Test1> users = jdbcDao.queryList(u);
        for (Test1 us : users) {
            System.out.println(us.getName() + " " + us.getAge());
        }
    }

@Test
public void queryList1() {
    Test1 user = new Test1();
    PageControl.performPage(user);
    jdbcDao.queryList(user);
    Pager pager = PageControl.getPager();
    List<Test1> users = pager.getList(Test1.class);
    System.out.println("总记录数：" + pager.getItemsTotal());
    for (Test1 us : users) {
        System.out.println(us.getName() + " " + us.getAge());
    }
}

@Test
public void queryList2() {
    PageControl.performPage(1, 10);
    Criteria criteria = Criteria.create(Test1.class).include("name", "id")
        .where("name", new Object[]{"liyd"}).asc("id");
    jdbcDao.queryList(criteria);
    List<Test1> users = PageControl.getPager().getList(Test1.class);
    for (Test1 us : users) {
        System.out.println(us.getId() + " " + us.getName() + " " + us.getAge());
    }
}

    @Test
    public void queryList3() {
        Criteria criteria = Criteria.create(Test1.class).exclude("id")
            .where("name", new Object[]{"liyd"}).asc("id").desc("age");
        List<Test1> users = jdbcDao.queryList(criteria);
        for (Test1 us : users) {
            System.out.println(us.getId() + " " + us.getName() + " " + us.getAge());
        }
    }

    @Test
    public void queryList4() {
        Criteria criteria = Criteria.create(Test1.class).where("name", "like",
            new Object[] { "%liyd%" });
        Test1 user1 = new Test1();
        user1.setAge(16);
        List<Test1> users = jdbcDao.queryList(user1, criteria.include("id"));
        for (Test1 us : users) {
            System.out.println(us.getId() + " " + us.getName() + " " + us.getAge());
        }
    }

    @Test
    public void queryList5() {
        List<Test1> users = jdbcDao.queryList(Criteria.create(Test1.class));
        for (Test1 us : users) {
            System.out.println(us.getId() + " " + us.getName() + " " + us.getAge());
        }
    }

    @Test
    public void queryCount() {
        Test1 u = new Test1();
        u.setName("liyd");
        int count = jdbcDao.queryCount(u);
        System.out.println(count);
    }

    @Test
    public void queryCount2() {
        Criteria criteria = Criteria.create(Test1.class).where("name", new Object[] { "liyd" })
            .or("age", new Object[]{27});
        int count = jdbcDao.queryCount(criteria);
        System.out.println(count);
    }

    @Test
    public void get() {

        Test1 u = jdbcDao.get(Test1.class, 99);
        System.out.println(u.getId() + " " + u.getName() + " " + u.getAge());

    }

    @Test
    public void get2() {
        Criteria criteria = Criteria.create(Test1.class).include("name");
        Test1 u = jdbcDao.get(criteria, 99);
        System.out.println(u.getId() + " " + u.getName() + " " + u.getAge());
    }

    @Test
    public void querySingleResult() {
        Test1 u = new Test1();
        u.setName("fitz");
        u.setAge(30);
        u.setId(3);
        u = jdbcDao.querySingleResult(u);
        System.out.println(u.getId() + " " + u.getName() + " " + u.getAge());
    }

    @Test
    public void querySingleResult2() {
        Criteria criteria = Criteria.create(Test1.class).where("name", new Object[] { "liyd" })
            .and("id", new Object[]{23});
        Test1 u = jdbcDao.querySingleResult(criteria);
        System.out.println(u.getId() + " " + u.getName() + " " + u.getAge());
    }

}