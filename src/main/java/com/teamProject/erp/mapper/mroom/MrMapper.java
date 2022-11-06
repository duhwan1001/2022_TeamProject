package com.teamProject.erp.mapper.mroom;

import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.search.Search;
import com.teamProject.erp.dto.MrDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MrMapper {

    // 회의실 목록 출력
    List<MrDTO> mrFindAll();

    // 회의실 목록 출력 - 페이징
    List<MrDTO> mrFindAll(Page page);

    // 회의실 리스트 출력 - 검색어 입력
    List<MrDTO> mrFindSearchAll(Search search);

    // 회의실 상세 보기
    MrDTO mrFindOne(Integer mrNo);

    // 회의실 예약
    boolean mrInsert(MrDTO mrDTO);

    // 회의실 수정
    boolean mrModify(MrDTO mrDTO);

    // 회의실 삭제
    boolean mrDelete(Integer mrNo);

    // 전체 게시물 수 조회
    int mrGetTotalCount();

    // 전체 게시물 수 조회 - 검색
    int mrGetTotalSearchCount(Search search);

    // 파일 업로드 기능 처리
    void mrAddFile(String mrFileName);

    // 게시물에 붙어있는 첨부파일경로명 전부 조회하기
//    List<String> mrFindFileNames(Long mno);

    //게시물 번호로 게시글 작성자의 계정명과 권한 가져오기
//    ValidateMemberDTO findMemberByMrNo(Long mrNo);
}
