package chapter_1_arraysandstring;

public class Question_1_1 {

	/**
	 * 通过bool数组存储标志
	 * 
	 * @param str
	 * @return
	 */
	public boolean isUnique(String str) {
		boolean[] flag = new boolean[26];
		for (int i = 0; i < 26; i++) {
			flag[i] = false;
		}

		int len = str.length();
		for (int i = 0; i < len; i++) {
			int j = str.charAt(i) - 'a';
			if (flag[j]) {
				return false;
			} else {
				flag[j] = true;
			}
		}
		return true;
	}

	/**
	 * 通过int 4个字节 位运算 减少存储空间
	 * 
	 * @param str
	 * @return
	 */
	public boolean isUnique2(String str) {
		int map = 0; // 00000000 00000000 00000000 00000000
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int j = str.charAt(i) - 'a';
			if ((map & (1 << j)) != 0) {
				return false;
			} else {
				map |= (1 << j);
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Question_1_1 question = new Question_1_1();
		String str = "abcdefghijklmnopqrstuvwxyz";
		if (question.isUnique(str)) {
			System.out.println("Unique!");
		} else {
			System.out.println("Not Unique!");
		}

		if (question.isUnique2(str)) {
			System.out.println("Unique!");
		} else {
			System.out.println("Not Unique!");
		}
	}
}
