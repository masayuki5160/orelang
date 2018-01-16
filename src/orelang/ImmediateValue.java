package orelang;

public class ImmediateValue implements IExpression {
	
	private Object value;

	public ImmediateValue(Object value) {
		this.value = value;
	}

	@Override
	public Object eval(Engine engine) {
		return value;
	}

}
