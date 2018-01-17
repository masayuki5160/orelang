package orelang;

import java.util.List;

public class SetOperator implements IOperator {

	// ex. (set "x" 1) => 1 変数 x に 1 が代入される
	@Override
	public Object call(Engine engine, List<?> args) {
		Object value = engine.eval(args.get(1));
		engine.variables.put((String)engine.eval(args.get(0)), value);
		return value;
	}

}
