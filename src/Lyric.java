
public class Lyric {
	public int time;
	public String singer;
	public String lyric;
	
	public Lyric(int time, String singer, String lyric) {
		this.time = time;
		this.singer = singer;
		this.lyric = lyric;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getSinger() {
		return singer;
	}
	
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String getLyric() {
		return lyric;
	}
	
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
}
