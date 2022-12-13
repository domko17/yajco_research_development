package yajco.example.desk.parser;

import yajco.example.desk.parser.beaver.DeskParserScanner;

public class DeskParser {
	private static yajco.example.desk.parser.beaver.DeskParser parser;

	public yajco.example.desk.model.Program parse(String input) throws ParseException {
		DeskParserScanner scanner = new DeskParserScanner(input);
		if (parser == null) {
			parser = new yajco.example.desk.parser.beaver.DeskParser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			yajco.example.desk.model.Program root = ((yajco.example.desk.parser.beaver.SymbolWrapper<yajco.example.desk.model.Program>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (yajco.example.desk.parser.beaver.DeskParser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public yajco.example.desk.model.Program parse(java.io.Reader reader) throws ParseException {
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