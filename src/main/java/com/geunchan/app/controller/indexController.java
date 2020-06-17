package com.geunchan.app.controller;

import com.geunchan.app.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.geunchan.app.repository.BoardRepository;
import com.geunchan.app.repository.UserRepository;

import java.util.List;


@Controller
public class indexController {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    public indexController(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boardList", boardList);
        return "index";
    }

}
