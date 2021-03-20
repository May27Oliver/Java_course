import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class CovidIsolated {
	public static void main(String[] args) {
		// ���ͤ@�դ���
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

//�����ˬ̤�����class�P���pô���Y
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

//array�bjava����int[]�Aarray�AList�T�ؼҦ�
//�d�߳o�Ǥ����������pô���Y
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
		// ��X�a���
		int i = (int) Math.random() * 15, // �a��̦bcitizen�}�C��index
				origin, // �a��̽s��
				j = 0;// �j���}�C����

		boolean endGame = false;// ����d�����Y
		origin = a[i];
		isolatedList[j] = origin;// �N�a��̦C�J�j���M��
		++j;

		while (j < 15) {// �}�l��M�a���
			origin = b[i];
			isolatedList[j] = origin;
			for (int x = 0; x < a.length; ++x) {
				if (a[x] == origin) {
					i = x;
					break;
				}
			} // ��M�a��̦b�����}�C��index

			++j;
			for (int x = 0; x < isolatedList.length; ++x) {// �d�ݶ�����̦��S�����ƪ������A�p�G������j��
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