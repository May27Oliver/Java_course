import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class CovidIsolated {
	public static void main(String[] args) {
		// 產生一組公民
		GenerateID camp = new GenerateID();
		int[] citizens = camp.generate(camp.citizens);
		int[] connection = new ShuffleTheArray().shuffleFactory(camp.generate(camp.connection));
		System.out.print("[");
		for (int x = 0; x < citizens.length; ++x) {
			System.out.print(citizens[x]);
			System.out.print(",");
		}
		System.out.println("]");
		System.out.print("[");
		for (int x = 0; x < connection.length; ++x) {
			System.out.print(connection[x]);
			System.out.print(",");
		}
		System.out.println("]");
		new showIsolatedRelation().showIsolatedList(citizens, connection);
	}
}

//集中檢疫公民的class與其聯繫關係
class GenerateID {
	int[] citizens = new int[15];
	int[] connection = new int[15];

	static int[] generate(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		return a;
	}
}

//array在java中有int[]，array，List三種模式
//查詢這些公民之間的聯繫關係
class ShuffleTheArray {
	static int[] shuffleFactory(int[] a) {
		int j, temp;
		for (int i = 0; i < a.length; ++i) {
			j = (int) (Math.random() * 15);
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		return a;
	}
}

class showIsolatedRelation {
	static int[] showIsolatedList(int[] a, int[] b) {
		int[] isolatedList = new int[15];
		// 找出帶原者
		int i = (int) Math.random() * 15, // 帶原者在citizen陣列的index
				origin, // 帶原者編號
				j = 0;// 隔離陣列索引

		boolean endGame = false;// 中止查找關係
		origin = a[i];
		isolatedList[j] = origin;// 將帶原者列入隔離清單
		++j;

		while (j < 15) {// 開始找尋帶原者
			origin = b[i];
			isolatedList[j] = origin;
			for (int x = 0; x < a.length; ++x) {
				if (a[x] == origin) {
					i = x;
					break;
				}
			} // 找尋帶原者在公民陣列的index

			++j;
			for (int x = 0; x < isolatedList.length; ++x) {// 查看集中營裡有沒有重複的公民，如果有中止迴圈
				if (isolatedList[x] == b[i]) {
					endGame = true;
					break;
				}
			}

			if (endGame) {
				break;
			}
		}
		for (int x = 0; x < isolatedList.length; ++x) {
			if (isolatedList[x] == 0) {
				break;
			}
			System.out.println(isolatedList[x]);
		}
		return isolatedList;
	}
}