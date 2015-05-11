package exceptions;

public class Finally {
	@SuppressWarnings("finally")
	public static String stranglet(String message)
			throws IllegalArgumentException {
		try {
			int num = message.length();
			if (num > 10) {
				throw new IllegalArgumentException("Too many characters");
			}
			return message;

		} catch (IllegalArgumentException ex) {
			System.out.println("The message is too big");
			// will never be thrown, overridden by finally
			throw new IllegalArgumentException("Too many characters in String");
		} catch (Throwable t) {
			System.out
					.println("Throwable: Something now went really wrong! But what could it be?");
			// will never be thrown, overridden by finally
			throw new IllegalArgumentException("I have to stop now");
		} finally {
			System.out.println("Did you know: This part comes ALWAYS");
			return "MESSAGE";
		}
	}

	public static void main(String[] args) {
		String message = null;

		message = stranglet(null);
		System.out.println(message);
		message = stranglet("One");
		System.out.println(message);
		message = stranglet("asdfasdfasdfasdfasdfasdfasdfasdf");
		System.out.println(message);
	}
	
	
}
