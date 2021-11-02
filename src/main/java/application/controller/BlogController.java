package application.controller;


import application.model.Blog;
import application.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/users")
    public List<Blog> getBlogByMember (@PathVariable("user") String userName){
        if (userName != null) {
            return blogService.getBlogByMember(userName);
        }
        return null;
    }

    @GetMapping("/users")
    public List<Blog> getBlogById(@PathVariable("byBlogId") long idBlog) {
        if( idBlog != 0){
            return blogService.getBlogById(idBlog);
        }
        return null;
    }
}
