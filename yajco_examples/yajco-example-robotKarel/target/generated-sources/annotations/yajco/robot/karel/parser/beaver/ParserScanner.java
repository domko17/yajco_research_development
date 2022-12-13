package yajco.robot.karel.parser.beaver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import beaver.Symbol;
import beaver.Scanner;
import yajco.robot.karel.parser.beaver.Parser.Terminals;

public class ParserScanner extends Scanner {

	private int line = 1;
	private int column = 1;
	private String input;
        private int position = 0;
	private static final Map<Short, Pattern> tokens = new LinkedHashMap<Short, Pattern>();
	private static final List<Pattern> skips = new ArrayList<Pattern>();

	static {
		tokens.put(Terminals.SYMBOLLEFT_45_IS_45_BLOCKED, Pattern.compile("LEFT[-]IS[-]BLOCKED"));
		tokens.put(Terminals.SYMBOLWHILE, Pattern.compile("WHILE"));
		tokens.put(Terminals.SYMBOLEND_45_OF_45_EXECUTION, Pattern.compile("END[-]OF[-]EXECUTION"));
		tokens.put(Terminals.SYMBOLBACK_45_IS_45_BLOCKED, Pattern.compile("BACK[-]IS[-]BLOCKED"));
		tokens.put(Terminals.SYMBOLTIMES, Pattern.compile("TIMES"));
		tokens.put(Terminals.SYMBOLNO_45_BEEPERS_45_IN_45_BEEPER_45_BAG, Pattern.compile("NO[-]BEEPERS[-]IN[-]BEEPER[-]BAG"));
		tokens.put(Terminals.SYMBOLFACING_45_SOUTH, Pattern.compile("FACING[-]SOUTH"));
		tokens.put(Terminals.SYMBOLNOT_45_FACING_45_SOUTH, Pattern.compile("NOT[-]FACING[-]SOUTH"));
		tokens.put(Terminals.SYMBOLFRONT_45_IS_45_CLEAR, Pattern.compile("FRONT[-]IS[-]CLEAR"));
		tokens.put(Terminals.SYMBOLNOT_45_NEXT_45_TO_45_A_45_BEEPER, Pattern.compile("NOT[-]NEXT[-]TO[-]A[-]BEEPER"));
		tokens.put(Terminals.SYMBOLBEGINNING_45_OF_45_EXECUTION, Pattern.compile("BEGINNING[-]OF[-]EXECUTION"));
		tokens.put(Terminals.SYMBOLFACING_45_WEST, Pattern.compile("FACING[-]WEST"));
		tokens.put(Terminals.SYMBOLNOT_45_FACING_45_NORTH, Pattern.compile("NOT[-]FACING[-]NORTH"));
		tokens.put(Terminals.SYMBOLANY_45_BEEPERS_45_IN_45_BEEPER_45_BAG, Pattern.compile("ANY[-]BEEPERS[-]IN[-]BEEPER[-]BAG"));
		tokens.put(Terminals.SYMBOLFACING_45_NORTH, Pattern.compile("FACING[-]NORTH"));
		tokens.put(Terminals.SYMBOLIF, Pattern.compile("IF"));
		tokens.put(Terminals.SYMBOLFACING_45_EAST, Pattern.compile("FACING[-]EAST"));
		tokens.put(Terminals.SYMBOLEND_45_OF_45_PROGRAM, Pattern.compile("END[-]OF[-]PROGRAM"));
		tokens.put(Terminals.SYMBOLBEGINNING_45_OF_45_PROGRAM, Pattern.compile("BEGINNING[-]OF[-]PROGRAM"));
		tokens.put(Terminals.SYMBOLTURNLEFT, Pattern.compile("TURNLEFT"));
		tokens.put(Terminals.SYMBOLDO, Pattern.compile("DO"));
		tokens.put(Terminals.SYMBOLITERATE, Pattern.compile("ITERATE"));
		tokens.put(Terminals.SYMBOLLEFT_45_IS_45_CLEAR, Pattern.compile("LEFT[-]IS[-]CLEAR"));
		tokens.put(Terminals.SYMBOLRIGHT_45_IS_45_CLEAR, Pattern.compile("RIGHT[-]IS[-]CLEAR"));
		tokens.put(Terminals.SYMBOLELSE, Pattern.compile("ELSE"));
		tokens.put(Terminals.SYMBOLTHEN, Pattern.compile("THEN"));
		tokens.put(Terminals.SYMBOLBEGIN, Pattern.compile("BEGIN"));
		tokens.put(Terminals.SYMBOLPUTBEEPER, Pattern.compile("PUTBEEPER"));
		tokens.put(Terminals.SYMBOLNOT_45_FACING_45_EAST, Pattern.compile("NOT[-]FACING[-]EAST"));
		tokens.put(Terminals.SYMBOLBACK_45_IS_45_CLEAR, Pattern.compile("BACK[-]IS[-]CLEAR"));
		tokens.put(Terminals.SYMBOLDEFINE, Pattern.compile("DEFINE"));
		tokens.put(Terminals.SYMBOLAS, Pattern.compile("AS"));
		tokens.put(Terminals.SYMBOLFRONT_45_IS_45_BLOCKED, Pattern.compile("FRONT[-]IS[-]BLOCKED"));
		tokens.put(Terminals.SYMBOLEND, Pattern.compile("END"));
		tokens.put(Terminals.SYMBOLTURNOFF, Pattern.compile("TURNOFF"));
		tokens.put(Terminals.SYMBOLPICKBEEPER, Pattern.compile("PICKBEEPER"));
		tokens.put(Terminals.SYMBOLMOVE, Pattern.compile("MOVE"));
		tokens.put(Terminals.SYMBOLNEXT_45_TO_45_A_45_BEEPER, Pattern.compile("NEXT[-]TO[-]A[-]BEEPER"));
		tokens.put(Terminals.SYMBOLNOT_45_FACING_45_WEST, Pattern.compile("NOT[-]FACING[-]WEST"));
		tokens.put(Terminals.SYMBOLRIGHT_45_IS_45_BLOCKED, Pattern.compile("RIGHT[-]IS[-]BLOCKED"));

		tokens.put(Terminals.VALUE, Pattern.compile("[0-9]+"));
		tokens.put(Terminals.IDENT, Pattern.compile("[a-zA-Z]+"));

		skips.add(Pattern.compile(" "));
		skips.add(Pattern.compile("\\t"));
		skips.add(Pattern.compile("\\n"));
		skips.add(Pattern.compile("\\r"));
	}

	public ParserScanner(String input) {
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