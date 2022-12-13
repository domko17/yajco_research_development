package yajco.robot.karel.parser;

import yajco.robot.karel.parser.beaver.ParserScanner;

public class Parser {
	private static yajco.robot.karel.parser.beaver.Parser parser;

	public yajco.robot.karel.model.Program parse(String input) throws ParseException {
		ParserScanner scanner = new ParserScanner(input);
		if (parser == null) {
			parser = new yajco.robot.karel.parser.beaver.Parser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			yajco.robot.karel.model.Program root = ((yajco.robot.karel.parser.beaver.SymbolWrapper<yajco.robot.karel.model.Program>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (yajco.robot.karel.parser.beaver.Parser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public yajco.robot.karel.model.Program parse(java.io.Reader reader) throws ParseException {
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