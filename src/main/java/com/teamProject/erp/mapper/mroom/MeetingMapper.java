package com.teamProject.erp.mapper.mroom;

import com.teamProject.erp.common.Search.Search;
import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.dto.MeetingDTO;
import com.teamProject.erp.dto.ValidateMemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingMapper {

    // 글 쓰기 기능
    boolean save(MeetingDTO mrBoard);

    // 게시글 전체 조회
    List<MeetingDTO> findAll();

    // 게시글 전체 조회 with paging
    List<MeetingDTO> findAll(Page page);
    // 게시글 전체 조회 with searching
    List<MeetingDTO> findAll2(Search search);

    //게시글 상세 조회
    MeetingDTO findOne(Long mrNo);

    //게시글 삭제
    boolean remove(Long mrNo);

    //게시글 수정
    boolean modify(MeetingDTO mrBoard);

    //전체 게시물 수 조회
    int getTotalCount();
    int getTotalCount2(Search search);

    // 조회수 상승 처리
    void upViewCount(Long mrNo);

    // 파일 첨부 기능 처리
    void addFile(String fileName);

    //게시물에 붙어있는 첨부파일경로명 전부 조회하기
    List<String> findFileNames(Long mno);

    //게시물 번호로 게시글 작성자의 계정명과 권한 가져오기
    ValidateMemberDTO findMemberByMrNo(Long mrNo);

//    //목록
//    public List<MeetingDTO> findAll();
//    //수정
//    List<MeetingDTO> modifyMeeting(String type);
//    // 삭제
//    List<MeetingDTO> deleteMeeting(String type);
//    // 예약
//    List<MeetingDTO> resvMeeting(String type);
}
