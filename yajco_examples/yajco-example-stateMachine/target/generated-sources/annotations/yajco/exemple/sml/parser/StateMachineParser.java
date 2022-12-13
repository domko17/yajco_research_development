package yajco.exemple.sml.parser;

import yajco.exemple.sml.parser.beaver.StateMachineParserScanner;

public class StateMachineParser {
	private static yajco.exemple.sml.parser.beaver.StateMachineParser parser;

	public yajco.example.sml.model.StateMachine parse(String input) throws ParseException {
		StateMachineParserScanner scanner = new StateMachineParserScanner(input);
		if (parser == null) {
			parser = new yajco.exemple.sml.parser.beaver.StateMachineParser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			yajco.example.sml.model.StateMachine root = ((yajco.exemple.sml.parser.beaver.SymbolWrapper<yajco.example.sml.model.StateMachine>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (yajco.exemple.sml.parser.beaver.StateMachineParser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public yajco.example.sml.model.StateMachine parse(java.io.Reader reader) throws ParseException {
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