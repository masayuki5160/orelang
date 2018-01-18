package orelang.operator;

import java.util.List;

import orelang.Engine;
import orelang.IExpression;

public class CallOperator implements IExpression {
	
	private IOperator operator;
	private List<?> args;

	public CallOperator(IOperator operator, List<?> args) {
		this.operator = operator;
		this.args = args;
	}

	@Override
	public Object eval(Engine engine) {
		return operator.call(engine, args);
	}

}
