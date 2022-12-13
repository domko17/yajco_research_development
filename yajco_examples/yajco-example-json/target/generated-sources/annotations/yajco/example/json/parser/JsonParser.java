package yajco.example.json.parser;

import yajco.example.json.parser.beaver.JsonParserScanner;

public class JsonParser {
	private static yajco.example.json.parser.beaver.JsonParser parser;

	public yajco.example.json.model.JsonFile parse(String input) throws ParseException {
		JsonParserScanner scanner = new JsonParserScanner(input);
		if (parser == null) {
			parser = new yajco.example.json.parser.beaver.JsonParser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			yajco.example.json.model.JsonFile root = ((yajco.example.json.parser.beaver.SymbolWrapper<yajco.example.json.model.JsonFile>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (yajco.example.json.parser.beaver.JsonParser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public yajco.example.json.model.JsonFile parse(java.io.Reader reader) throws ParseException {
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