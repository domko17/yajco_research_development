package yajco.example.imperative.parser;

import yajco.example.imperative.parser.beaver.ParserScanner;

public class Parser {
	private static yajco.example.imperative.parser.beaver.Parser parser;

	public yajco.example.imperative.model.Program parse(String input) throws ParseException {
		ParserScanner scanner = new ParserScanner(input);
		if (parser == null) {
			parser = new yajco.example.imperative.parser.beaver.Parser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			yajco.example.imperative.model.Program root = ((yajco.example.imperative.parser.beaver.SymbolWrapper<yajco.example.imperative.model.Program>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (yajco.example.imperative.parser.beaver.Parser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public yajco.example.imperative.model.Program parse(java.io.Reader reader) throws ParseException {
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