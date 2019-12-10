package com.raf.infoservice.dto;

import java.time.Instant;

public class MatchDto {

    private Long id;
    private Instant utcDate;
    private ScoreDto score;
    private TeamDto homeTeam;
    private TeamDto awayTeam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(Instant utcDate) {
        this.utcDate = utcDate;
    }

    public ScoreDto getScore() {
        return score;
    }

    public void setScore(ScoreDto score) {
        this.score = score;
    }

    public TeamDto getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamDto homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamDto getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamDto awayTeam) {
        this.awayTeam = awayTeam;
    }
}
