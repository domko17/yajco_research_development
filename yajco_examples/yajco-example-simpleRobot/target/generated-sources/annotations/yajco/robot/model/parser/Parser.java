package yajco.robot.model.parser;

import yajco.robot.model.parser.beaver.ParserScanner;

public class Parser {
	private static yajco.robot.model.parser.beaver.Parser parser;

	public yajco.robot.model.Robot parse(String input) throws ParseException {
		ParserScanner scanner = new ParserScanner(input);
		if (parser == null) {
			parser = new yajco.robot.model.parser.beaver.Parser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			yajco.robot.model.Robot root = ((yajco.robot.model.parser.beaver.SymbolWrapper<yajco.robot.model.Robot>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (yajco.robot.model.parser.beaver.Parser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public yajco.robot.model.Robot parse(java.io.Reader reader) throws ParseException {
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