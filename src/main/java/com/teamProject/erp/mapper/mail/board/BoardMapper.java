package com.teamProject.erp.mapper.mail.board;

import com.teamProject.erp.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 쓰기 기능
    boolean save(BoardDTO boardDTO);

    //게시글 전체 조회
    List<BoardDTO> findAll();

}
