package yajco.example.parser.javacc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParserTokenManager implements TokenManager, ExpressionParserConstants {
    private String input;

    private int line = 1;

    private int column = 1;

    private Token lastToken;

    private static final Map<Integer, Pattern> tokens = new LinkedHashMap<Integer, Pattern>();

    private static final List<Pattern> skips = new ArrayList<Pattern>();

    static {
        tokens.put(_40, Pattern.compile("[(]"));
        tokens.put(_41, Pattern.compile("[)]"));

        tokens.put(STAR, Pattern.compile("[*]"));
        tokens.put(SLASH, Pattern.compile("[/]"));
        tokens.put(MINUS, Pattern.compile("[-]"));
        tokens.put(PLUS, Pattern.compile("[+]"));
        tokens.put(VALUE, Pattern.compile("([0-9]+)"));

        skips.add(Pattern.compile(" "));
        skips.add(Pattern.compile("\\t"));
        skips.add(Pattern.compile("\\n"));
        skips.add(Pattern.compile("\\r"));
    }

    public ExpressionParserTokenManager(String input) {
        this.input = input;
    }

    public Token getNextToken() {
        //Skip white spaces
        skipWhiteSpaces();

        //Return EOF at the end of input
        if (input.length() == 0) {
            return Token.newToken(EOF);
        }

        //Search for the longest matching pattern - test every pattern
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

    private Token findToken() {
        Matcher matcher = null;
        int longest = 0;
        Token token = null;
        for (Map.Entry<Integer, Pattern> entry : tokens.entrySet()) {
            if (matcher == null) {
                matcher = entry.getValue().matcher(input);
            } else {
                matcher.usePattern(entry.getValue());
            }
            if (matcher.lookingAt()) {
                String group = matcher.group();
                if (longest < group.length()) {
                    longest = group.length();
                    int kind = entry.getKey();

                    // try to get first not null group
                    for (int i = 1; i <= matcher.groupCount(); i++) {
                        if (matcher.group(i) != null) {
                            group = matcher.group(i);
                            break;
                        }
                    }

                    //Create token                    
                    token = Token.newToken(kind, group);
                }
            }
        }

        //System.out.printf("Token %s\n", token.image);

        //Return the longest matching token, consume it from input
        if (token != null) {
            //System.out.printf("Token recognized: %s (%d) with image:'%s'\n", tokenImage[token.kind], token.kind, token.image);
            //Set the loaction info into the token and consume the token from the input
            token.beginLine = line;
            token.beginColumn = column;
            consumeInput(longest);
            token.endLine = line;
            token.endColumn = column;
            lastToken = token;
            return token;
        }

        throw new TokenMgrError(false, 0, line, column, lastToken == null ? "" : lastToken.image, input.charAt(0), TokenMgrError.LEXICAL_ERROR);
    }

    private void consumeInput(int length) {
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            column++;
            if (c == '\n') {
                column = 1;
                line++;
            }
        }
        input = input.substring(length);
    }
}
