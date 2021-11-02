package application.controller;


import application.model.Comments;
import application.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CommentController {

  private CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/user")
  public List<Comments> getCommentByBlog(
          @PathVariable("byId") long idBlog) {
    if (idBlog != 0) {
      return commentService.getCommentByBlog(idBlog);
    }
    return null;
  }
}
