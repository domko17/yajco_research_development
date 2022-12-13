package yajco.example.extMathExpr.model.visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import yajco.visitor.VisitorException;
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

public class Visitor<P> {
    protected Set<Object> visited = new HashSet<Object>();

    public void visit(Object o, P p) {
        if (o instanceof Expression) {
            enterVisit(o);
            visitExpression((Expression) o, p);
            exitVisit(o);
        }
        else if (o instanceof BinaryOperation) {
            enterVisit(o);
            visitBinaryOperation((BinaryOperation) o, p);
            exitVisit(o);
        }
        else if (o instanceof Power) {
            enterVisit(o);
            visitPower((Power) o, p);
            exitVisit(o);
        }
        else if (o instanceof Sub) {
            enterVisit(o);
            visitSub((Sub) o, p);
            exitVisit(o);
        }
        else if (o instanceof Mod) {
            enterVisit(o);
            visitMod((Mod) o, p);
            exitVisit(o);
        }
        else if (o instanceof Mul) {
            enterVisit(o);
            visitMul((Mul) o, p);
            exitVisit(o);
        }
        else if (o instanceof Div) {
            enterVisit(o);
            visitDiv((Div) o, p);
            exitVisit(o);
        }
        else if (o instanceof Add) {
            enterVisit(o);
            visitAdd((Add) o, p);
            exitVisit(o);
        }
        else if (o instanceof UnaryOperation) {
            enterVisit(o);
            visitUnaryOperation((UnaryOperation) o, p);
            exitVisit(o);
        }
        else if (o instanceof UnaryMinus) {
            enterVisit(o);
            visitUnaryMinus((UnaryMinus) o, p);
            exitVisit(o);
        }
        else if (o instanceof Factorial) {
            enterVisit(o);
            visitFactorial((Factorial) o, p);
            exitVisit(o);
        }
        else if (o instanceof UnaryPlus) {
            enterVisit(o);
            visitUnaryPlus((UnaryPlus) o, p);
            exitVisit(o);
        }
        else if (o instanceof Number) {
            enterVisit(o);
            visitNumber((Number) o, p);
            exitVisit(o);
        }
        else if (o instanceof Conditional) {
            enterVisit(o);
            visitConditional((Conditional) o, p);
            exitVisit(o);
        }
        else {
            throw new VisitorException("Not supported type " + o.getClass());
        }
    }
    protected void visitExpression(Expression expression, P p) {
        if (expression != null) {
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
        }
    }


    protected void visitBinaryOperation(BinaryOperation binaryOperation, P p) {
        if (binaryOperation != null) {
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
        }
    }


    protected void visitPower(Power power, P p) {
        if (power != null) {
        if (power.getExpression1() != null && enterVisit(power.getExpression1())) {
            visitExpression(power.getExpression1(), p);
            exitVisit(power.getExpression1());
        }
        if (power.getExpression2() != null && enterVisit(power.getExpression2())) {
            visitExpression(power.getExpression2(), p);
            exitVisit(power.getExpression2());
        }
        }
    }


    protected void visitSub(Sub sub, P p) {
        if (sub != null) {
        if (sub.getExpression1() != null && enterVisit(sub.getExpression1())) {
            visitExpression(sub.getExpression1(), p);
            exitVisit(sub.getExpression1());
        }
        if (sub.getExpression2() != null && enterVisit(sub.getExpression2())) {
            visitExpression(sub.getExpression2(), p);
            exitVisit(sub.getExpression2());
        }
        }
    }


    protected void visitMod(Mod mod, P p) {
        if (mod != null) {
        if (mod.getExpression1() != null && enterVisit(mod.getExpression1())) {
            visitExpression(mod.getExpression1(), p);
            exitVisit(mod.getExpression1());
        }
        if (mod.getExpression2() != null && enterVisit(mod.getExpression2())) {
            visitExpression(mod.getExpression2(), p);
            exitVisit(mod.getExpression2());
        }
        }
    }


    protected void visitMul(Mul mul, P p) {
        if (mul != null) {
        if (mul.getExpression1() != null && enterVisit(mul.getExpression1())) {
            visitExpression(mul.getExpression1(), p);
            exitVisit(mul.getExpression1());
        }
        if (mul.getExpression2() != null && enterVisit(mul.getExpression2())) {
            visitExpression(mul.getExpression2(), p);
            exitVisit(mul.getExpression2());
        }
        }
    }


    protected void visitDiv(Div div, P p) {
        if (div != null) {
        if (div.getExpression1() != null && enterVisit(div.getExpression1())) {
            visitExpression(div.getExpression1(), p);
            exitVisit(div.getExpression1());
        }
        if (div.getExpression2() != null && enterVisit(div.getExpression2())) {
            visitExpression(div.getExpression2(), p);
            exitVisit(div.getExpression2());
        }
        }
    }


    protected void visitAdd(Add add, P p) {
        if (add != null) {
        if (add.getExpression1() != null && enterVisit(add.getExpression1())) {
            visitExpression(add.getExpression1(), p);
            exitVisit(add.getExpression1());
        }
        if (add.getExpression2() != null && enterVisit(add.getExpression2())) {
            visitExpression(add.getExpression2(), p);
            exitVisit(add.getExpression2());
        }
        }
    }


    protected void visitUnaryOperation(UnaryOperation unaryOperation, P p) {
        if (unaryOperation != null) {
        if (unaryOperation instanceof UnaryMinus) {
            visitUnaryMinus((UnaryMinus) unaryOperation, p);
        }
        else if (unaryOperation instanceof Factorial) {
            visitFactorial((Factorial) unaryOperation, p);
        }
        else if (unaryOperation instanceof UnaryPlus) {
            visitUnaryPlus((UnaryPlus) unaryOperation, p);
        }
        }
    }


    protected void visitUnaryMinus(UnaryMinus unaryMinus, P p) {
        if (unaryMinus != null) {
        if (unaryMinus.getExpression() != null && enterVisit(unaryMinus.getExpression())) {
            visitExpression(unaryMinus.getExpression(), p);
            exitVisit(unaryMinus.getExpression());
        }
        }
    }


    protected void visitFactorial(Factorial factorial, P p) {
        if (factorial != null) {
        if (factorial.getExpression() != null && enterVisit(factorial.getExpression())) {
            visitExpression(factorial.getExpression(), p);
            exitVisit(factorial.getExpression());
        }
        }
    }


    protected void visitUnaryPlus(UnaryPlus unaryPlus, P p) {
        if (unaryPlus != null) {
        if (unaryPlus.getExpression() != null && enterVisit(unaryPlus.getExpression())) {
            visitExpression(unaryPlus.getExpression(), p);
            exitVisit(unaryPlus.getExpression());
        }
        }
    }


    protected void visitNumber(Number number, P p) {
        if (number != null) {
        }
    }


    protected void visitConditional(Conditional conditional, P p) {
        if (conditional != null) {
        if (conditional.getExpression1() != null && enterVisit(conditional.getExpression1())) {
            visitExpression(conditional.getExpression1(), p);
            exitVisit(conditional.getExpression1());
        }
        if (conditional.getExpression2() != null && enterVisit(conditional.getExpression2())) {
            visitExpression(conditional.getExpression2(), p);
            exitVisit(conditional.getExpression2());
        }
        if (conditional.getExpression3() != null && enterVisit(conditional.getExpression3())) {
            visitExpression(conditional.getExpression3(), p);
            exitVisit(conditional.getExpression3());
        }
        }
    }



    protected boolean enterVisit(Object o) {
        return visited.add(o);
    }

    protected boolean exitVisit(Object o) {
        return visited.remove(o);
    }
}
