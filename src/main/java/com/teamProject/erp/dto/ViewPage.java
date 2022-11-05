package com.teamProject.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor
public class ViewPage {

    private int viewpageNo;  // 페이지 처음번호
    private int viewamountNo; //페이지 끝번호

    public ViewPage(){
        viewpageNo = 1;
        viewamountNo =10;
    }

    public int getstart(){
        return (viewpageNo -1)* viewamountNo;
    }

    public void setViewpageNo(int viewpageNo) {
        if (viewpageNo <= 0 || viewpageNo > Integer.MAX_VALUE){
            this.viewpageNo = 1;
            return;
        }
        this.viewpageNo = viewpageNo;
    }

    public void setViewamountNo(int viewamountNo) {
        if (viewamountNo <10 || viewamountNo>100){
            this.viewamountNo = 10;
            return;
        }
        this.viewamountNo = viewamountNo;
    }
}
