package com.DC.app.database.Models;

import javax.persistence.*;
import java.util.Date;


@Entity
public class VisitDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long visitID;
    @Column
    private long av_fk;
    @Column
    @Enumerated(EnumType.STRING)
    private visitType visitType;
    @Column
    private Date surveyDate;
    @Column
    private Date nextSurvey;
    @Column
    @Enumerated(EnumType.STRING)
    private propertyStatus propertyStatus;

    public long getVisitID() {
        return visitID;
    }

    public void setVisitID(long visitID) {
        this.visitID = visitID;
    }

    public visitType getVisitType() {
        return visitType;
    }

    public void setVisitType(visitType visitType) {
        this.visitType = visitType;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    public Date getNextSurvey() {
        return nextSurvey;
    }

    public void setNextSurvey(Date nextSurvey) {
        this.nextSurvey = nextSurvey;
    }

    public propertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(propertyStatus propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public long getAv_fk() {
        return av_fk;
    }

    public void setAv_fk(long av_fk) {
        this.av_fk = av_fk;
    }

    public enum propertyStatus {
        SURVEYED,UNSURVEYED,CLONE
    }

    public enum visitType {
        DESKTOP_SCS, EPC, ABS
    }

}
