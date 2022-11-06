package com.teamProject.erp.mapper.notice;

import com.teamProject.erp.common.paging.Page;
import com.teamProject.erp.common.search.Search;
import com.teamProject.erp.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    // 공지사항 리스트 출력
    List<NoticeDTO> noticeFindAll();

    // 공지사항 리스트 출력 - 페이징
    List<NoticeDTO> noticeFindAll(Page page);

    // 공지사항 리스트 출력 - 검색어 입력
    List<NoticeDTO> noticeFindSearchAll(Search search);

    // 공지사항 상세 보기
    NoticeDTO noticeFindOne(Integer noticeNo);

    // 공지사항 등록
    boolean noticeInsert(NoticeDTO noticeDTO);

    // 공지사항 수정
    boolean noticeModify(NoticeDTO noticeDTO);

    // 공지사항 삭제
    boolean noticeDelete(Integer noticeNo);

    // 조회수 상승 처리
    void noticeUpViewCount(Integer noticeNo);

    // 전체 게시물 수 조회
    int noticeGetTotalCount();

    // 전체 게시물 수 조회 - 검색
    int noticeGetTotalSearchCount(Search search);

    // 파일 업로드 기능 처리
//    void noticeAddFile(String noticeFileName);

    // 게시물에 붙어있는 첨부파일경로명 전부 조회하기
//    List<String> noticeFindFileNames(Long nno);

    // 게시물 번호로 게시글 작성자의 계정명과 권한 가져오기
//    ValidateMemberDTO findMemberByNoticeNo(Long noticeNo);
}
