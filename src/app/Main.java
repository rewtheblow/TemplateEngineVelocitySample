package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import entity.Member;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Program start");
		
		// データのセット
		List<Member> members	= new ArrayList<Member>();
		for(int i = 0; i <= 5; i++){
			Member member					= new Member();
			List<String> favoriteLessons	= new ArrayList<String>();
			switch(i) {
				case 0:
					member.setName("しょー");
					member.setOccupation("プログラマー(会社曰くシステムエンジニア（笑）)");
					favoriteLessons.add("ソフトウェア開発プロセス特論");
					break;
				case 1:
					member.setName("たい");
					member.setOccupation("DBエンジニア(けど、DB以外もいろいろやってます)");
					favoriteLessons.add("Javaプログラミング技法");
					favoriteLessons.add("オブジェクト指向開発特論");
					favoriteLessons.add("ソフトウェア開発特論Ⅰ");
					break;
				case 2:
					member.setName("ただ");
					member.setOccupation("プログラマ兼PMみたいな仕事");
					favoriteLessons.add("アーキテクト系や開発系");
					break;
				case 3:
					member.setName("あっけ");
					member.setOccupation("Javaプログラマ");
					favoriteLessons.add("情報ビジネス特別講義などの一見ITとは関わりがなさそうな授業");
					break;
				case 4:
					member.setName("あっき");
					member.setOccupation("開発者");
					favoriteLessons.add("情報アーキテクチャ特論II");
					break;
				case 5:
					member.setName("りゅー");
					member.setOccupation("プログラマ（と言ってるけど、業務でコードはまず書くことはなし）。タイトルはプロジェクトマネージャ、実態はクラウドインフラエンジニア兼ビジネス企画開発");
					favoriteLessons.add("ソフトウェア工学特論");
					favoriteLessons.add("システムモデリング（創造）");
					favoriteLessons.add("OSS特論");
					break;
			}
			member.setFavoriteLessons(favoriteLessons);
			members.add(member);
		}
		System.out.println("Memberクラスのオブジェクトに、各メンバーの氏名、職種、好きな授業（複数可）のデータをセットしました");
		
		// Velocity を利用して、テンプレートファイル上にデータを展開し、ファイルに出力
		VelocityWrapper velWrapper;
		try {
			velWrapper = new VelocityWrapper("./template/AkiguchiPBL.vm");				// Velocity のラッパークラスのオブジェクトを生成　※ラッパーオブジェクトの詳細はロジック追う必要はないかと
			velWrapper.put("members", members);											// データをセットした members オブジェクトを、テンプレートファイル上の "members" と関連付ける
			String result = velWrapper.merge();											// テンプレート上にデータを展開し、ひとつの文字列オブジェクトとする
			System.out.println("Memberクラスのオブジェクトの情報を、./template/AkiguchiPBL.vmのテンプレートファイル上に展開しました");

			PrintWriter pw	= new PrintWriter("output.xml", "UTF-8");
			pw.print(result);															// 文字列オブジェクトをファイルに出力
			System.out.println("展開した情報を、./output.xmlとして出力しました");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Program end");
	}

}
