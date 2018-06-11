package com.zz.common.model;

import java.sql.Timestamp;

public class Opdata extends OpdataKey {
    private float cTkwh;
    //用于数据显示start
    private float tbianshi;
	private Integer cTsegmentid;
	private String cTsegmentname;
	//用于总的数据显示end
    private Integer cFaultid;

    
	private String cFramecmdid;

    private float cEekwh;

    private Integer cEeopenminute;

    private Integer cEecloseminute;

    private Integer cEeopenclosetimes;

    private float cEepeakw;

    private Timestamp cRecordinserttime;

    private Boolean cIsvalidrecord;

    /**
     * 事件发生时间
     */
    private String eventTime;

    
    public float getTbianshi() {
		return tbianshi;
	}

	public void setTbianshi(float tbianshi) {
		this.tbianshi = tbianshi;
	}

	public Integer getcTsegmentid() {
		return cTsegmentid;
	}

	public void setcTsegmentid(Integer cTsegmentid) {
		this.cTsegmentid = cTsegmentid;
	}

	public String getcTsegmentname() {
		return cTsegmentname;
	}

	public void setcTsegmentname(String cTsegmentname) {
		this.cTsegmentname = cTsegmentname;
	}

    public float getcTkwh() {
        return cTkwh;
    }

    public void setcTkwh(Float cTkwh) {
        this.cTkwh = cTkwh;
    }

    public Integer getcFaultid() {
        return cFaultid;
    }

    public void setcFaultid(Integer cFaultid) {
        this.cFaultid = cFaultid;
    }

    public String getcFramecmdid() {
        return cFramecmdid;
    }

    public void setcFramecmdid(String cFramecmdid) {
        this.cFramecmdid = cFramecmdid == null ? null : cFramecmdid.trim();
    }

    public float getcEekwh() {
        return cEekwh;
    }

    public void setcEekwh(float f) {
        this.cEekwh = f;
    }

    public Integer getcEeopenminute() {
        return cEeopenminute;
    }

    public void setcEeopenminute(Integer cEeopenminute) {
        this.cEeopenminute = cEeopenminute;
    }

    public Integer getcEecloseminute() {
        return cEecloseminute;
    }

    public void setcEecloseminute(Integer cEecloseminute) {
        this.cEecloseminute = cEecloseminute;
    }

    public Integer getcEeopenclosetimes() {
        return cEeopenclosetimes;
    }

    public void setcEeopenclosetimes(Integer cEeopenclosetimes) {
        this.cEeopenclosetimes = cEeopenclosetimes;
    }

    public float getcEepeakw() {
        return cEepeakw;
    }

    public void setcEepeakw(float cEepeakw) {
        this.cEepeakw = cEepeakw;
    }

    public Timestamp getcRecordinserttime() {
        return cRecordinserttime;
    }

   

    public void setcRecordinserttime(Timestamp cRecordinserttime) {
		this.cRecordinserttime = cRecordinserttime;
	}

	public Boolean getcIsvalidrecord() {
        return cIsvalidrecord;
    }

    public void setcIsvalidrecord(Boolean cIsvalidrecord) {
        this.cIsvalidrecord = cIsvalidrecord;
    }

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
    
}