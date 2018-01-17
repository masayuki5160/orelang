package orelang;

import java.util.List;

public class StepOperator implements IOperator {

	@Override
	public Object call(Engine engine, List<?> args) {
		Object retVal = null;
		for(Object arg:args) {
			retVal = engine.eval(arg);
		}
		return retVal;
	}

}
