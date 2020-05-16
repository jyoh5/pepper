package com.pepper.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pepper.domain.BoardVO;
import com.pepper.domain.Page;
import com.pepper.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	BoardService service;
	
	// ============================= 게시글 목록 조회 + 검색 ============================= 
	// 목록 조회 get
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getlist(Model model, @RequestParam("num") int num, 
			@RequestParam(value = "searchType", required=false, defaultValue="title") String searchType,
			@RequestParam(value = "keyword", required=false, defaultValue="") String keyword) throws Exception {
		
		logger.info("get list" + keyword);
	
		Page page = new Page();
		
		page.setNum(num);
		page.setListCnt(service.listCnt(searchType, keyword));
		
		List<BoardVO> list = service.listSearch(page.getStartPost(), page.getPostCnt(), searchType, keyword);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("nowPage", num);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
	}
	
	// ============================= 글쓰기 ============================= 
	// 글쓰기 get (글쓰기 페이지로 이동)
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void getWrite(Model model, @RequestParam("num") int num, 
			@RequestParam(value = "searchType", required=false, defaultValue="title") String searchType,
			@RequestParam(value = "keyword", required=false, defaultValue="") String keyword) throws Exception {
		
		logger.info("get write");
		
		model.addAttribute("num", num);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		
	}
	// 글쓰기 post
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {
		
		logger.info("post write");
		service.write(vo);
		
		return "redirect:/board/list?num=1";
	}
	
	// ============================= 글 상세 보기 ============================= 
	// 글 상세 보기 get (글쓰기 페이지로 이동)
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void getView(Model model, @RequestParam("bno") int bno, @RequestParam("num") int num, 
			@RequestParam(value = "searchType", required=false, defaultValue="title") String searchType,
			@RequestParam(value = "keyword", required=false, defaultValue="") String keyword) throws Exception {
		
		logger.info("get View");
		service.viewCnt(bno);
		BoardVO result = service.view(bno);
		
		
		model.addAttribute("view", result);
		model.addAttribute("num", num);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
	}
		
	// ============================= 글 수정하기 ============================= 
	// 글 수정하기 get (글 수정 페이지로 이동)
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public void getEdit(Model model, @RequestParam("bno") int bno, @RequestParam("num") int num, 
			@RequestParam(value = "searchType", required=false, defaultValue="title") String searchType,
			@RequestParam(value = "keyword", required=false, defaultValue="") String keyword) throws Exception {
		
		logger.info("get edit");
		
		BoardVO result = service.view(bno);
		
		model.addAttribute("view", result);
		model.addAttribute("num", num);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		
	}
	// 글 수정하기 post
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String postEdit(BoardVO vo, @RequestParam("num") int num, 
			@RequestParam(value = "searchType", required=false, defaultValue="title") String searchType,
			@RequestParam(value = "keyword", required=false, defaultValue="") String keyword) throws Exception {
		
		logger.info("post edit");
		service.edit(vo);
		
		return "redirect:/board/view?num= "+ num + "&bno=" + vo.getBno() + "&searchType=" + searchType + "&keyword=" + keyword;
	}
	
	// ============================= 글 삭제하기 ============================= 
	// 글 삭제하기 get
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
		
		logger.info("get delete");
		
		service.delete(bno);
		
		return "redirect:/board/list?num=1";
	}
}
