package com.newcoder.community.controller;

import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.Page;
import com.newcoder.community.entity.User;
import com.newcoder.community.service.DiscussPostService;
import com.newcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: geguofeng
 * @Date: 2020/11/11
 * @Description:
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostRows(101));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(101,0,10);
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if(list != null){
            for(DiscussPost post : list){
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";

    }

}
