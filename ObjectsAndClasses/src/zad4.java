import java.util.ArrayList;
import java.util.Scanner;

public class zad4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		
		ArrayList<Song> songs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] arr = s.nextLine().split("_");

			String type = arr[0];
			String name = arr[1];
			String time = arr[2];
			
			Song sn = new Song();
			
			sn.setTypeList(type);
			sn.setName(name);
			sn.setTime(time);
			songs.add(sn);

		}
		String typeList = s.nextLine();
		if (typeList.equals("all")) {
			for (Song song : songs) {
				System.out.println(song.getName());
			}

		} else {
			for (Song song : songs) {
				if (song.getTypeList().equals(typeList)) {
					System.out.println(song.getName());
				}
			}
		}
		s.close();
	}

}

class Song {
	private String typeList;
	private String name;
	private String time;

	public void setTypeList(String type) {
		typeList = type;
	}

	public String getTypeList() {
		return typeList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	@Override

	public String toString() {
		return "Type of list: " + typeList + ", Name of the song: " + name + ", Length of the song: " + time;
	}
}
