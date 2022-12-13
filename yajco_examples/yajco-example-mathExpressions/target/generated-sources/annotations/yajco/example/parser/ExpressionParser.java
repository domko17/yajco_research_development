package yajco.example.parser;

public class ExpressionParser {
  private static yajco.example.parser.javacc.ExpressionParser _parser;

  public yajco.example.expression.model.Expression parse(String input) throws ParseException {
    yajco.example.parser.javacc.ExpressionParserTokenManager tm = new yajco.example.parser.javacc.ExpressionParserTokenManager(input);
    if (_parser == null) {
      _parser = new yajco.example.parser.javacc.ExpressionParser(tm);
    } else {
      _parser.ReInit(tm);
    }

    try {
      yajco.ReferenceResolver referenceResolver = yajco.ReferenceResolver.createInstance();
      yajco.example.expression.model.Expression root = yajco.example.parser.javacc.ExpressionParser.parse();
      referenceResolver.resolveReferences();
      return root;
    } catch (yajco.example.parser.javacc.ParseException e) {
      throw new ParseException("Problem parsing source code ", e);
    }
  }

  public yajco.example.expression.model.Expression parse(java.io.Reader reader) throws ParseException {
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
