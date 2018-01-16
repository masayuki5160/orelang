package orelang;

import java.util.List;

public interface IOperator {
	Object call(Engine engin, List<?> args);
}
