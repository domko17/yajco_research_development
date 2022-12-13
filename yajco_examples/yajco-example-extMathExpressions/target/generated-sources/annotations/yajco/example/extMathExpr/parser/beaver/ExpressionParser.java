package yajco.example.extMathExpr.parser.beaver;

import yajco.example.extMathExpr.parser.beaver.SymbolListImpl;
import yajco.example.extMathExpr.parser.beaver.SymbolWrapper;
import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "grammar.grammar".
 */
public class ExpressionParser extends Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short MINUS = 1;
		static public final short PLUS = 2;
		static public final short SYMBOL_40 = 3;
		static public final short VALUE = 4;
		static public final short QUESTION = 5;
		static public final short EXCL = 6;
		static public final short POWER = 7;
		static public final short PERC = 8;
		static public final short STAR = 9;
		static public final short SLASH = 10;
		static public final short SYMBOL_41 = 11;
		static public final short COLON = 12;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pDaZjF0p4GX0V2GLwN8o64PuWGFGL5ofIKALEcJ9ao9QAYG8YEtydx3LdcVEl8MVa7OEc" +
		"xySpQT$Rg0Do9e8eMIjXmb5570vlH34YYUMV9XVDLx60NUtAFVHoYZQE5hXMLXLytlc9ypV" +
		"ZK#Cpufl5RncyRVs1yLxs$QmwmmXibF6jEViiA#n79sDDwT6rjoONpbFtAsB6csrTYVxpwo" +
		"d$t$guvGEyIRfmLWZwfaa6UQ#rSHERK8UcI4IcJCMcJ2RacKt92PgJZzmVlkI0tv8hS1lcn" +
		"wgbgFwWD$1bKXweZrR7gH7Lglwlvp9yXo7e8Xdp9Ev#lv8KyaoVoI1vSVIw$yYFVd7sGD$b" +
		"aMFm7AVkRElKahkyPE#zfS4sCrX#2jL14");

	private final Action[] actions;

	public ExpressionParser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] $goal = Expression
			new Action() {	// [1] Expression = SYMBOL_40 Expression.val SYMBOL_41
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_val = _symbols[offset + 2];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> val = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_val.value;
					 return (Symbol) new SymbolWrapper(val.getWrappedObject());
				}
			},
			new Action() {	// [2] Expression = BinaryOperation.val
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_val = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.BinaryOperation> val = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.BinaryOperation>) _symbol_val.value;
					 return (Symbol) new SymbolWrapper(val.getWrappedObject());
				}
			},
			new Action() {	// [3] Expression = UnaryOperation.val
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_val = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.UnaryOperation> val = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.UnaryOperation>) _symbol_val.value;
					 return (Symbol) new SymbolWrapper(val.getWrappedObject());
				}
			},
			new Action() {	// [4] Expression = Number.val
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_val = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Number> val = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Number>) _symbol_val.value;
					 return (Symbol) new SymbolWrapper(val.getWrappedObject());
				}
			},
			new Action() {	// [5] Expression = Expression.expression1 QUESTION Expression.expression2 COLON Expression.expression3
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression1 = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression1 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression1.value;
					final Symbol _symbol_expression2 = _symbols[offset + 3];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression2 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression2.value;
					final Symbol _symbol_expression3 = _symbols[offset + 5];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression3 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression3.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Conditional(expression1.getWrappedObject(), expression2.getWrappedObject(), expression3.getWrappedObject()), (Object)expression1.getWrappedObject(), expression2.getWrappedObject(), expression3.getWrappedObject()));
				}
			},
			new Action() {	// [6] Number = VALUE.value
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 1];
					final java.lang.String value = (java.lang.String) _symbol_value.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Number(java.lang.Integer.valueOf(value)), (Object)java.lang.Integer.valueOf(value)));
				}
			},
			new Action() {	// [7] UnaryOperation = MINUS Expression.expression
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression = _symbols[offset + 2];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.UnaryMinus(expression.getWrappedObject()), (Object)expression.getWrappedObject()));
				}
			},
			new Action() {	// [8] UnaryOperation = Expression.expression EXCL
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Factorial(expression.getWrappedObject()), (Object)expression.getWrappedObject()));
				}
			},
			new Action() {	// [9] UnaryOperation = PLUS Expression.expression
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression = _symbols[offset + 2];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.UnaryPlus(expression.getWrappedObject()), (Object)expression.getWrappedObject()));
				}
			},
			new Action() {	// [10] BinaryOperation = Expression.expression1 POWER Expression.expression2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression1 = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression1 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression1.value;
					final Symbol _symbol_expression2 = _symbols[offset + 3];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression2 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression2.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Power(expression1.getWrappedObject(), expression2.getWrappedObject()), (Object)expression1.getWrappedObject(), expression2.getWrappedObject()));
				}
			},
			new Action() {	// [11] BinaryOperation = Expression.expression1 MINUS Expression.expression2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression1 = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression1 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression1.value;
					final Symbol _symbol_expression2 = _symbols[offset + 3];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression2 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression2.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Sub(expression1.getWrappedObject(), expression2.getWrappedObject()), (Object)expression1.getWrappedObject(), expression2.getWrappedObject()));
				}
			},
			new Action() {	// [12] BinaryOperation = Expression.expression1 PERC Expression.expression2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression1 = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression1 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression1.value;
					final Symbol _symbol_expression2 = _symbols[offset + 3];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression2 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression2.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Mod(expression1.getWrappedObject(), expression2.getWrappedObject()), (Object)expression1.getWrappedObject(), expression2.getWrappedObject()));
				}
			},
			new Action() {	// [13] BinaryOperation = Expression.expression1 STAR Expression.expression2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression1 = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression1 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression1.value;
					final Symbol _symbol_expression2 = _symbols[offset + 3];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression2 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression2.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Mul(expression1.getWrappedObject(), expression2.getWrappedObject()), (Object)expression1.getWrappedObject(), expression2.getWrappedObject()));
				}
			},
			new Action() {	// [14] BinaryOperation = Expression.expression1 SLASH Expression.expression2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression1 = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression1 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression1.value;
					final Symbol _symbol_expression2 = _symbols[offset + 3];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression2 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression2.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Div(expression1.getWrappedObject(), expression2.getWrappedObject()), (Object)expression1.getWrappedObject(), expression2.getWrappedObject()));
				}
			},
			new Action() {	// [15] BinaryOperation = Expression.expression1 PLUS Expression.expression2
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_expression1 = _symbols[offset + 1];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression1 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression1.value;
					final Symbol _symbol_expression2 = _symbols[offset + 3];
					final yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression> expression2 = (yajco.example.extMathExpr.parser.beaver.SymbolWrapper<yajco.example.extMathExpr.model.Expression>) _symbol_expression2.value;
					 return (Symbol) new SymbolWrapper(yajco.ReferenceResolver.getInstance().register(new yajco.example.extMathExpr.model.Add(expression1.getWrappedObject(), expression2.getWrappedObject()), (Object)expression1.getWrappedObject(), expression2.getWrappedObject()));
				}
			}
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}