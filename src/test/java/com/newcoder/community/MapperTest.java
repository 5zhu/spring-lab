package com.newcoder.community;

import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.service.DiscussPostService;
import com.newcoder.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: geguofeng
 * @Date: 2020/11/9
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringLabApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private DiscussPostService discussPostService;


    @Test
    public void testSelectById(){
        System.out.println(userMapper.selectByName("aaa"));
    }

    @Test
    public void testDiscussPost(){
        List<DiscussPost> list = discussPostService.findDiscussPosts(101,0,10);
        list.stream().forEach(System.out::println);
    }

}
