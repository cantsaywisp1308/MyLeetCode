package trial;

public class clone {

	public static class C implements Cloneable {
		int x;

		C(int init) {
			this.x = init;
		}

		void setX(int value) {
			this.x = value;
		}

		int getX() {
			return this.x;
		}

		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		public static void main(String[] args) throws CloneNotSupportedException {
			C obj1 = new C(5);
			int y = obj1.getX();
			C obj2 = obj1;
			C obj3 = (C) obj1.clone();
			obj1.setX(3);
			System.out.println(y);
			System.out.println(obj2.getX());
			System.out.println(obj3.getX());
			System.exit(0);
		}
	}

}
