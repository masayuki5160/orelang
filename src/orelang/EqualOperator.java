package orelang;

import java.util.List;

public class EqualOperator implements IOperator {

	@Override
	public Object call(Engine engine, List<?> args) {
		return engine.eval(args.get(0)).equals(engine.eval(args.get(1)));
	}

}
