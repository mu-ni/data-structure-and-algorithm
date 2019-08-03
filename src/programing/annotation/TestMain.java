package programing.annotation;

@TestAnnotation(name = "world")
//@TestAnnotation
public class TestMain {

	public static void main(String[] args) {
		TestAnnotation annotation = TestMain.class.getAnnotation(TestAnnotation.class);
		System.out.println(annotation.name());
	}

}
