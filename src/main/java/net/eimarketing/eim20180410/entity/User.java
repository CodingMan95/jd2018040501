package net.eimarketing.eim20180410.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -8148928181238275012L;

	private String openid;
	private String nickname;
	private String headimgurl;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
}
