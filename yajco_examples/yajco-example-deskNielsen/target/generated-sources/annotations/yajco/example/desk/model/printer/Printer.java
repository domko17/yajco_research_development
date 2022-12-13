package yajco.example.desk.model.printer;

import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintWriter;
import yajco.example.desk.model.visitor.Visitor;

import yajco.example.desk.model.Add;
import yajco.example.desk.model.Program;
import yajco.example.desk.model.Number;
import yajco.example.desk.model.Expression;
import yajco.example.desk.model.ConstUsage;
import yajco.example.desk.model.Constant;
import yajco.example.desk.model.Factor;

public class Printer extends Visitor<PrintWriter> {
    private final String WHITE_SPACE = " ";
    private String indentString = "    "; //4 spaces
    private int indent = 0;
    private boolean inNewLine = true;

    public void print(Object o, PrintWriter writer) {
        inNewLine = true;
        visit(o, writer);
        writer.println();
        writer.flush();
    }

    @Override
    protected void visitProgram(Program program, PrintWriter p) {
              if (
                                  program.getExpression() != null
                                            && program.getConstants() != null
                          && program.getConstants().length >= 1
                                                  ) { printProgramNotation1(program, p); }
             else if (
                                  program.getExpression() != null
                    ) { printProgramNotation0(program, p); }
             else {
            throw new IllegalStateException("Cannot find proper notation for printing concept Program");
        }
         }

       protected void printProgramNotation0(Program program, PrintWriter p) {
                     printLiteral("print", p);
                                               visitExpression(program.getExpression(), p);
                             }
      protected void printProgramNotation1(Program program, PrintWriter p) {
                     printLiteral("print", p);
                                               visitExpression(program.getExpression(), p);
                                           printLiteral("where", p);
                                               visitConstantsInProgram(program.getConstants(), p);
                             }
                @Override
    protected void visitConstantsInProgram(Constant[]
 constants, PrintWriter p) {
                boolean separate = false;
            for (Constant constant : constants) {
                if (separate) {
                printNonSpacedLiteral(",", p);
            }
                visitConstant(constant, p);
                separate = true;
            }
    }

          @Override
    protected void visitExpression(Expression expression, PrintWriter p) {
          printNonSpacedLiteral("(", p);
            if (expression instanceof Add) {
            visitAdd((Add) expression, p);
        }
            else if (expression instanceof Factor) {
            visitFactor((Factor) expression, p);
        }
            else {
            }
          printNonSpacedLiteral(")", p);
      }

      @Override
    protected void visitAdd(Add add, PrintWriter p) {
                                                visitExpression(add.getExpression1(), p);
                                           printLiteral("+", p);
                                               visitExpression(add.getExpression2(), p);
                                   }

            @Override
    protected void visitFactor(Factor factor, PrintWriter p) {
             if (factor instanceof Number) {
            visitNumber((Number) factor, p);
        }
            else if (factor instanceof ConstUsage) {
            visitConstUsage((ConstUsage) factor, p);
        }
            else {
            }
       }

      @Override
    protected void visitNumber(Number number, PrintWriter p) {
                                           printLiteral(number.getValue(), p);
                              }

         @Override
    protected void visitConstUsage(ConstUsage constUsage, PrintWriter p) {
                                                      printLiteral(constUsage.getConstant().getName(), p);
                                   }

         @Override
    protected void visitConstant(Constant constant, PrintWriter p) {
                                           printLiteral(constant.getName(), p);
                                      printLiteral("=", p);
                                               visitNumber(constant.getNumber(), p);
                                   }

            protected void newLine(PrintWriter p) {
        p.println();
        for (int i = 0; i < indent; i++) {
            p.print(indentString);
        }
        inNewLine = true;
    }

    protected void increaseIndent() {
        if (indent != Integer.MAX_VALUE) {
            indent++;
        }
    }
    protected void increaseIndent(int level) {
        changeIndent(level);
    }

    protected void decreaseIndent(int level) {
        changeIndent(-level);
    }

    protected void changeIndent(int level) {
        indent = indent + level;
        if (indent < 0) {
            if (level > 0) { //pripocitavali sme, muselo pretiect
                indent = Integer.MAX_VALUE;
            } else {
                indent = 0;
            }
        }
    }

    protected void decreaseIndent() {
        if (indent > 0) {
            indent--;
        }
    }

    public String getIndentString() {
        return indentString;
    }

    public void setIndentString(String indentString) {
        this.indentString = indentString;
    }

    protected void printLiteral(String literal, PrintWriter p) {
        if (!inNewLine) {
            p.write(WHITE_SPACE);
        } else {
            inNewLine = false;
        }
        printNonSpacedLiteral(literal, p);
    }

    protected void printLiteral(int number, PrintWriter p) {
        printLiteral(String.valueOf(number), p);
    }

    protected void printLiteral(long number, PrintWriter p) {
        printLiteral(String.valueOf(number), p);
    }

    protected void printLiteral(float number, PrintWriter p) {
        printLiteral(String.valueOf(number), p);
    }

    protected void printLiteral(double number, PrintWriter p) {
        printLiteral(String.valueOf(number), p);
    }

    protected void printLiteral(boolean number, PrintWriter p) {
        printLiteral(String.valueOf(number), p);
    }

    protected void printLiteral(char number, PrintWriter p) {
        printLiteral(String.valueOf(number), p);
    }

    protected void printLiteral(char[] number, PrintWriter p) {
        printLiteral(String.valueOf(number), p);
    }

    protected void printLiteral(String[] idents, PrintWriter p) {
        for (String string : idents) {
            printLiteral(string, p);
        }
    }

    protected void printNonSpacedLiteral(String literal, PrintWriter p) {
        if (tokens.containsKey(literal.toUpperCase())) {
            //p.write(PrinterHelper.generateExpressionFromRegex(tokens.get(literal.toUpperCase())));
            p.write(tokens.get(literal.toUpperCase()));
        } else {
            p.write(literal);
        }
        if (inNewLine) {
            inNewLine = false;
        }
    }

    private Map<String, String> tokens = new HashMap<String, String>();
    {
        tokens.put("NAME".toUpperCase(), "[a-zA-Z]+");
        tokens.put("VALUE".toUpperCase(), "[0-9]+");
    }
}
