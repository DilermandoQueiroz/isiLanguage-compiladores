import java.util.Scanner;
public class MainClass {
	public static void main(String args[]) {
		Scanner _key = new Scanner(System.in);
		double  a;
		double  b;
		double  c;
		double  d;
		String  e;
		System.out.println("Programa Teste");
		System.out.println("Digite A");
		a= _key.nextDouble();
		System.out.println("Digite B");
		b= _key.nextDouble();
		if (a<b) {
c = a+b;}else {
c = a-b;}

		System.out.println("C e igual a ");
		System.out.println(c);
		d = c*a+b;
		System.out.println("D e igual a ");
		System.out.println(d);
	}
}