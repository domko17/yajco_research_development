package mylang.parser.beaver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import beaver.Symbol;
import beaver.Scanner;
import mylang.parser.beaver.LALRSimpleIdentifierParser.Terminals;

public class LALRSimpleIdentifierParserScanner extends Scanner {

	private int line = 1;
	private int column = 1;
	private String input;
        private int position = 0;
	private static final Map<Short, Pattern> tokens = new LinkedHashMap<Short, Pattern>();
	private static final List<Pattern> skips = new ArrayList<Pattern>();

	static {
		tokens.put(Terminals.SYMBOLID, Pattern.compile("id"));

		tokens.put(Terminals.ident, Pattern.compile("[a-z]+"));

		skips.add(Pattern.compile("\\s"));
	}

	public LALRSimpleIdentifierParserScanner(String input) {
		this.input = input;
                position = 0;
	}

	@Override
	public Symbol nextToken() throws IOException, Scanner.Exception {
		skipWhiteSpaces();

		if (input.length() == position) {
			return new Symbol(Terminals.EOF, line, column);
		}

		return findToken();
	}

	private void skipWhiteSpaces() {
		boolean matched;
		do {
			matched = false;
			Matcher matcher = null;
			for (Pattern skip : skips) {
				if (matcher == null) {
					matcher = skip.matcher(input);
				} else {
					matcher.usePattern(skip);
				}
                                matcher.useTransparentBounds(true);
                                matcher.region(position, input.length());
				if (matcher.lookingAt()) {
					//Consume the white space from the input
					consumeInput(matcher.group().length());
					matched = true;
					matcher = null;
					break;
				}
			}
		} while (matched);
	}

	private Symbol findToken() throws IOException, Scanner.Exception {
		Matcher matcher = null;
		int longest = 0;
		Symbol token = null;
		for (Map.Entry<Short, Pattern> entry : tokens.entrySet()) {
			if (matcher == null) {
				matcher = entry.getValue().matcher(input);
			} else {
				matcher.usePattern(entry.getValue());
			}
                        matcher.useTransparentBounds(true);
                        matcher.region(position, input.length());
			if (matcher.lookingAt()) {
				String group = matcher.group();
				if (longest < group.length()) {
					longest = group.length();
					for (int i = 1; i <= matcher.groupCount(); i++) {
						if (matcher.group(i) != null) {
							group = matcher.group(i);
							break;
						}
					}

					//Create token
					token = new Symbol(entry.getKey(), line, column, longest, group);
				}
			}
		}

		//Return the longest matching token, consume it from input
		if (token != null) {
			consumeInput(longest);
			return token;
        }

		Scanner.Exception exception = new Scanner.Exception(line, column, "Unrecognized character detected: '" + input.charAt(position) + "'!");
		// Beaver sa pokusa o error recovering, a preto je nutne, aby sme preskocili dany nespravny znak, pretoze ak
		// sa tak neucini, tak vznikne nekonecny cyklus a vypisy na konzolu s danou chybou
		consumeInput(1);
		throw exception;
	}

	private void consumeInput(int length) {
		for (int i = 0; i < length; i++) {
			char c = input.charAt(position+i);
			column++;
			if (c == '\n') {
				column = 1;
				line++;
			}
		}
                position = position + length;
	}
}