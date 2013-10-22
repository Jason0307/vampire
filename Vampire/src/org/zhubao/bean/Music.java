package org.zhubao.bean;

public class Music {

	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	@Override
	public String toString() {
		return "Music [Title=" + Title + ", Description=" + Description
				+ ", MusicUrl=" + MusicUrl + ", HQMusicUrl=" + HQMusicUrl + "]";
	}
	
	

}
