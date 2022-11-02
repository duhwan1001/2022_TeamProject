package com.teamProject.erp.mapper.mroom;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.dto.MrDTO;
import com.teamProject.erp.dto.ValidateMemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MrMapper {

    //게시글 쓰기 기능
    boolean save(MrDTO mrdto);

    //게시글 전체 조회
    List<MrDTO> findAll();

    //게시글 전체 조회 with paging
    List<MrDTO> findAll(Page page);
    //게시글 전체 조회 with searching
    List<MrDTO> findAll2(Search search);

    //게시글 상세 조회
    MrDTO findOne(int mrNo);

    //게시글 삭제
    boolean remove(int mrNo);

    //게시글 수정
    boolean modify(MrDTO mrdto);

    //파일 첨부 기능 처리
    void addFile(String fileName);

    //게시물에 붙어있는 첨부파일경로명 전부 조회하기
    List<String> findFileNames(int mno);

    //게시물 번호로 게시글 작성자의 계정명과 권한 가져오기
    ValidateMemberDTO findMemberByMrNo(int mrNo);
}
