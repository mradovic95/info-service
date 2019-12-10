package com.raf.infoservice.dto;

import java.io.Serializable;
import java.util.List;

public class MatchesDto implements Serializable {

    private Integer count;
    private List<MatchDto> matches;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<MatchDto> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDto> matches) {
        this.matches = matches;
    }
}
