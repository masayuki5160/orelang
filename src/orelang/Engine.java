package orelang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Engine {
	
	private Map<String, IOperator> operators = new HashMap<String, IOperator>();

	public Engine() {
		operators.put("+", new AddOperator());
		operators.put("*", new MultiplyOperator());
		operators.put("=", new EqualOperator());
		operators.put("set", new SetOperator());
		operators.put("get", new GetOperator());
		operators.put("until", new UntilOperator());
		operators.put("step", new StepOperator());
	}
	
	public Object eval(Object script) {
		return getExpression(script).eval(this);
	}

	private IExpression getExpression(Object script) {
		if(script instanceof List) {
			List<?> scriptList = (List<?>)script;
			return new CallOperator(operators.get(scriptList.get(0)), scriptList.subList(1, scriptList.size()));
		}else {
			return new ImmediateValue(script);
		}
	}
}