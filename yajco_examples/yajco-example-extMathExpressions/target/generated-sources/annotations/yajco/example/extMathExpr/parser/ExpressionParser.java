package yajco.example.extMathExpr.parser;

import yajco.example.extMathExpr.parser.beaver.ExpressionParserScanner;

public class ExpressionParser {
	private static yajco.example.extMathExpr.parser.beaver.ExpressionParser parser;

	public yajco.example.extMathExpr.model.Expression parse(String input) throws ParseException {
		ExpressionParserScanner scanner = new ExpressionParserScanner(input);
		if (parser == null) {
			parser = new yajco.example.extMathExpr.parser.beaver.ExpressionParser();
		}

		try {
			yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
			yajco.example.extMathExpr.model.Expression root = ((yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) parser.parse(scanner)).getWrappedObject();
			referenceResolver.resolveReferences();
			return root;
		} catch (java.io.IOException e) {
			throw new ParseException("Problem parsing source code ", e);
		} catch (yajco.example.extMathExpr.parser.beaver.ExpressionParser.Exception e) {
			throw new ParseException("Problem parsing source code ", e);
		}
	}

	public yajco.example.extMathExpr.model.Expression parse(java.io.Reader reader) throws ParseException {
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