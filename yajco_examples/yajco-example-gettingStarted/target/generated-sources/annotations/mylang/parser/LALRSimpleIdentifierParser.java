package mylang.parser;

import mylang.parser.beaver.LALRSimpleIdentifierParserScanner;

public class LALRSimpleIdentifierParser {
	private static mylang.parser.beaver.LALRSimpleIdentifierParser parser;

	public mylang.SimpleIdentifier parse(String input) throws ParseException {
		LALRSimpleIdentifierParserScanner scanner = new LALRSimpleIdentifierParserScanner(input);
		if (parser == null) {
			parser = new mylang.parser.beaver.LALRSimpleIdentifierParser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			mylang.SimpleIdentifier root = ((mylang.parser.beaver.SymbolWrapper<mylang.SimpleIdentifier>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (mylang.parser.beaver.LALRSimpleIdentifierParser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public mylang.SimpleIdentifier parse(java.io.Reader reader) throws ParseException {
		try {
			return parse(readAsString(reader));
		} catch(java.io.IOException e) {
			throw new ParseException("Problem reading input file", e);
		}
	}

	private String readAsString(java.io.Reader r) throws java.io.IOException {
		StringBuilder sb = new StringBuilder();
		java.io.BufferedReader br = new java.io.BufferedReader(r);
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		return sb.toString();
	}
}