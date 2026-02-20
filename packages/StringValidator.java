// แทน 680510716

package packages;

public class StringValidator {
	public StringValidator() {}

	public static String validateString(String text, String fieldName)
	{
		if (text == null)
			throw new NullPointerException(fieldName + " is null");

		String trimmed = text.trim();

		if (trimmed.isEmpty())
			throw new IllegalArgumentException(fieldName + " is blank");

		return trimmed;
	}
}
