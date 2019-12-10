package com.raf.infoservice.dto;

public class ScoreDto {

    private String winner;
    private String duration;
    private FullTime fullTime;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public FullTime getFullTime() {
        return fullTime;
    }

    public void setFullTime(FullTime fullTime) {
        this.fullTime = fullTime;
    }

    public static class FullTime {

        private Short homeTeam;
        private Short awayTeam;

        public Short getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(Short homeTeam) {
            this.homeTeam = homeTeam;
        }

        public Short getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(Short awayTeam) {
            this.awayTeam = awayTeam;
        }
    }
}
