package yajco.example.desk.model.visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import yajco.visitor.VisitorException;
import yajco.example.desk.model.Add;
import yajco.example.desk.model.Program;
import yajco.example.desk.model.Number;
import yajco.example.desk.model.Expression;
import yajco.example.desk.model.ConstUsage;
import yajco.example.desk.model.Constant;
import yajco.example.desk.model.Factor;

public class Visitor<P> {
    protected Set<Object> visited = new HashSet<Object>();

    public void visit(Object o, P p) {
        if (o instanceof Program) {
            enterVisit(o);
            visitProgram((Program) o, p);
            exitVisit(o);
        }
        else if (o instanceof Expression) {
            enterVisit(o);
            visitExpression((Expression) o, p);
            exitVisit(o);
        }
        else if (o instanceof Add) {
            enterVisit(o);
            visitAdd((Add) o, p);
            exitVisit(o);
        }
        else if (o instanceof Factor) {
            enterVisit(o);
            visitFactor((Factor) o, p);
            exitVisit(o);
        }
        else if (o instanceof Number) {
            enterVisit(o);
            visitNumber((Number) o, p);
            exitVisit(o);
        }
        else if (o instanceof ConstUsage) {
            enterVisit(o);
            visitConstUsage((ConstUsage) o, p);
            exitVisit(o);
        }
        else if (o instanceof Constant) {
            enterVisit(o);
            visitConstant((Constant) o, p);
            exitVisit(o);
        }
        else {
            throw new VisitorException("Not supported type " + o.getClass());
        }
    }
    protected void visitProgram(Program program, P p) {
        if (program != null) {
        if (program.getExpression() != null && enterVisit(program.getExpression())) {
            visitExpression(program.getExpression(), p);
            exitVisit(program.getExpression());
        }
        visitConstantsInProgram(program.getConstants(), p);
        }
    }

    protected void visitConstantsInProgram(Constant[]
 constants, P p) {
        for (Constant constant : constants) {
            if (enterVisit(constant)) {
                visitConstant(constant, p);
                exitVisit(constant);
        }
    }
    }

    protected void visitExpression(Expression expression, P p) {
        if (expression != null) {
        if (expression instanceof Add) {
            visitAdd((Add) expression, p);
        }
        else if (expression instanceof Factor) {
            visitFactor((Factor) expression, p);
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


    protected void visitFactor(Factor factor, P p) {
        if (factor != null) {
        if (factor instanceof Number) {
            visitNumber((Number) factor, p);
        }
        else if (factor instanceof ConstUsage) {
            visitConstUsage((ConstUsage) factor, p);
        }
        }
    }


    protected void visitNumber(Number number, P p) {
        if (number != null) {
        }
    }


    protected void visitConstUsage(ConstUsage constUsage, P p) {
        if (constUsage != null) {
        if (constUsage.getConstant() != null && enterVisit(constUsage.getConstant())) {
            visitConstant(constUsage.getConstant(), p);
            exitVisit(constUsage.getConstant());
        }
        }
    }


    protected void visitConstant(Constant constant, P p) {
        if (constant != null) {
        if (constant.getNumber() != null && enterVisit(constant.getNumber())) {
            visitNumber(constant.getNumber(), p);
            exitVisit(constant.getNumber());
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
