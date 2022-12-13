package yajco.example.extMathExpr.model.printer;

import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintWriter;
import yajco.example.extMathExpr.model.visitor.Visitor;

import yajco.example.extMathExpr.model.Add;
import yajco.example.extMathExpr.model.Sub;
import yajco.example.extMathExpr.model.Mod;
import yajco.example.extMathExpr.model.UnaryOperation;
import yajco.example.extMathExpr.model.Mul;
import yajco.example.extMathExpr.model.BinaryOperation;
import yajco.example.extMathExpr.model.UnaryPlus;
import yajco.example.extMathExpr.model.UnaryMinus;
import yajco.example.extMathExpr.model.Conditional;
import yajco.example.extMathExpr.model.Div;
import yajco.example.extMathExpr.model.Factorial;
import yajco.example.extMathExpr.model.Number;
import yajco.example.extMathExpr.model.Expression;
import yajco.example.extMathExpr.model.Power;

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
    protected void visitExpression(Expression expression, PrintWriter p) {
          printNonSpacedLiteral("(", p);
            if (expression instanceof BinaryOperation) {
            visitBinaryOperation((BinaryOperation) expression, p);
        }
            else if (expression instanceof UnaryOperation) {
            visitUnaryOperation((UnaryOperation) expression, p);
        }
            else if (expression instanceof Number) {
            visitNumber((Number) expression, p);
        }
            else if (expression instanceof Conditional) {
            visitConditional((Conditional) expression, p);
        }
            else {
            }
          printNonSpacedLiteral(")", p);
      }

      @Override
    protected void visitBinaryOperation(BinaryOperation binaryOperation, PrintWriter p) {
             if (binaryOperation instanceof Power) {
            visitPower((Power) binaryOperation, p);
        }
            else if (binaryOperation instanceof Sub) {
            visitSub((Sub) binaryOperation, p);
        }
            else if (binaryOperation instanceof Mod) {
            visitMod((Mod) binaryOperation, p);
        }
            else if (binaryOperation instanceof Mul) {
            visitMul((Mul) binaryOperation, p);
        }
            else if (binaryOperation instanceof Div) {
            visitDiv((Div) binaryOperation, p);
        }
            else if (binaryOperation instanceof Add) {
            visitAdd((Add) binaryOperation, p);
        }
            else {
            }
       }

      @Override
    protected void visitPower(Power power, PrintWriter p) {
                                                visitExpression(power.getExpression1(), p);
                                           printLiteral("POWER", p);
                                               visitExpression(power.getExpression2(), p);
                                   }

            @Override
    protected void visitSub(Sub sub, PrintWriter p) {
                                                visitExpression(sub.getExpression1(), p);
                                           printLiteral("MINUS", p);
                                               visitExpression(sub.getExpression2(), p);
                                   }

            @Override
    protected void visitMod(Mod mod, PrintWriter p) {
                                                visitExpression(mod.getExpression1(), p);
                                           printLiteral("PERC", p);
                                               visitExpression(mod.getExpression2(), p);
                                   }

            @Override
    protected void visitMul(Mul mul, PrintWriter p) {
                                                visitExpression(mul.getExpression1(), p);
                                           printLiteral("STAR", p);
                                               visitExpression(mul.getExpression2(), p);
                                   }

            @Override
    protected void visitDiv(Div div, PrintWriter p) {
                                                visitExpression(div.getExpression1(), p);
                                           printLiteral("SLASH", p);
                                               visitExpression(div.getExpression2(), p);
                                   }

            @Override
    protected void visitAdd(Add add, PrintWriter p) {
                                                visitExpression(add.getExpression1(), p);
                                           printLiteral("PLUS", p);
                                               visitExpression(add.getExpression2(), p);
                                   }

            @Override
    protected void visitUnaryOperation(UnaryOperation unaryOperation, PrintWriter p) {
             if (unaryOperation instanceof UnaryMinus) {
            visitUnaryMinus((UnaryMinus) unaryOperation, p);
        }
            else if (unaryOperation instanceof Factorial) {
            visitFactorial((Factorial) unaryOperation, p);
        }
            else if (unaryOperation instanceof UnaryPlus) {
            visitUnaryPlus((UnaryPlus) unaryOperation, p);
        }
            else {
            }
       }

      @Override
    protected void visitUnaryMinus(UnaryMinus unaryMinus, PrintWriter p) {
                            printLiteral("MINUS", p);
                                               visitExpression(unaryMinus.getExpression(), p);
                                   }

         @Override
    protected void visitFactorial(Factorial factorial, PrintWriter p) {
                                                visitExpression(factorial.getExpression(), p);
                                           printLiteral("EXCL", p);
                   }

         @Override
    protected void visitUnaryPlus(UnaryPlus unaryPlus, PrintWriter p) {
                            printLiteral("PLUS", p);
                                               visitExpression(unaryPlus.getExpression(), p);
                                   }

         @Override
    protected void visitNumber(Number number, PrintWriter p) {
                                           printLiteral(number.getValue(), p);
                              }

         @Override
    protected void visitConditional(Conditional conditional, PrintWriter p) {
                                                visitExpression(conditional.getExpression1(), p);
                                           printLiteral("QUESTION", p);
                                               visitExpression(conditional.getExpression2(), p);
                                           printLiteral("COLON", p);
                                               visitExpression(conditional.getExpression3(), p);
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
        tokens.put("PLUS".toUpperCase(), "\\+");
        tokens.put("MINUS".toUpperCase(), "-");
        tokens.put("STAR".toUpperCase(), "\\*");
        tokens.put("SLASH".toUpperCase(), "/");
        tokens.put("PERC".toUpperCase(), "%");
        tokens.put("EXCL".toUpperCase(), "!");
        tokens.put("POWER".toUpperCase(), "\\^");
        tokens.put("TILDE".toUpperCase(), "~");
        tokens.put("QUESTION".toUpperCase(), "\\?");
        tokens.put("COLON".toUpperCase(), ":");
        tokens.put("EQ".toUpperCase(), "==");
        tokens.put("NEQ".toUpperCase(), "!=");
        tokens.put("ASS".toUpperCase(), "=");
        tokens.put("LPAR".toUpperCase(), "[(]");
        tokens.put("RPAR".toUpperCase(), "[)]");
        tokens.put("VALUE".toUpperCase(), "([0-9]+)");
    }
}
