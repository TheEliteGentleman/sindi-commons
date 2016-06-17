/**
 * 
 */
package za.co.sindi.common.utils;

/**
 * @author Bienfait Sindi
 * @since 17 February 2015
 *
 */
public final class Words {

	private Words() {
		throw new AssertionError("Private Constructor.");
	}
	
	private static boolean isDelimiter(char delimiter, char[] delimiters) {
		if (delimiters != null) {
			for (char delim : delimiters) {
				if (delimiter == delim) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static String capitalize(CharSequence words) {
		return capitalize(words, (char[])null);
	}
	
	public static String capitalize(CharSequence words, char... delimiters) {
		if (Strings.isNull(words)) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean mustCapitalize = true; //First character must always be capitalized.
		for (int i = 0; i < words.length(); i++) {
			char letter = words.charAt(i);
			if (isDelimiter(letter, delimiters)) {
				mustCapitalize = true;
				sb.append(letter);
			} else if (mustCapitalize) {
				sb.append(Character.toUpperCase(letter));
				mustCapitalize = false;
			} else {
				sb.append(letter);
			}
		}
		
		return sb.toString();
	}
	
	public static String uncapitalize(CharSequence words) {
		return uncapitalize(words, (char[])null);
	}
	
	public static String uncapitalize(CharSequence words, char... delimiters) {
		if (Strings.isNull(words)) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean mustUncapitalize = true; //First character must always be uncapitalized.
		for (int i = 0; i < words.length(); i++) {
			char letter = words.charAt(i);
			if (isDelimiter(letter, delimiters)) {
				mustUncapitalize = true;
				sb.append(letter);
			} else if (mustUncapitalize) {
				sb.append(Character.toLowerCase(letter));
				mustUncapitalize = false;
			} else {
				sb.append(letter);
			}
		}
		
		return sb.toString();
	}
	
	public static String toWikiCase(CharSequence words) {
		return toWikiCase(words, (char[])null);
	}
	
	public static String toWikiCase(CharSequence words, char... delimiters) {
		return capitalize(Strings.toLowerCase(words), delimiters);
	}
}
